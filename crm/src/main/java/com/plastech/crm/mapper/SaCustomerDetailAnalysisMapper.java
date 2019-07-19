package com.plastech.crm.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.SaCustomerDetailAnalysis;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;

public interface SaCustomerDetailAnalysisMapper
    extends BaseTkMapper<SaCustomerDetailAnalysis> {
  List<SaCustomerDetailAnalysis> getSaCustomerInfoByMonth(
      @Param(value = "year") String year, @Param(value = "month") String month,
      @Param(value = "ctid") Long ctid, @Param(value = "mfid") Long mfid,
      @Param(value = "gid") Long gid, @Param(value = "cuid") Long cuid);

  List<SaCustomerDetailAnalysis> getSaCustomerInfoByYear(
      @Param(value = "year") String year, @Param(value = "ctid") Long ctid,
      @Param(value = "mfid") Long mfid, @Param(value = "gid") Long gid,
      @Param(value = "cuid") Long cuid);

  /**
   * 检查sa_Customer表中是否有数据
   *
   */
  SaCustomerDetailAnalysis getSaCustomerInfo();

  /**
   * 根据条件查看是否有对应数据
   */
  SaCustomerDetailAnalysis getSacustomerInfoById(@Param(value = "gid") Long gid,
      @Param(value = "cuid") Long cuid, @Param(value = "ctid") Long ctid,
      @Param(value = "mfid") Long mfid, @Param(value = "year") String year,
      @Param(value = "month") String month);

  /**
   * 查询统计列表销售量
   *
   * @param gid
   * @param cuid
   * @param ctid
   * @param mfid
   * @param year
   * @return
   */
  SalesAnalysisView getCustomerStatisticsTotal(Map<String, Object> map);

  /**
   * 获取统计列表信息
   *
   * @param gid
   * @param cuid
   * @param ctid
   * @param mfid
   * @param year
   * @return
   */
  List<SalesAnalysisDataView> getCustomerStatisticsMonth(
      Map<String, Object> map);

  void deleteSaCustomerDetailByYearAndMonth(@Param(value = "year") Integer year,
      @Param(value = "month") Integer month, @Param(value = "ctid") Long ctid,
      @Param(value = "mfid") Long mfid, @Param(value = "gid") Long gid,
      @Param(value = "cuid") Long cuid);

  // 根据年月删除与id不相同的数据
  void deleteSaCustomerDetailByScuid(@Param(value = "year") Integer year,
      @Param(value = "month") Integer month,
      @Param(value = "list") List<Long> list);

}
