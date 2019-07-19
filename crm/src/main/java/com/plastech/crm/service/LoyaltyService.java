package com.plastech.crm.service;

import java.util.List;
import com.plastech.crm.model.parameter.AddLoyaltyParameters;
import com.plastech.crm.model.parameter.ExchangeDataOrderParameters;
import com.plastech.crm.model.vo.LoyaltyView;
import com.plastech.crm.resultdata.ResultJson;

/**
 * @author wangJin
 *
 * @date 2019年1月22日 上午9:36:34
 *
 */
public interface LoyaltyService {

  List<LoyaltyView> getLoyaltyList(Integer type);

  Integer addLoyalty(AddLoyaltyParameters param, Long uid);

  Integer deleteLoyalty(Long lid);

  ResultJson<Boolean> exchangeLoyaltyOrder(ExchangeDataOrderParameters param);

  Boolean loyaltyTakesEffect(Long uid);
}
