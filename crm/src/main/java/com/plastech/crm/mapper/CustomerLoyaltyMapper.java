package com.plastech.crm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.CustomerLoyalty;

public interface CustomerLoyaltyMapper extends BaseTkMapper<CustomerLoyalty> {

  void deleteCustomerLoyalty(@Param(value = "years") Integer years,
      @Param(value = "gid") Long gid,@Param(value = "mfid") Long mfid);

  void insertBatch(List<CustomerLoyalty> list);

}
