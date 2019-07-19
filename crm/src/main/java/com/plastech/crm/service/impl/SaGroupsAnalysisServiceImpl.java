package com.plastech.crm.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.plastech.crm.model.SaGroupsAnalysis;
import com.plastech.crm.model.vo.SaGroupsCommodityOrManufacturerView;
import com.plastech.crm.model.vo.SaGroupsCommodityPercentageView;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crm.service.SaGroupsAnalysisService;
import com.plastech.crm.util.CommonTools;
import com.plastech.crm.util.SaDataAnalysisUtil;

/**
 * @author wangJin
 *
 * @date 2019年3月26日 下午2:12:25
 *
 */
@Service
public class SaGroupsAnalysisServiceImpl extends BaseService
    implements SaGroupsAnalysisService {

  @Override
  public ResultJson<SalesAnalysisView> getSaGroupsStatisticsInfo(
      final Integer year, final Long gid) {
    List<SalesAnalysisDataView> statisList = new ArrayList<>();
    // 根据条件查询
    SalesAnalysisView totalParameter =
        saGroupsAnalysisMapper.getPurchaseTotal(year + "", gid);
    if (totalParameter == null) {
      totalParameter = new SalesAnalysisView();
    }
    // 查询的年份
    final List<SalesAnalysisDataView> sgsList =
        saGroupsAnalysisMapper.getStGroupsStStatisticsList(year + "", gid);
    // 上一年
    final List<SalesAnalysisDataView> lastList =
        saGroupsAnalysisMapper.getStGroupsStStatisticsList(year - 1 + "", gid);
    statisList =
        SaDataAnalysisUtil.completeDetailedMonthlyData(sgsList, lastList, year);
    totalParameter.setDataList(statisList);

    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, totalParameter,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @Override
  public Boolean selectSaGroupsAnalysisByYear(final int year) {
    final Calendar cal = Calendar.getInstance();
    final int currentYear = cal.get(Calendar.YEAR);
    if (year > currentYear) {
      return false;
    }
    final SaGroupsAnalysis sga = saGroupsAnalysisMapper.checkSaGroupsSt();
    if (sga == null) {
      initSaGroupsAnalysis();
      generateSaGroupsAnalysisForMonth(currentYear, 13, null);
    } else {
      generateSaGroupsAnalysisForMonth(currentYear, 13, null);
      generateSaGroupsAnalysisForMonth(currentYear - 1, 13, null);
    }
    return true;
  }

  @Override
  public Boolean initSaGroupsAnalysis() {
    final String shipmt_e =
        contractGradeMapper.selectEarliestContractGradeShipmt();
    final String shipmt_l =
        contractGradeMapper.selectLatestContractGradeShipmt();
    final Date eDate =
        CommonTools.parseStringToDate(shipmt_e, CommonTools.DATEFORMAT_Y4_MM);
    final Date lDate =
        CommonTools.parseStringToDate(shipmt_l, CommonTools.DATEFORMAT_Y4_MM);
    if (eDate == null || lDate == null) {
      logger.error("shipmt error , init salesAnalysis failure");
      return false;
    }
    initGroupsAnnualPurchases(eDate, lDate);
    return true;
  }

  @Override
  public Boolean generateSaGroupsAnalysisForMonth(final int year,
      final int month, final Long gid) {
    try {
      if (year < 1970 || year > 2100 || month < 1 || month > 13) {
        logger.info("param error , year=" + year + ",month=" + month);
        return false;
      }
      final String yearStr = year + "";

      final List<SaGroupsAnalysis> salseInfo;
      if (month == 13) {// 一整年的销售经理销售统计数据
        salseInfo = saGroupsAnalysisMapper
            .getSaGroupsStatisticsInfoByYear(year + "", gid);
      } else {// 单个月的销售经理销售统计数据
        salseInfo = saGroupsAnalysisMapper
            .getSaGroupsStatisticsInfoByMonth(yearStr, month + "", gid);
      }
      if (salseInfo != null && !salseInfo.isEmpty()) {
        for (final SaGroupsAnalysis smsInfo : salseInfo) {
          SaGroupsAnalysis sg = saGroupsAnalysisMapper.getSaGroupsStByGid(
              yearStr, smsInfo.getMonth(), smsInfo.getGid());
          if (sg == null) {
            sg = new SaGroupsAnalysis();
            sg.setYear(yearStr);
            sg.setGid(smsInfo.getGid());
            sg.setMonth(smsInfo.getMonth());
            sg.setSalesTotal(smsInfo.getSalesTotal());
            sg.setManufacturerCount(smsInfo.getManufacturerCount());
            sg.setCommodityCount(smsInfo.getCommodityCount());
            sg.setgName(smsInfo.getgName());
            sg.setGradeNumber(smsInfo.getGradeNumber());
            sg.setCreateTime(new Date());
            saGroupsAnalysisMapper.insertSelective(sg);
          } else {
            sg.setSalesTotal(smsInfo.getSalesTotal());
            sg.setManufacturerCount(smsInfo.getManufacturerCount());
            sg.setCommodityCount(smsInfo.getCommodityCount());
            sg.setLastUpdateTime(new Date());
            saGroupsAnalysisMapper.updateByPrimaryKey(sg);
          }
        }
        logger.info("生成" + year + "-" + month + "客戶分析-年度購買情況，并写入DB。");
      } else if (gid != null) {
        saGroupsAnalysisMapper.deleteSaGroupsByYearAndMonth(yearStr, month + "",
            gid);
      }
      return true;
    } catch (final Exception e) {
      logger.error("Generate salesAnalysis error , {}", e);
    }
    return false;
  }

  /**
   * 查询百分比
   */
  @Override
  public List<SaGroupsCommodityPercentageView> getCommodityPercentage(
      final Integer year, final Long gid) {
    return saGroupsAnalysisMapper.getCommodityPercentage(year + "", gid);

  }

  @Override
  public List<SaGroupsCommodityOrManufacturerView> getCommodity(
      final Integer year, final Long gid) {

    return saGroupsAnalysisMapper.getCommodity(year + "", gid);
  }

  @Override
  public List<SaGroupsCommodityOrManufacturerView> getManufacturer(
      final Integer year, final Long gid) {
    return saGroupsAnalysisMapper.getManufacturer(year + "", gid);
  }

  public void initGroupsAnnualPurchases(final Date eDate, final Date IDate) {
    final Calendar eCalendar = Calendar.getInstance();
    eCalendar.setTime(eDate);
    final Calendar lCalendar = Calendar.getInstance();
    lCalendar.setTime(IDate);
    int currentYear = 0;
    int currentMonth = 0;
    while (eCalendar.compareTo(lCalendar) <= 0) {
      currentYear = eCalendar.get(Calendar.YEAR);// 当前年
      currentMonth = eCalendar.get(Calendar.MONTH) + 1;// 当前月
      generateSaGroupsAnalysisForMonth(currentYear, currentMonth, null);
      if (currentMonth == 12) {// 如果是12月，则需要计算一次当年的统计数据
        generateSaGroupsAnalysisForMonth(currentYear, 13, null);
      }
      eCalendar.add(Calendar.MONTH, 1);
    }
    generateSaGroupsAnalysisForMonth(currentYear, 13, null);
    logger.info("Generaet all init Sa GroupsAnalysis success!!");
  }

}
