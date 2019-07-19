package com.plastech.crm.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.Customer;
import com.plastech.crm.model.vo.ContractCustomerView;
import com.plastech.crm.model.vo.CustomerBaseDetailView;
import com.plastech.crm.model.vo.CustomerView;
import com.plastech.crm.model.vo.ExportSupplierAndGroupsView;

public interface CustomerMapper extends BaseTkMapper<Customer> {

  List<CustomerView> searchCustomerList(Map<String, String> param);

  Boolean checkBranchDoesItExist(@Param(value = "name") String name,
      @Param(value = "gid") Long gid);

  Customer selectByName(@Param(value = "name") String name,
      @Param(value = "gid") Long gid);

  List<ContractCustomerView> getContractCustomerList();

  CustomerBaseDetailView getCustomerBaseDetail(Long cuid);

  List<Map<String, Object>> getGroupsContractRelationNumberByGid(
      @Param(value = "cuid") Long cuid);

  Customer checkInitCustomerInfo(@Param(value = "gid") Long gid,
      @Param(value = "name") String name,
      @Param(value = "address") String address);

  List<ExportSupplierAndGroupsView> getExportCustomerInfoList();

}
