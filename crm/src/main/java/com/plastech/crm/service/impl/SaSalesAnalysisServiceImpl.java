package com.plastech.crm.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;
import com.plastech.crm.model.SaSalesSt;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;
import com.plastech.crm.service.SaSalesAnalysisService;
import com.plastech.crm.util.CommonThreadPool;
import com.plastech.crm.util.CommonTools;
import com.plastech.crm.util.SaDataAnalysisUtil;
import com.plastech.crm.util.thread.GenerateAllSalesAnalysis;

/**
 *
 *
 * @author : yemin
 * @date : 2019年2月19日 下午3:10:02
 *
 */
@Service
public class SaSalesAnalysisServiceImpl extends BaseService
    implements SaSalesAnalysisService {
  protected static final Logger log =
      LoggerFactory.getLogger(SaSalesAnalysisServiceImpl.class);

  @Override
  public boolean generateSalesAnalysisForMonth(final int year,
      final int month) {
    try {
      if (year < 1970 || year > 2100 || month < 1 || month > 13) {
        log.info("param error , year=" + year + ",month=" + month);
        return false;
      }
      SaSalesSt st;
      if (month == 13) {
        st = saSalesStMapper.getSalesStByYear(year + "");
      } else {
        st = saSalesStMapper.getSalesStByMonth(year + "", month + "");
      }
      if (st != null) {
        final String yearStr = year + "";
        final String monthStr = month + "";
        SaSalesSt sss = saSalesStMapper.selectByYearAndMonth(yearStr, monthStr);
        if (sss == null) {
          sss = new SaSalesSt();
          sss.setYear(yearStr);
          sss.setMonth(monthStr);
          sss.setSalesTotal(st.getSalesTotal());
          sss.setGroupCount(st.getGroupCount());
          sss.setCommodityCount(st.getCommodityCount());
          saSalesStMapper.insertSelective(sss);
        } else {
          sss.setSalesTotal(st.getSalesTotal());
          sss.setGroupCount(st.getGroupCount());
          sss.setCommodityCount(st.getCommodityCount());
          saSalesStMapper.updateByPrimaryKey(sss);
        }
        log.error( "生成" + year + "-" + month +"的銷售分析- 銷售情況 " );
      } else {
        saSalesStMapper.deleteSaSalesSt(year + "", month + "");
      }
      return true;
    } catch (final Exception e) {
      log.error("Generate salesAnalysis error , {}", e);
    }
    return false;
  }


  @Override
  public boolean initSalesAnalysisAsync() {
    final String shipmt_e =
        contractGradeMapper.selectEarliestContractGradeShipmt();
    final String shipmt_l =
        contractGradeMapper.selectLatestContractGradeShipmt();
    if (Strings.isNullOrEmpty(shipmt_e)) {
      log.error("No contract grade data, init salesAnalysis failure");
      return false;
    }
    final Date eDate =
        CommonTools.parseStringToDate(shipmt_e, CommonTools.DATEFORMAT_Y4_MM);
    final Date lDate =
        CommonTools.parseStringToDate(shipmt_l, CommonTools.DATEFORMAT_Y4_MM);
    if (eDate == null || lDate == null) {
      log.error("shipmt error , init salesAnalysis failure");
      return false;
    }
    return CommonThreadPool
        .addTaskToFixedQueue(new GenerateAllSalesAnalysis(eDate, lDate, this));
  }

  @Override
  public boolean initSalesAnalysis() {
    final String shipmt_e =
        contractGradeMapper.selectEarliestContractGradeShipmt();
    final String shipmt_l =
        contractGradeMapper.selectLatestContractGradeShipmt();
    final Date eDate =
        CommonTools.parseStringToDate(shipmt_e, CommonTools.DATEFORMAT_Y4_MM);
    final Date lDate =
        CommonTools.parseStringToDate(shipmt_l, CommonTools.DATEFORMAT_Y4_MM);
    if (eDate == null || lDate == null) {
      log.error("shipmt error , init salesAnalysis failure");
      return false;
    }

    final Calendar eCalendar = Calendar.getInstance();
    eCalendar.setTime(eDate);
    final Calendar lCalendar = Calendar.getInstance();
    lCalendar.setTime(lDate);
    int currentYear = 0;
    int currentMonth = 0;
    while (eCalendar.compareTo(lCalendar) <= 0) {
      currentYear = eCalendar.get(Calendar.YEAR);// 当前年
      currentMonth = eCalendar.get(Calendar.MONTH) + 1;// 当前月
      generateSalesAnalysisForMonth(currentYear, currentMonth);
      if (currentMonth == 12) {// 如果是12月，则需要计算一次当年的统计数据
        generateSalesAnalysisForMonth(currentYear, 13);
      }
      eCalendar.add(Calendar.MONTH, 1);
    }
    generateSalesAnalysisForMonth(currentYear, 13);
    return true;
  }

  // 第一次进来新增第13个月的数据后面update
  @Override
  public boolean generateSalesAnalysisForYear(final int year) {
    if (year < 1970 || year > 2100) {
      return false;
    }
    final SaSalesSt ssData =
        saSalesStMapper.selectByYearAndMonthInActive(year + "");
    // 查询已有的统计数据，有则更新，没有则新增
    final String yearStr = year + "";
    final String monthStr = "13";
    if (ssData != null) {
      SaSalesSt sss = saSalesStMapper.selectByYearAndMonth(yearStr, monthStr);
      if (sss == null) {
        sss = new SaSalesSt();
        sss.setYear(yearStr);
        sss.setMonth(monthStr);
        sss.setSalesTotal(ssData.getSalesTotal());
        sss.setGroupCount(ssData.getGroupCount());
        sss.setCommodityCount(ssData.getCommodityCount());
        sss.setCreateTime(new Date());
        sss.setLastUpdateTime(new Date());
        saSalesStMapper.insertSelective(sss);
      } else {
        sss.setSalesTotal(ssData.getSalesTotal());
        sss.setGroupCount(ssData.getGroupCount());
        sss.setCommodityCount(ssData.getCommodityCount());
        sss.setLastUpdateTime(new Date());
        saSalesStMapper.updateByPrimaryKey(sss);
      }
    } else {
      saSalesStMapper.deleteSaSalesSt(yearStr, monthStr);
    }
    return true;
  }

  @Override
  public SalesAnalysisView selectSalesAnalysisByYear(final int year) {
    SalesAnalysisView salesYearInfo;
    // 根据年份查询数据
    salesYearInfo = saSalesStMapper.getSalesYearStatisticsInfo(year + "");
    /*
     * if (salesYearInfo == null) { //查询表中是否有数据 final SaSalesSt sssAny =
     * saSalesStMapper.selectAnyData(); if (sssAny == null) { //查询清单表是否有数据 final
     * ContractGrade cg = contractGradeMapper.selectAnyNormalData(); if (cg !=
     * null) { initSalesAnalysis(); generateSalesAnalysisForMonth(year, 13); } }
     * else { generateSalesAnalysisForMonth(year, 13);
     * generateSalesAnalysisForMonth(year - 1, 13); } }
     */
    if (salesYearInfo != null) {
      // 查询年月份
      final List<SalesAnalysisDataView> sadList =
          saSalesStMapper.getSalesMonthStatisticsInfo(year + "");
      // 查询上年月份
      final List<SalesAnalysisDataView> lastList =
          saSalesStMapper.getSalesMonthStatisticsInfo(year - 1 + "");
      final List<SalesAnalysisDataView> list = SaDataAnalysisUtil
          .completeDetailedMonthlyData(sadList, lastList, year);
      salesYearInfo.setDataList(list);
    }
    return salesYearInfo;
  }
}
