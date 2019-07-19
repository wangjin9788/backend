package com.plastech.crm.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.Contract;
import com.plastech.crm.model.parameter.AddOrUpdateContractParameters;
import com.plastech.crm.model.vo.ContractBaseDetailView;
import com.plastech.crm.model.vo.ContractCustomerView;
import com.plastech.crm.model.vo.ContractDetailView;
import com.plastech.crm.model.vo.ContractExportView;
import com.plastech.crm.model.vo.ContractListView;
import com.plastech.crm.model.vo.ImportContractView;

public interface ContractMapper extends BaseTkMapper<Contract> {
  List<ContractListView> searchContractList(Map<String, Object> map);

  void updateContractGossSalesAndNetProfitByCoid(
      @Param(value = "coid") Long coid,
      @Param(value = "salesTotal") String salesTotal,
      @Param(value = "netProfit") String netProfit,
      @Param(value = "grossProfit") String grossProfit);

  Contract selectByContractNumber(String contNo);

  void deleteGradeByCoid(Long coid);

  void deletePurchaseByCoid(Long coid);

  List<ContractCustomerView> getCustomerList(@Param(value = "cuid") Long cuid);

  ContractDetailView expandingContractListByCgId(
      @Param(value = "cgid") Long cgid);

  ContractBaseDetailView getContractBaseDetail(
      @Param(value = "coid") Long coid);

  Long checkContractNumber(@Param(value = "number") String number);

  Integer updateContractGradeAndPurchaseByCoid(
      @Param(value = "coid") Long coid);

  AddOrUpdateContractParameters getContractInfoByCoid(
      @Param(value = "coid") Long coid);

  List<ContractExportView> exportContract();

  void updateContractByCuid(@Param(value = "gid") Long gid,
      @Param(value = "cuid") Long cuid);

  ImportContractView isImportContractNumberNotExist(
      @Param(value = "contNo") String contNo);
}
