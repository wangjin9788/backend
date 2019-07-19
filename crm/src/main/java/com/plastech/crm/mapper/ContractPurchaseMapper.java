package com.plastech.crm.mapper;

import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.ContractPurchase;

public interface ContractPurchaseMapper extends BaseTkMapper<ContractPurchase> {
  ContractPurchase getImportContractPurchaseByGeid(
      @Param(value = "cgid") Long cgid);
}
