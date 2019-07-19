package com.plastech.crm.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.SaManufacturerAnalysis;
import com.plastech.crm.model.parameter.ExportDataInfoView;
import com.plastech.crm.model.vo.SaCustomerPurchaseDetailsView;

public interface SaManufacturerAnalysisMapper
    extends BaseTkMapper<SaManufacturerAnalysis> {
  List<SaCustomerPurchaseDetailsView> getCustomerPurchaseInformation(
      Map<String, Object> map);

  SaManufacturerAnalysis checkSaManufacturerInfo();

  List<SaManufacturerAnalysis> getManufacturerGroupsPurchaseAnalysis(
      @Param(value = "year") String year, @Param(value = "month") String month,
      @Param(value = "gid") Long gid, @Param(value = "mfid") Long mfid);

  List<SaManufacturerAnalysis> getManufacturerGroupsPurchaseAnalysisYear(
      @Param(value = "year") String year, @Param(value = "gid") Long gid,
      @Param(value = "mfid") Long mfid);

  SaManufacturerAnalysis getManufuacturerGroupsInfo(
      @Param(value = "year") String year, @Param(value = "month") String month,
      @Param(value = "mfid") Long mfid, @Param(value = "gid") Long gid,
      @Param(value = "lid") Long lid);

  List<ExportDataInfoView> getExportManufacturerGroupsInfoList(
      @Param(value = "list") List<Long> list, @Param(value = "mfid") Long mfid,
      @Param(value = "year") String year);

  void deleteSaManufacturerByYearAndMonth(@Param(value = "year") String year,
      @Param(value = "month") String month, @Param(value = "gid") Long gid,
      @Param(value = "mfid") Long mfid);

  // 根据年月删除与id不相同的数据
  void deleteSaManufacturerBySmid(@Param(value = "year") String year,
      @Param(value = "month") String month,
      @Param(value = "list") List<Long> list);

}
