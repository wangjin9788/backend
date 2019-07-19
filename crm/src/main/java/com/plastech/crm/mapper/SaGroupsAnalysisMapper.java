package com.plastech.crm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.SaGroupsAnalysis;
import com.plastech.crm.model.parameter.ExportDataInfoView;
import com.plastech.crm.model.vo.SaGroupsCommodityOrManufacturerView;
import com.plastech.crm.model.vo.SaGroupsCommodityPercentageView;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;

public interface SaGroupsAnalysisMapper extends BaseTkMapper<SaGroupsAnalysis> {
  /**
   * 获取统计数据月
   *
   * @param year
   * @param month
   * @return
   */
  List<SaGroupsAnalysis> getSaGroupsStatisticsInfoByMonth(
      @Param(value = "year") String year, @Param(value = "month") String month,
      @Param(value = "gid") Long gid);

  /**
   * 获取统计数据年
   *
   * @param year
   * @param month
   * @return
   */
  List<SaGroupsAnalysis> getSaGroupsStatisticsInfoByYear(
      @Param(value = "year") String year, @Param(value = "gid") Long gid);

  /**
   * 检查统计表中是否有数据
   *
   * @param year
   * @param month
   * @return
   */
  SaGroupsAnalysis checkSaGroupsSt();

  /**
   * 获取统计列表信息
   *
   * @param year
   * @param month
   * @return
   */
  List<SalesAnalysisDataView> getStGroupsStStatisticsList(
      @Param(value = "year") String year, @Param(value = "gid") Long gid);


  /**
   * 根据年月获取对应信息
   *
   * @param year
   * @param month
   * @param gid
   * @return
   */
  SaGroupsAnalysis getSaGroupsStByGid(@Param(value = "year") String year,
      @Param(value = "month") String month, @Param(value = "gid") Long gid);

  /**
   * 获取统计列表总计信息
   *
   * @param year
   * @param gid
   * @return
   */
  SalesAnalysisView getPurchaseTotal(@Param(value = "year") String year,
      @Param(value = "gid") Long gid);

  /**
   * 百分比
   *
   * @param year
   * @param gid
   * @return
   */
  List<SaGroupsCommodityPercentageView> getCommodityPercentage(
      @Param(value = "year") String year, @Param(value = "gid") Long gid);

  /**
   * 获取品类
   *
   * @param year
   * @param gid
   * @return
   */
  List<SaGroupsCommodityOrManufacturerView> getCommodity(
      @Param(value = "year") String year, @Param(value = "gid") Long gid);

  /**
   * 获取生产商
   *
   * @param year
   * @param gid
   * @return
   */
  List<SaGroupsCommodityOrManufacturerView> getManufacturer(
      @Param(value = "year") String year, @Param(value = "gid") Long gid);

  List<ExportDataInfoView> getExportGroupsInfoList(
      @Param(value = "year") String year,
      @Param(value = "list") List<Long> list);

  void deleteSaGroupsByYearAndMonth(@Param(value = "year") String year,
      @Param(value = "month") String month, @Param(value = "gid") Long gid);

  // 根据年月删除与id不相同的数据
  void deleteSaGroupsBySgid(@Param(value = "year") String year,
      @Param(value = "month") String month,
      @Param(value = "list") List<Long> list);
}
