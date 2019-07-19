package com.plastech.crm.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;
import com.plastech.crm.model.Loyalty;
import com.plastech.crm.model.parameter.AddLoyaltyParameters;
import com.plastech.crm.model.parameter.ExchangeDataOrderParameters;
import com.plastech.crm.model.vo.LoyaltyDurationView;
import com.plastech.crm.model.vo.LoyaltyView;
import com.plastech.crm.resultcode.ResultCodeLoyalty;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crm.service.LoyaltyService;
import com.plastech.crm.util.CommonThreadPool;
import com.plastech.crm.util.thread.CustomerLoyaltyThread;

/**
 * @author wangJin
 *
 * @date 2019年1月22日 上午9:37:21
 *
 */
@Service
public class LoyaltyServiceImpl extends BaseService implements LoyaltyService {

  @Override
  public List<LoyaltyView> getLoyaltyList(final Integer type) {
    try {
      final List<LoyaltyView> loyaltyList = loyaltyMapper.getLoyaltyList(type);
      return loyaltyList;
    } catch (final Exception e) {
      logger.info("loyalty Exception:{}", e);
    }
    return null;
  }

  @Override
  public Integer addLoyalty(final AddLoyaltyParameters param, final Long uid) {
    try {
      final Boolean checkName = loyaltyMapper.checkLoyaltyName(param.getName());
      if (checkName) {
        return 1;
      }
      final Loyalty loyalty = new Loyalty();
      loyalty.setName(param.getName());
      loyalty.setMinFrequency(param.getMinFrequency());
      loyalty.setMaxFrequency(param.getMaxFrequency());
      loyalty.setDuration(param.getDuration());
      loyalty.setCreatorTime(new Date());
      loyalty.setCreatorId(uid);
      final int checkAddloyalt = loyaltyMapper.insertSelective(loyalty);
      if (checkAddloyalt <= 0) {
        return -1;
      }
      loyaltyMapper.updateLoyaltyBylId(loyalty.getLid());
      return 0;
    } catch (final Exception e) {
      logger.info("addLoyalty exception:{}", e);
    }
    return -1;
  }

  @Override
  public Integer deleteLoyalty(final Long lid) {
    try {
      final Loyalty loyaltyInfo = loyaltyMapper.selectByPrimaryKey(lid);
      if (loyaltyInfo == null) {
        return 1;
      }
      loyaltyInfo.setStatus(-1);
      loyaltyMapper.updateByPrimaryKey(loyaltyInfo);
      return 0;
    } catch (final Exception e) {
      logger.info("delete Loyalty Exception:{}", e);
    }
    return -1;
  }

  @Override
  public ResultJson<Boolean> exchangeLoyaltyOrder(
      final ExchangeDataOrderParameters param) {
    try {
      final Loyalty orderA =
          loyaltyMapper.selectByPrimaryKey(param.getOrderIdA());
      if (orderA == null || orderA.getStatus() == -1) {
        return ResultUtil.getResult(ResultCodeLoyalty.RESULT_CODE_6003300);
      }
      final Loyalty orderB =
          loyaltyMapper.selectByPrimaryKey(param.getOrderIdB());
      if (orderB == null || orderB.getStatus() == -1) {
        return ResultUtil.getResult(ResultCodeLoyalty.RESULT_CODE_6003300);
      }
      final Integer priority = orderA.getPriority();
      orderA.setPriority(orderB.getPriority());
      orderB.setPriority(priority);
      loyaltyMapper.updateByPrimaryKeySelective(orderA);
      loyaltyMapper.updateByPrimaryKeySelective(orderB);
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, true,
          ResultCodeSystem.UPLOAD_SUCCESS);
    } catch (final Exception e) {
      logger.info("order Exception:{}", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, false,
        ResultCodeSystem.UPLOAD_FAIL);
  }


  @Override
  public Boolean loyaltyTakesEffect(final Long uid) {
    try {

      // 获取忠诚度信息
      final List<LoyaltyView> loyaltyInfo = getLoyaltyList(1);
      //获取默认忠诚度，没有就新增
      final Long lid = getDefaultLoyalty();
      final LoyaltyDurationView durationView = loyaltyMapper.getDurationParameter();
      CommonThreadPool.addTaskToFixedQueue(new CustomerLoyaltyThread(
          loyaltyInfo, loyaltyMapper, customerLoyaltyMapper, uid,lid,durationView));
      return true;
    } catch (final Exception e) {
      logger.info("Loyalty Failure:{}", e);
    }
    return false;
  }

  private Long getDefaultLoyalty() {
     Loyalty loyalty = loyaltyMapper.getDefaultLoyalty();
    if(loyalty==null|| Strings.isNullOrEmpty(loyalty.getNote())){
      loyalty = new Loyalty();
      loyalty.setPriority(100000);
      loyalty.setName("N");
      loyalty.setNote("default");
      loyalty.setStatus(0);
      loyalty.setCreatorTime(new Date());
      loyaltyMapper.insert(loyalty);
    }
    return loyalty.getLid();
  }

}
