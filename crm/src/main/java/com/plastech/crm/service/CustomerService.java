package com.plastech.crm.service;

import java.util.List;
import java.util.Map;
import com.plastech.crm.model.parameter.AddOrUpdateCustomerParameters;
import com.plastech.crm.model.vo.ContractCustomerView;
import com.plastech.crm.model.vo.CustomerBaseDetailView;
import com.plastech.crm.model.vo.CustomerView;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.util.AppPage;

/**
 * @author wangJin
 *
 * @date 2019年1月23日 下午3:30:32
 *
 */
public interface CustomerService {
  AppPage<List<CustomerView>> searchCustomerList(Map<String, String> param,
      Integer currentpage, Integer perpage);

  ResultJson<Boolean> addCustomer(AddOrUpdateCustomerParameters param,
      Long uid);

  Map<String,String> updateCustomer(Long cuid,
      AddOrUpdateCustomerParameters param, Long uid);

  ResultJson<Boolean> deleteCustomer(Long cuid);

  List<ContractCustomerView> getContractCustomerList();

  CustomerBaseDetailView getCustomerBaseDetail(Long cuid);

  List<Map<String,Object>> getGroupsContractRelationNumberByGid(Long cuid);

}
