package com.plastech.crm.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;
import com.plastech.crm.model.SaSalesManager;
import com.plastech.crm.model.SaSalesSt;
import com.plastech.crm.model.User;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesManagerAnalysisOfCustomerData;
import com.plastech.crm.model.vo.SalesManagerAnalysisYearStData;
import com.plastech.crm.model.vo.SalesManagerAnalysisYearStView;
import com.plastech.crm.model.vo.SingleSalesManagerAnalysisYearStView;
import com.plastech.crm.service.SaManagerAnalysisService;
import com.plastech.crm.util.CommonTools;
import com.plastech.crm.util.SaDataAnalysisUtil;

/**
 *
 *
 * @author : yemin
 * @date : 2019年2月25日 下午3:08:37
 *
 */
@Service
public class SaManagerAnalysisServiceImpl extends BaseService
    implements SaManagerAnalysisService {

  @Override
  public SalesManagerAnalysisYearStView selectSalesManagerAnalysisByYear(
      final int year) {
    final Calendar cal = Calendar.getInstance();
    final int currentYear = cal.get(Calendar.YEAR);
    if (year > currentYear) {
      return new SalesManagerAnalysisYearStView();
    }

    SaSalesSt saSalesSt;
    if (year == currentYear) {
      // 今年的数据还未生成，需要即时查询
      saSalesSt = saSalesStMapper.selectByYearInActive(year + "");
    } else {
      saSalesSt = saSalesStMapper.selectByYearAndMonth(year + "", "13");
    }

    // 查询全年的销售经理销售统计数据
    final List<SalesManagerAnalysisYearStData> ssmList = saSalesManagerMapper
        .selectSalesManagerAnalysisDataByYearAndMonthWithPreviousData(year + "",
            "13", (year - 1) + "");
    /*
     * if (CommonTools.isListNullOrEmpty(ssmList)) { final SaSalesManager ssData
     * = saSalesManagerMapper.selectAnyOne(); if (ssData == null) {//
     * 一条数据都没有，需要初始化 initAllSalesManagerAnalysisData();
     * generateSalesManagerAnalysisForMonth(year, 13, null); new
     * AnalysisDataNotBeenInitializedException("开始初始化销售经理的销售统计数据，请稍后查询"); } else
     * { generateSalesManagerAnalysisForMonth(year, 13, null);
     * generateSalesManagerAnalysisForMonth(year - 1, 13, null); } ssmList =
     * saSalesManagerMapper
     * .selectSalesManagerAnalysisDataByYearAndMonthWithPreviousData( year + "",
     * "13", (year - 1) + ""); }
     */
    final SalesManagerAnalysisYearStView smaysv =
        new SalesManagerAnalysisYearStView();
    if (saSalesSt != null) {
      smaysv.setYear(year);
      smaysv.setAnnualCommodityCountTotal(saSalesSt.getCommodityCount() != null
          ? saSalesSt.getCommodityCount() : 0);
      smaysv.setAnnualGroupCountTotal(
          saSalesSt.getGroupCount() != null ? saSalesSt.getGroupCount() : 0);
      smaysv.setAnnualSalesTotal(
          saSalesSt.getSalesTotal() != null ? saSalesSt.getSalesTotal() : 0);
      smaysv.setManagerCount(ssmList.size() != 0 ? ssmList.size() : 0);
      smaysv.setDataList(ssmList);
    }
    return smaysv;
  }

  /**
   * 初始化销售经理的销售统计数据
   *
   * @return
   */
  @Override
  public boolean initAllSalesManagerAnalysisData() {
    final String shipmt_e =
        contractGradeMapper.selectEarliestContractGradeShipmt();
    final String shipmt_l =
        contractGradeMapper.selectLatestContractGradeShipmt();
    if (Strings.isNullOrEmpty(shipmt_e)) {
      logger.error("No contract grade data, init salesAnalysis failure");
      return false;
    }
    final Date eDate =
        CommonTools.parseStringToDate(shipmt_e, CommonTools.DATEFORMAT_Y4_MM);
    final Date lDate =
        CommonTools.parseStringToDate(shipmt_l, CommonTools.DATEFORMAT_Y4_MM);
    if (eDate == null || lDate == null) {
      logger.error("shipmt error , init salesAnalysis failure");
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
      generateSalesManagerAnalysisForMonth(currentYear, currentMonth, null);
      if (currentMonth == 12) {// 如果是12月，则需要计算一次当年的统计数据
        generateSalesManagerAnalysisForMonth(currentYear, 13, null);
      }
      eCalendar.add(Calendar.MONTH, 1);
    }
    generateSalesManagerAnalysisForMonth(currentYear, 13, null);
    logger.info("Generaet all salesManagerAnalysis success!!");
    return true;
  }

  @Override
  public boolean generateSalesManagerAnalysisForMonth(final int year,
      final int month, final Long uid) {
    if (year < 1970 || year > 2100 || month < 1 || month > 13) {
      logger.info("param error , year=" + year + ",month=" + month);
      return false;
    }

    final List<SaSalesManager> ssmList;
    if (month == 13) {// 一整年的销售经理销售统计数据
      ssmList = saSalesManagerMapper
          .getManagerSalesAnalysisFromContractDataForYear(year + "", uid);
    } else {// 单个月的销售经理销售统计数据
      ssmList = saSalesManagerMapper.getManagerSalesAnalysisFromContractData(
          year + "-" + month + "", year + "", month + "", uid);
    }

    if (!CommonTools.isListNullOrEmpty(ssmList)) {
      for (final SaSalesManager ssm : ssmList) {
        // 有则更新，没有则写入
        SaSalesManager ssmExist =
            saSalesManagerMapper.selectByUidAndYearAndMonth(ssm.getUid(),
                ssm.getYear(), ssm.getMonth());
        if (ssmExist == null) {
          ssmExist = new SaSalesManager();
          ssmExist.setUid(ssm.getUid());
          ssmExist.setYear(ssm.getYear());
          ssmExist.setMonth(ssm.getMonth());
          ssmExist.setCommodityCount(ssm.getCommodityCount());
          ssmExist.setGroupCount(ssm.getGroupCount());
          ssmExist.setSalesTotal(ssm.getSalesTotal());
          ssmExist.setCreateTime(new Date());
          ssmExist.setLastUpdateTime(new Date());
          saSalesManagerMapper.insertSelective(ssmExist);
        } else {
          ssmExist.setCommodityCount(ssm.getCommodityCount());
          ssmExist.setGroupCount(ssm.getGroupCount());
          ssmExist.setSalesTotal(ssm.getSalesTotal());
          ssmExist.setLastUpdateTime(new Date());
          saSalesManagerMapper.updateByPrimaryKey(ssmExist);
        }
      }
      logger.info(
          "生成" + year + "-" + month + "銷售分析-銷售經理情況，并写入DB");
    }else if(uid!=null){
      //如果不是初始化
      saSalesManagerMapper.deleteSaSalesManagerByYearAndMonth(month + "",
          year + "",uid);
    }
    return true;
  }

  @Override
  public SingleSalesManagerAnalysisYearStView selectSingleSalesManagerAnalySisStatistics(
      final int year, final Long uid) {
    final SaSalesManager ssm =
        saSalesManagerMapper.selectByUidAndYearAndMonth(uid, year + "", "13");
    final SingleSalesManagerAnalysisYearStView ssmays =
        new SingleSalesManagerAnalysisYearStView();
    final User user = userMapper.selectByPrimaryKey(uid);
    ssmays.setCommodityCount(ssm != null ? ssm.getCommodityCount() : 0);
    ssmays.setGroupCount(ssm != null ? ssm.getGroupCount() : 0);
    ssmays.setSalesTotal(ssm != null ? ssm.getSalesTotal() : 0d);
    ssmays.setUid(uid);
    ssmays.setYear(year);
    ssmays.setUname(user != null ? user.getUname() : "");
    return ssmays;
  }

  @Override
  public List<SalesAnalysisDataView> selectSingleSalesManagerAnalySisDetailOfSaleTotal(
      final int year, final Long uid) {
    final List<SalesAnalysisDataView> savList = saSalesManagerMapper
        .selectSingleSalesManagerAnalySisDetailOfSaleTotal(uid, year + "");
    final List<SalesAnalysisDataView> lastList =
        saSalesManagerMapper.selectSingleSalesManagerAnalySisDetailOfSaleTotal(
            uid, (year - 1) + "");
    // 补全十二个月数据
    final List<SalesAnalysisDataView> list =
        SaDataAnalysisUtil.completeDetailedMonthlyData(savList, lastList, year);
    return list;
  }

  @Override
  public List<SalesManagerAnalysisOfCustomerData> selectSalesManagerAnalysisOfCustomerData(
      final int year, final Long uid, final String searchkey) {
    String searchKey = null;
    if (!Strings.isNullOrEmpty(searchkey)) {
      searchKey = "%" + searchkey + "%";
    }
    final List<SalesManagerAnalysisOfCustomerData> list =
        saSalesManagerMapper.selectSingleSalesManagerAnalysisOfCustomerData(uid,
            year + "", searchKey);
    return list;
  }

  @Override
  public List<SalesAnalysisDataView> selectSalseCustomerPurchases(
      final Long gid, final Integer year, final Long uid) {
    final List<SalesAnalysisDataView> savList =
        saSalesManagerMapper.selectSalseCustomerPurchases(gid, uid, year + "");
    final List<SalesAnalysisDataView> lastList = saSalesManagerMapper
        .selectSalseCustomerPurchases(gid, uid, year - 1 + "");
    // 补全十二个月数据
    final List<SalesAnalysisDataView> list =
        SaDataAnalysisUtil.completeDetailedMonthlyData(savList, lastList, year);
    return list;
  }

  @Override
  public List<SalesManagerAnalysisOfCustomerData> searchSalseCommodity(
      final Map<String, Object> map) {
    final List<SalesManagerAnalysisOfCustomerData> list =
        saSalesManagerMapper.searchSalseCommodityName(map);
    return list;
  }

  @Override
  public List<SalesAnalysisDataView> completeCommodityDetailedMonthlyData(
      final Long uid, final Long ctid, final Long mfid, final Integer year) {
    final List<SalesAnalysisDataView> savList = saSalesManagerMapper
        .completeCommodityDetailedMonthlyData(uid, ctid, mfid, year + "");
    final List<SalesAnalysisDataView> lastList = saSalesManagerMapper
        .completeCommodityDetailedMonthlyData(uid, ctid, mfid, year - 1 + "");
    // 补全十二个月数据
    final List<SalesAnalysisDataView> list =
        SaDataAnalysisUtil.completeDetailedMonthlyData(savList, lastList, year);
    return list;
  }

}
