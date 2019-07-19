package com.plastech.crm.service;

import java.util.List;
import java.util.Map;
import com.plastech.crm.model.vo.SaCommodityPurchaseDetail;
import com.plastech.crm.model.vo.SaManufacturerTotalDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;

/**
 * @author wangJin
 *
 * @date 2019年3月26日 下午4:51:58
 *
 */
public interface SaCommodityPurchaseService {

  SalesAnalysisView getSaCommodityPurchaseStatistics(Map<String ,Object> map,Integer year);

  Boolean selectSaCommodityPurchaseByYear(int year);

  Boolean initSaCommodityPurchaseAnalysis();

  Boolean generateSaCommodityPurchaseForMonth(int year, int month,Long ctid,Long mfid,Long gid);

  SaManufacturerTotalDataView getSaCommodityPurchaseDetailTotal(Map<String ,Object> map);

  List<SaCommodityPurchaseDetail> searchCommodityPurchaseDetailCustomer(Map<String ,Object> map);
}
