package com.plastech.crm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.Commodity;
import com.plastech.crm.model.parameter.ExportDataInfoView;
import com.plastech.crm.model.vo.CommodityView;

public interface CommodityMapper extends BaseTkMapper<Commodity> {
  List<CommodityView> searchCommodity(
      @Param(value = "searchkey") String searchkey);

  List<CommodityView> getCommodityChooseList();

  String selectCommodityName(@Param(value = "name") String name);

  void updateCommodityByCtid(Long ctId);

  String selectCommodityByCtid(@Param(value = "ctId") String ctId);

  Commodity selectByCommodityName(String commodityName);

  List<ExportDataInfoView> getExportCommodityInfoList(
      @Param(value = "list") List<Long> list,
      @Param(value = "year") String year);

  List<ExportDataInfoView> getExportSalesManagerInfoList(
      @Param(value = "uid") Integer uid, @Param(value = "year") String year);

  // 生产商导出
  List<ExportDataInfoView> getExportManufacturerInfoList(
      @Param(value = "list") List<Long> list,
      @Param(value = "year") String year);

  List<Long> getCommodityIdList();
}
