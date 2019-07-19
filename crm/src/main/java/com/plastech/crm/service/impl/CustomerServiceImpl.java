package com.plastech.crm.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.plastech.crm.model.Customer;
import com.plastech.crm.model.Linkman;
import com.plastech.crm.model.MiddleCustomerLinkman;
import com.plastech.crm.model.parameter.AddOrUpdateCustomerParameters;
import com.plastech.crm.model.parameter.AddOrUpdateLinkmanParameter;
import com.plastech.crm.model.vo.ContractCustomerView;
import com.plastech.crm.model.vo.CustomerBaseDetailView;
import com.plastech.crm.model.vo.CustomerView;
import com.plastech.crm.resultcode.ResultCodeCustomer;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crm.service.CustomerService;
import com.plastech.crm.util.AppPage;
import com.plastech.crm.util.CommonTools;

/**
 * @author wangJin
 *
 * @date 2019年1月23日 下午3:30:51
 *
 */
@Service
public class CustomerServiceImpl extends BaseService
    implements CustomerService {

  @Override
  public AppPage<List<CustomerView>> searchCustomerList(
      final Map<String, String> param, final Integer currentpage,
      final Integer perpage) {
    final AppPage<List<CustomerView>> page =
        new AppPage<>(perpage, currentpage);
    page.start();
    final List<CustomerView> list = customerMapper.searchCustomerList(param);
    page.setResult(list);
    return page;
  }

  @Override
  public ResultJson<Boolean> addCustomer(
      final AddOrUpdateCustomerParameters param, final Long uid) {
    try {
      final Boolean isExist = customerMapper
          .checkBranchDoesItExist(param.getCuName(), param.getGid());
      if (isExist) {
        return ResultUtil.getResult(ResultCodeCustomer.RESULT_CODE_7001302);
      }
      final Customer customer = new Customer();
      AddOrUpdateCustomer(param, uid, null, customer);

      if (customer.getCuid() == null || customer.getCuid().longValue() <= 0) {
        return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0);
      }
      // 添加联系人
      addOrUpdateLinkman(uid, customer.getCuid(), param.getLinkmanList());
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, true,
          ResultCodeSystem.ADD_SUCCESS);
    } catch (final Exception e) {
      logger.info("add Customer Exception:{}", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, true,
        ResultCodeSystem.ADD_FAIL);
  }

  private void AddOrUpdateCustomer(final AddOrUpdateCustomerParameters param,
      final Long uid, final Long cuid, final Customer customer) {

    if (cuid == null) {
      customer.setCreatorId(uid);
      customer.setCreatorTime(new Date());
      customer.setStatus(0);
    }
    customer.setGid(param.getGid());
    customer.setCuName(param.getCuName());
    customer.setCuAddress(param.getCuAddress());
    customer.setLastUpdateId(uid);
    customer.setLastUpdateTime(new Date());
    customer.setNote(param.getNote());
    if (cuid == null) {
      customerMapper.insertSelective(customer);
    } else {
      customer.setCuid(cuid);
      customerMapper.updateByPrimaryKeySelective(customer);
    }
  }

  @Override
  public Map<String, String> updateCustomer(final Long cuid,
      final AddOrUpdateCustomerParameters param, final Long uid) {
    try {
      final Map<String, String> map = new HashMap<>();
      final Customer customerInfo = customerMapper.selectByPrimaryKey(cuid);
      if (customerInfo == null) {
        map.put("code", "302");
        return map;
      }
      final Customer customer = CommonTools.deepCloneObject(customerInfo);
      AddOrUpdateCustomer(param, uid, cuid, customer);
      // 修改合同最终客户id
      contractMapper.updateContractByCuid(param.getGid(), cuid);
      // 删除关联数据
      middleCustomerLinkmanMapper.deleteCustomerLinkmanInfoByCuid(cuid);
      // 编辑联系人
      addOrUpdateLinkman(uid, customer.getCuid(), param.getLinkmanList());

      final String shipmt_e =
          contractGradeMapper.selectEarliestContractGradeShipmt();
      final String shipmt_l =
          contractGradeMapper.selectLatestContractGradeShipmt();
      map.put("shipmt_e", shipmt_e);
      map.put("shipmt_l", shipmt_l);
      return map;
    } catch (final Exception e) {
      logger.info("update customer:{}", e);
    }
    return null;
  }

  @Override
  public ResultJson<Boolean> deleteCustomer(final Long cuid) {
    try {
      final Customer customer = customerMapper.selectByPrimaryKey(cuid);
      if (customer == null) {
        return ResultUtil.getResult(ResultCodeCustomer.RESULT_CODE_7003300);
      }
      customer.setStatus(-1);
      customerMapper.updateByPrimaryKey(customer);
      // 删除关联数据
      middleCustomerLinkmanMapper.deleteCustomerLinkmanInfoByCuid(cuid);
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, true,
          ResultCodeSystem.DELETE_SUCCESS);
    } catch (final Exception e) {
      logger.info("delete customer Exception:{}", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, false,
        ResultCodeSystem.DELETE_FAIL);
  }

  @Override
  public List<ContractCustomerView> getContractCustomerList() {
    try {
      return customerMapper.getContractCustomerList();
    } catch (final Exception e) {
      logger.info("select customer Exception:{}", e);
    }
    return null;
  }

  private void addOrUpdateLinkman(final Long uid, final Long cuid,
      final List<AddOrUpdateLinkmanParameter> LinkmanList) {
    for (final AddOrUpdateLinkmanParameter param : LinkmanList) {
      final Linkman linkman = new Linkman();
      linkman.setName(param.getName());
      linkman.setLkPosition(param.getLkPosition());
      linkman.setLkArea(param.getLkArea());
      linkman.setLkPhone(param.getLkPhone());
      linkman.setLkMail(param.getLkMail());
      linkman.setLkTags(param.getLkTags());
      linkman.setNote(param.getNote());
      linkman.setLastUpdateId(uid);
      linkman.setLastUpdateTime(new Date());
      linkman.setStatus(0);
      linkman.setCreatorId(uid);
      linkman.setCreatorTime(new Date());
      linkmanMapper.insertSelective(linkman);
      createMiddleCustomerLinkman(linkman.getLkid(), cuid, uid);
    }
  }

  private void createMiddleCustomerLinkman(final Long lkid, final Long cuid,
      final Long uid) {
    final MiddleCustomerLinkman customerLinkman = new MiddleCustomerLinkman();
    customerLinkman.setCuid(cuid);
    customerLinkman.setLkid(lkid);
    customerLinkman.setCreatorTime(new Date());
    middleCustomerLinkmanMapper.insertSelective(customerLinkman);
  }

  @Override
  public CustomerBaseDetailView getCustomerBaseDetail(final Long cuid) {
    return customerMapper.getCustomerBaseDetail(cuid);
  }

  @Override
  public List<Map<String, Object>> getGroupsContractRelationNumberByGid(
      final Long cuid) {
    return customerMapper.getGroupsContractRelationNumberByGid(cuid);
  }
}
