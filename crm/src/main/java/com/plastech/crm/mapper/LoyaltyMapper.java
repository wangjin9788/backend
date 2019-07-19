package com.plastech.crm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.Loyalty;
import com.plastech.crm.model.vo.CustomerLoyaltyView;
import com.plastech.crm.model.vo.LoyaltyDurationView;
import com.plastech.crm.model.vo.LoyaltyView;
import com.plastech.crm.model.vo.UserPurchaseFrequencyView;

public interface LoyaltyMapper extends BaseTkMapper<Loyalty> {

  List<LoyaltyView> getLoyaltyList(@Param("type")Integer type);

  Boolean checkLoyaltyName(@Param(value = "name") String name);

  Integer updateLoyaltyBylId(Long lid);

  List<UserPurchaseFrequencyView> selectCustomerContractPurchase(
      @Param(value = "gid") Long gid,@Param(value = "mfid") Long mfid);

  List<CustomerLoyaltyView> selectContractUserBuyingFrequency();

  Loyalty getDefaultLoyalty();

  LoyaltyDurationView getDurationParameter();

}
