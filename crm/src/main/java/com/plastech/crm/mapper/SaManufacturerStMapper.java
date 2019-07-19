package com.plastech.crm.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.SaManufacturerSt;
import com.plastech.crm.model.vo.SaCustomerPurchaseDetailsView;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;

public interface SaManufacturerStMapper extends BaseTkMapper<SaManufacturerSt> {
  SaManufacturerSt selectAnyData(@Param(value = "year") String year);

  SaManufacturerSt checkSalseManufacturer(@Param(value = "year") String year,
      @Param(value = "month") String month, @Param(value = "mfid") Long mfid);

  List<SaManufacturerSt> getContractSalseInfo(
      @Param(value = "year") String year, @Param(value = "month") String month,
      @Param(value = "mfid") Long mfid);

  List<SaManufacturerSt> getContractSalseYearInfo(
      @Param(value = "year") String year, @Param(value = "mfid") Long mfid);

  List<SalesAnalysisDataView> getSaManufacturerStatisticsList(
      Map<String, Object> map);

  SalesAnalysisView selectTotalQuantity(Map<String, Object> map);

  List<SaCustomerPurchaseDetailsView> getCustomerPurchaseInformation(
      Map<String, Object> map);

  void deleteManufacturerStByYearAndMonth(@Param(value = "year") String year,
      @Param(value = "month") String month, @Param(value = "mfid") Long mfid);

  // 根据年月删除与id不相同的数据
  void deleteManufacturerStBySmsid(@Param(value = "year") String year,
      @Param(value = "month") String month,
      @Param(value = "list") List<Long> list);

}
