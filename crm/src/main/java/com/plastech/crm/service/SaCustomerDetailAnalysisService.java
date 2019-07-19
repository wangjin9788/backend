package com.plastech.crm.service;

import java.util.Map;
import com.plastech.crm.model.vo.SalesAnalysisView;

/**
 * @author wangJin
 *
 * @date 2019年3月27日 上午10:18:38
 *
 */
public interface SaCustomerDetailAnalysisService {
  SalesAnalysisView getCustomerStatistics(Map<String ,Object> map,Integer year);

  Boolean generateSaCustomerDetailForMonth(int year, int month,Long ctid,Long mfid,Long gid,Long cuid);

  Boolean initCustomerDetail();
}
