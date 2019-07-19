package com.plastech.crm.service;

import java.util.List;
import java.util.Map;
import com.plastech.crm.model.vo.SaCommodityCustomerView;
import com.plastech.crm.model.vo.SaCommodityDetailView;
import com.plastech.crm.model.vo.SaGroupsCommodityOrManufacturerView;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;

/**
 * @author wangJin
 *
 * @date 2019年2月22日 上午10:22:43
 *
 */
public interface SaCommodityAnalysisServer {


  boolean searchSaCommodityDetail(Map<String, Object> map, Integer year);

  boolean generateSalesCommodityAnalysisForMonth(final int year,
      final int month,Long ctid,Long mfid);

  boolean generateSalesCommodityDetailAnalysisForMonth(final int year,
      final int month,Long ctid,Long mfid,Long gid);

  SalesAnalysisView commoditySalesList(Map<String, Object> map, Integer year);

  SaCommodityDetailView commodityAnalysisDetail(final Map<String, Object> map,
      Integer year);

  List<SaCommodityCustomerView> getCommodityAnalysisCustomer(
      final Map<String, Object> map, Integer year);

  List<SalesAnalysisDataView> getCommodityCustomerStatistics(
      Map<String, Object> map, Integer year);

  List<SaGroupsCommodityOrManufacturerView> getCommodity(Integer year);

  List<SaGroupsCommodityOrManufacturerView> getManufacturer(Integer year);

 void initAllCommodityAnalysisData();

 void initSaConnodityDetail();
}
