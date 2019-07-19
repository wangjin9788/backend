package com.plastech.crm.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.SaCommodityAnalysis;
import com.plastech.crm.model.vo.SaCommodityAnalysisView;
import com.plastech.crm.model.vo.SaCommodityDetailView;
import com.plastech.crm.model.vo.SaGroupsCommodityOrManufacturerView;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;

public interface SaCommodityAnalysisMapper
    extends BaseTkMapper<SaCommodityAnalysis> {

  List<SaCommodityAnalysis> getCommodityAnalysis(
      @Param(value = "year") String year, @Param(value = "month") String month,
      @Param(value = "ctid") Long ctid, @Param(value = "mfid") Long mfid);

  List<SaCommodityAnalysis> getCommodityAnalysisFromContractDataForYear(
      @Param(value = "year") String year, @Param(value = "ctid") Long ctid,
      @Param(value = "mfid") Long mfid);

  SaCommodityAnalysis getSaCommodityInfoById(
      @Param(value = "year") Integer year,
      @Param(value = "month") Integer month, @Param(value = "ctid") Long ctid,
      @Param(value = "mfid") Long mfid);

  SaCommodityAnalysis checkSaCommodity();


  List<SaCommodityAnalysisView> searchCommodityAnalysisById(
      Map<String, Object> map);

  SalesAnalysisView getCommodityTotalQuantity(Map<String, Object> map);

  String getSalesTotalNumber(@Param(value = "ctid") Long ctid,
      @Param(value = "year") String year);

  Integer getCustomersCount(@Param(value = "ctid") Long ctid,
      @Param(value = "mfid") Long mfid, @Param(value = "year") String year);

  SaCommodityDetailView getCommodityAnalysisDetail(Map<String, Object> map);

  List<SalesAnalysisDataView> getCommodityAnalysisMonthDetail(
      Map<String, Object> map);

  Double getSaCommodityNewContractSales(@Param(value = "ctid") Long ctid,
      @Param(value = "mfid") Long mfid, @Param(value = "year") String year);

  List<SaGroupsCommodityOrManufacturerView> getCommodity(
      @Param(value = "year") String year);

  List<SaGroupsCommodityOrManufacturerView> getManufacturer(
      @Param(value = "year") String year);

  Integer getCommodityQuantity(@Param(value = "ctid") Long ctid,
      @Param(value = "mfid") Long mfid, @Param(value = "year") String year);

  // 根据年月进行删除
  void deleteSaCommodityByYearAndMonth(@Param(value = "month") String month,
      @Param(value = "year") String year,@Param(value = "ctid") Long ctid,
      @Param(value = "mfid") Long mfid);

  // 根据年月删除和id不相符合的数据
  void deleteSaCommodityBySctid(@Param(value = "month") String month,
      @Param(value = "year") String year,
      @Param(value = "list") List<Long> list);

  Integer getAnnualGroupCount(@Param(value = "ctid") Long ctid,
      @Param(value = "mfid") Long mfid, @Param(value = "year") String year);
}
