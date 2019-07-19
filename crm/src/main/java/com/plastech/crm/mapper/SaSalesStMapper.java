package com.plastech.crm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.SaSalesSt;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;

public interface SaSalesStMapper extends BaseTkMapper<SaSalesSt> {


  SaSalesSt getSalesStByMonth(@Param("year") String year,
      @Param("month") String month);

  SaSalesSt getSalesStByYear(@Param("year") String year);

  SalesAnalysisView getSalesYearStatisticsInfo(@Param("year") String year);

  List<SalesAnalysisDataView> getSalesMonthStatisticsInfo(
      @Param("year") String year);



  SaSalesSt selectByYearAndMonth(@Param("year") String yearStr,
      @Param("month") String monthStr);


  Double selectSalesTotalByYearMonth(String year_month);

  int selectGroupCountByYearMonth(String year_month);

  int selectCommodityCountByYearMonth(String year_month);

  SaSalesSt selectAnyData();

  int selectCommodityCountByYear(String yearStr);

  int selectGroupCountByYear(String yearStr);

  Double selectSalesTotalByYear(String yearStr);

  SaSalesSt selectByYearInActive(String yearStr);

  SaSalesSt selectByYearAndMonthInActive(@Param("year") String year);

  void deleteSaSalesSt(@Param("year") String year,
      @Param("month") String month);

}
