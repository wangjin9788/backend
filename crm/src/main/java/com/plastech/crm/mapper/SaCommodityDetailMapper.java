package com.plastech.crm.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.SaCommodityDetail;
import com.plastech.crm.model.parameter.SaCommodityParameters;
import com.plastech.crm.model.vo.SaCommodityCustomerView;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;

public interface SaCommodityDetailMapper
    extends BaseTkMapper<SaCommodityDetail> {

  List<SaCommodityParameters> getSaCommodityDetailAnalysis(
      @Param(value = "year") String year, @Param(value = "month") String month,
      @Param(value = "ctid") Long ctid, @Param(value = "mfid") Long mfid,
      @Param(value = "gid") Long gid);

  List<SaCommodityParameters> getCommodityDetailAnalysisFromContractDataForYear(
      @Param(value = "year") String year, @Param(value = "ctid") Long ctid,
      @Param(value = "mfid") Long mfid, @Param(value = "gid") Long gid);

  SaCommodityDetail getSaCommodityDetailInfo(
      @Param(value = "year") Integer year,
      @Param(value = "month") Integer month, @Param(value = "ctid") Long ctid,
      @Param(value = "mfid") Long mfid, @Param(value = "name") String name);

  List<SaCommodityCustomerView> getCommodityAnalysisCustomer(
      Map<String, Object> map);

  List<SalesAnalysisDataView> getCustomerStatistics(Map<String, Object> map);


  SalesAnalysisView getTotalPurchases(@Param(value = "year") Integer year,
      @Param(value = "month") Integer month, @Param(value = "ctid") Long ctid,
      @Param(value = "mfid") Long mfid, @Param(value = "name") String name);


  SaCommodityDetail checkSaCommodityDetail();

  void deleteSaCommodityDetailByYearAndMonth(
      @Param(value = "year") Integer year,
      @Param(value = "month") Integer month, @Param(value = "ctid") Long ctid,
      @Param(value = "mfid") Long mfid, @Param(value = "gid") Long gid);

  // 根据年月删除与id不相同的数据
  void deleteSaCommodityDetailByScdid(@Param(value = "year") Integer year,
      @Param(value = "month") Integer month,
      @Param(value = "list") List<Long> list);

}
