package com.plastech.crm.service;

import java.util.List;
import com.plastech.crm.model.vo.SaGroupsCommodityOrManufacturerView;
import com.plastech.crm.model.vo.SaGroupsCommodityPercentageView;
import com.plastech.crm.model.vo.SalesAnalysisView;
import com.plastech.crm.resultdata.ResultJson;

/**
 * @author wangJin
 *
 * @date 2019年3月26日 下午2:12:15
 *
 */
public interface SaGroupsAnalysisService {

  ResultJson<SalesAnalysisView> getSaGroupsStatisticsInfo(Integer year, Long gid);


  Boolean selectSaGroupsAnalysisByYear(final int year);

  Boolean initSaGroupsAnalysis();

  Boolean generateSaGroupsAnalysisForMonth(final int year, final int month,Long gid);

  List<SaGroupsCommodityPercentageView> getCommodityPercentage(Integer year,
      Long gid);

  List<SaGroupsCommodityOrManufacturerView> getCommodity(Integer year,
      Long gid);

  List<SaGroupsCommodityOrManufacturerView> getManufacturer(Integer year,
      Long gid);
}
