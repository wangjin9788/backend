package com.plastech.crm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.SaManufacturerDetail;
import com.plastech.crm.model.vo.SaManufacturerCommodityView;
import com.plastech.crm.model.vo.SaManufacturerLoyaltyView;
import com.plastech.crm.model.vo.SaManufacturerTotalDataView;
import com.plastech.crm.model.vo.SalesAnalysisDataView;

public interface SaManufacturerDetailMapper
    extends BaseTkMapper<SaManufacturerDetail> {

  List<SaManufacturerDetail> getCommodityPurchaseQuantity(
      @Param(value = "year") String year, @Param(value = "month") String month,
      @Param(value = "ctid") Long ctid, @Param(value = "mfid") Long mfid,
      @Param(value = "gid") Long gid);

  // 获取十三个月数据
  List<SaManufacturerDetail> getCommodityYearPurchaseQuantity(
      @Param(value = "year") String year, @Param(value = "ctid") Long ctid,
      @Param(value = "mfid") Long mfid, @Param(value = "gid") Long gid);

  List<SaManufacturerDetail> getCommodityPurchaseQuantity();

  SaManufacturerDetail getSaManufacturerDetailInfo(
      @Param(value = "gid") Long gid, @Param(value = "mfid") Long mfid,
      @Param(value = "year") String year, @Param(value = "ctid") Long ctid,
      @Param(value = "month") Integer month);

  List<SaManufacturerCommodityView> getManufacturerCommodityList(
      @Param(value = "gid") Long gid, @Param(value = "mfid") Long mfid,
      @Param(value = "year") String year,
      @Param(value = "searchKey") String searchKey);

  List<SaManufacturerCommodityView> getManufacturerCommodityTotalSalseAmountList(
      @Param(value = "gid") Long gid, @Param(value = "mfid") Long mfid,
      @Param(value = "year") String year,
      @Param(value = "searchKey") String searchKey);

  SaManufacturerDetail checkSaCommodityDetailInfo();


  List<SaManufacturerLoyaltyView> getAcquireLoyaltyList(
      @Param(value = "startYear") String startYear,
      @Param(value = "endYear") String endYear, @Param(value = "gid") Long gid,
      @Param(value = "mfid") Long mfid);

  List<SalesAnalysisDataView> getCommodityAnalysisStatisticsList(
      @Param(value = "gid") Long gid, @Param(value = "mfid") Long mfid,
      @Param(value = "year") String year, @Param(value = "ctid") Long ctid);

  Integer getLoyaltyBuyMonthQuantity(@Param(value = "gid") Long gid,
      @Param(value = "year") String year);

  List<SaManufacturerLoyaltyView> getManufacturersRelatedGroups(
      @Param(value = "mfid") Long mfid, @Param(value = "year") String year);

  SaManufacturerTotalDataView obtainManufacturerRelatedParameters(
      @Param(value = "gid") Long gid, @Param(value = "mfid") Long mfid,
      @Param(value = "year") String year, @Param(value = "lid") Long lid);

  void deleteSaManufacturerDetailByYearAndMonth(
      @Param(value = "year") String year, @Param(value = "month") String month,
      @Param(value = "ctid") Long ctid, @Param(value = "mfid") Long mfid,
      @Param(value = "gid") Long gid);

  // 根据年月删除与id不相同的数据
  void deleteSaManufacturerDetailBySmdid(@Param(value = "year") String year,
      @Param(value = "month") String month,
      @Param(value = "list") List<Long> list);

}
