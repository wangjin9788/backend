package com.plastech.crm.service;

import java.util.List;
import java.util.Map;
import com.plastech.crm.model.vo.SaCustomerPurchaseDetailsView;
import com.plastech.crm.model.vo.SaManufacturerCommodityView;
import com.plastech.crm.model.vo.SaManufacturerLoyaltyView;
import com.plastech.crm.model.vo.SaManufacturerTotalDataView;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;

/**
 * @author wangJin
 *
 * @date 2019年2月28日 下午1:23:00
 *
 */
public interface SaManufacturerAnalysisService {

  boolean initSalesAnalysis();

  boolean generateSalesAnalysisForMonth(int year, int month,Long mfid);

  boolean selectSalesAnalysisByYear(int year);


  SalesAnalysisView getSaManufacturerList(Map<String, Object> map,
      Integer year);

  List<SaCustomerPurchaseDetailsView> getCustomerPurchaseInformation(
      Map<String, Object> map, Integer year);


  List<SaManufacturerCommodityView> getManufacturerCommodityList(Long gid,
      Long mfid, Integer year, String name);

  boolean generateSalesManufacturerDetailAnalysisForMonth(int year, int month,Long ctid,Long mfid,Long gid);

  List<SalesAnalysisDataView> getCommodityAnalysisStatisticsList(Long gid,
      Long mfid, Integer year, Long ctid);

  List<SaManufacturerLoyaltyView> getAcquireLoyaltyList(String year, Long gid,Long mfid);

  SaManufacturerTotalDataView obtainManufacturerRelatedParameters(Long gid,
      Long mfid, String year, Long lid);

  List<SaManufacturerLoyaltyView> getManufacturersRelatedGroups(Long mfid,
      String year);

  boolean generateSalesManufacturerAnalysisForMonth(int year, int month,Long gid,Long mfid);


 boolean initAllManufacturerAnalysisData();

 boolean initManufacturerDetail();

}
