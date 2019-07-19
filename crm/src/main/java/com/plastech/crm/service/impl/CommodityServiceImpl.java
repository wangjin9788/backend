package com.plastech.crm.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;
import com.plastech.crm.model.Commodity;
import com.plastech.crm.model.vo.CommodityView;
import com.plastech.crm.resultcode.ResultCodeCommodity;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crm.service.CommodityService;
import com.plastech.crm.util.AppPage;
import com.plastech.crmcommon.page.AppPageModel;

/**
 * @author 王进
 *
 */
@Service
public class CommodityServiceImpl extends BaseService
    implements CommodityService {

  @Override
  public AppPageModel<List<CommodityView>> searchCommodity(
      final Integer currentpage, final Integer perpage,
      final String searchKey) {
    final AppPage<List<CommodityView>> page =
        new AppPage<>(perpage, currentpage);
    page.start();
    String searchkey = null;
    if (!Strings.isNullOrEmpty(searchKey)) {
      searchkey = "%" + searchKey + "%";
    }
    final List<CommodityView> searchCommodity =
        commodityMapper.searchCommodity(searchkey);
    page.setResult(searchCommodity);
    return page.convertToAppPageModel();
  }

  @Override
  public ResultJson<Integer> createCommodity(final Long uid,
      final String name) {
    try {
      // 查询品类名称是否存在
      final String checkName = commodityMapper.selectCommodityName(name);
      if (!Strings.isNullOrEmpty(checkName)) {
        return ResultUtil.getResult(ResultCodeCommodity.RESULT_CODE_3001300);
      }
      final Commodity comm = new Commodity();
      comm.setStatus(0);
      comm.setName(name);
      comm.setCreatorId(uid);
      comm.setCreatorTime(new Date());
      commodityMapper.insertSelective(comm);
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, 0,
          ResultCodeSystem.ADD_SUCCESS);
    } catch (final Exception e) {
      logger.info("create Commodity error:{}", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, -1,
        ResultCodeSystem.ADD_FAIL);
  }

  @Override
  public ResultJson<Integer> deleteCommodity(final Long ctId) {
    try {
      final Commodity commodityInfo = commodityMapper.selectByPrimaryKey(ctId);
      if (commodityInfo == null) {
        return ResultUtil.getResult(ResultCodeCommodity.RESULT_CODE_3002300);
      }
      // 检查该品类是否和牌号有关系
      final Boolean isPresence = gradeMapper.checkCommodityByCtId(ctId);
      if (isPresence) {
        return ResultUtil.getResult(ResultCodeCommodity.RESULT_CODE_3002301);
      }
      commodityInfo.setStatus(-1);
      commodityMapper.updateByPrimaryKeySelective(commodityInfo);
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, 0,
          ResultCodeSystem.DELETE_SUCCESS);
    } catch (final Exception e) {
      logger.info("delete error:{}", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, -1,
        ResultCodeSystem.DELETE_FAIL);
  }

  @Override
  public List<CommodityView> getCommodityChooseList() {
    return commodityMapper.getCommodityChooseList();
  }

}
