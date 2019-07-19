package com.plastech.crm.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;
import com.plastech.crm.model.Loyalty;
import com.plastech.crm.model.SaManufacturerAnalysis;
import com.plastech.crm.model.SaManufacturerDetail;
import com.plastech.crm.model.SaManufacturerSt;
import com.plastech.crm.model.vo.SaCustomerPurchaseDetailsView;
import com.plastech.crm.model.vo.SaManufacturerCommodityView;
import com.plastech.crm.model.vo.SaManufacturerLoyaltyView;
import com.plastech.crm.model.vo.SaManufacturerTotalDataView;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;
import com.plastech.crm.service.SaManufacturerAnalysisService;
import com.plastech.crm.util.CommonTools;
import com.plastech.crm.util.SaDataAnalysisUtil;

/**
 * @author wangJin
 *
 * @date 2019年2月28日 下午1:23:15
 *
 */
@Service
public class SaManufacturerAnalysisServiceImpl extends BaseService
    implements SaManufacturerAnalysisService {

  @Override
  public SalesAnalysisView getSaManufacturerList(final Map<String, Object> map,
      final Integer year) {
    try {
      final SalesAnalysisView selectTotalQuantity =
          saManufacturerStMapper.selectTotalQuantity(map);
      if (selectTotalQuantity != null) {
        final List<SalesAnalysisDataView> sadList =
            saManufacturerStMapper.getSaManufacturerStatisticsList(map);
        map.remove("year");
        map.put("year", year - 1 + "");
        final List<SalesAnalysisDataView> lastList =
            saManufacturerStMapper.getSaManufacturerStatisticsList(map);
        // 补全十二个月数据
        final List<SalesAnalysisDataView> list = SaDataAnalysisUtil
            .completeDetailedMonthlyData(sadList, lastList, year);
        selectTotalQuantity.setDataList(list);
      }
      return selectTotalQuantity;
    } catch (final Exception e) {
      logger.info("getSa Manufacturer List Exception", e);
    }
    return null;
  }

  @Override
  public boolean selectSalesAnalysisByYear(final int year) {
    final Calendar cal = Calendar.getInstance();
    final int currentYear = cal.get(Calendar.YEAR);
    if (year > currentYear) {
      return false;
    }
    final SaManufacturerSt sms =
        saManufacturerStMapper.selectAnyData(year + "");
    if (sms == null) {
      initSalesAnalysis();
    }
    generateSalesAnalysisForMonth(currentYear, 13, null);
    generateSalesAnalysisForMonth(currentYear - 1, 13, null);

    return true;
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
      logger.error("shipmt error , init salesAnalysis failure");
      return false;
    }
    initManufacturerAnalysis(eDate, lDate);
    return true;
  }

  public void initManufacturerAnalysis(final Date eDate, final Date lDate) {
    final Calendar eCalendar = Calendar.getInstance();
    eCalendar.setTime(eDate);
    final Calendar lCalendar = Calendar.getInstance();
    lCalendar.setTime(lDate);
    int currentYear = 0;
    int currentMonth = 0;
    while (eCalendar.compareTo(lCalendar) <= 0) {
      currentYear = eCalendar.get(Calendar.YEAR);// 当前年
      currentMonth = eCalendar.get(Calendar.MONTH) + 1;// 当前月
      generateSalesAnalysisForMonth(currentYear, currentMonth, null);
      if (currentMonth == 12) {// 如果是12月，则需要计算一次当年的统计数据
        generateSalesAnalysisForMonth(currentYear, 13, null);
      }
      eCalendar.add(Calendar.MONTH, 1);
    }
    generateSalesAnalysisForMonth(currentYear, 13, null);
    logger.info("Generaet all salesManagerAnalysis success!!");
  }

  @Override
  public boolean generateSalesAnalysisForMonth(final int year, final int month,
      final Long mfid) {
    try {
      if (year < 1970 || year > 2100 || month < 1 || month > 13) {
        logger.info("param error , year=" + year + ",month=" + month);
        return false;
      }
      final String yearStr = year + "";
      final List<SaManufacturerSt> salseInfo;
      if (month == 13) {
        salseInfo =
            saManufacturerStMapper.getContractSalseYearInfo(year + "", mfid);
      } else {
        salseInfo = saManufacturerStMapper.getContractSalseInfo(yearStr,
            month + "", mfid);
      }
      if (salseInfo != null && !salseInfo.isEmpty()) {
        for (final SaManufacturerSt smsInfo : salseInfo) {
          SaManufacturerSt sms = saManufacturerStMapper.checkSalseManufacturer(
              yearStr, smsInfo.getMonth(), smsInfo.getMfid());
          if (sms == null) {
            sms = new SaManufacturerSt();
            sms.setYear(yearStr);
            sms.setMfid(smsInfo.getMfid());
            sms.setMonth(smsInfo.getMonth());
            sms.setSalesTotal(smsInfo.getSalesTotal());
            sms.setGroupCount(smsInfo.getGroupCount());
            sms.setCommodityCount(smsInfo.getCommodityCount());
            sms.setCreateTime(new Date());
            saManufacturerStMapper.insertSelective(sms);
          } else {
            sms.setSalesTotal(smsInfo.getSalesTotal());
            sms.setGroupCount(smsInfo.getGroupCount());
            sms.setCommodityCount(smsInfo.getCommodityCount());
            sms.setLastUpdateTime(new Date());
            saManufacturerStMapper.updateByPrimaryKey(sms);
          }
        }
        logger.info("生成" + year + "-" + month + "生產商分析-銷售情況，并写入DB");
      } else if (mfid != null) {
        saManufacturerStMapper.deleteManufacturerStByYearAndMonth(year + "",
            month + "", mfid);
      }
      return true;
    } catch (final Exception e) {
      logger.error("Generate salesAnalysis error , {}", e);
    }
    return false;
  }

  @Override
  public List<SaCustomerPurchaseDetailsView> getCustomerPurchaseInformation(
      final Map<String, Object> map, final Integer year) {
    try {
      final List<SaCustomerPurchaseDetailsView> list =
          saManufacturerMapper.getCustomerPurchaseInformation(map);
      return list;
    } catch (final Exception e) {
      logger.info("get Customer Purchase Details List Exception", e);
    }
    return null;
  }


  /**
   * 客戶購買情況
   */
  @Override
  public boolean generateSalesManufacturerAnalysisForMonth(final int year,
      final int month, final Long gid, final Long mfid) {
    if (year < 1970 || year > 2100 || month < 1 || month > 13) {
      logger.info("param error , year=" + year + ",month=" + month);
      return false;
    }

    List<SaManufacturerAnalysis> ssmList;
    if (month == 13) {// 一整年统计数据
      ssmList = saManufacturerMapper
          .getManufacturerGroupsPurchaseAnalysisYear(year + "", gid, mfid);
    } else {// 单个月的销售经理销售统计数据
      ssmList = saManufacturerMapper.getManufacturerGroupsPurchaseAnalysis(
          year + "", month + "", gid, mfid);
    }

    if (!CommonTools.isListNullOrEmpty(ssmList)) {
      final Loyalty loyalty = loyaltyMapper.getDefaultLoyalty();
      for (final SaManufacturerAnalysis ssm : ssmList) {
        // 有则更新，没有则写入
        SaManufacturerAnalysis info =
            saManufacturerMapper.getManufuacturerGroupsInfo(ssm.getYear(),
                ssm.getMonth(), ssm.getMfid(), ssm.getGid(), ssm.getLid());
        if (info == null) {
          info = new SaManufacturerAnalysis();
          info.setMfid(ssm.getMfid());
          info.setCtid(ssm.getCtid());
          info.setMfName(ssm.getMfName());
          info.setLid(ssm.getLid() != null ? ssm.getLid() : loyalty.getLid());
          info.setlName(
              ssm.getlName() != null ? ssm.getlName() : loyalty.getName());
          info.setGid(ssm.getGid());
          info.setgName(ssm.getgName());
          info.setYear(ssm.getYear());
          info.setMonth(ssm.getMonth());
          info.setSalesTotal(ssm.getSalesTotal());
          info.setCreateTime(new Date());
          saManufacturerMapper.insertSelective(info);
        } else {
          info.setSalesTotal(ssm.getSalesTotal());
          info.setLastUpdateTime(new Date());
          saManufacturerMapper.updateByPrimaryKey(info);
        }
      }
      logger.info("生成" + year + "-" + month + "生產商分析-客戶購買情況，并写入DB");
    } else if (gid != null && mfid != null) {
      saManufacturerMapper.deleteSaManufacturerByYearAndMonth(year + "",
          month + "", gid, mfid);
    }
    return true;
  }

  @Override
  public List<SaManufacturerCommodityView> getManufacturerCommodityList(
      final Long gid, final Long mfid, final Integer year, final String name) {
    try {
      String searchKey = null;
      if (!Strings.isNullOrEmpty(name)) {
        searchKey = "%" + name + "%";
      }
      final List<SaManufacturerCommodityView> list = saManufacturerDetailMapper
          .getManufacturerCommodityList(gid, mfid, year + "", searchKey);
      return list;
    } catch (final Exception e) {
      logger.info("get  manufacturer commodity list Exception", e);
    }
    return null;
  }



  @Override
  public boolean generateSalesManufacturerDetailAnalysisForMonth(final int year,
      final int month, final Long ctid, final Long mfid, final Long gid) {
    if (year < 1970 || year > 2100 || month < 1 || month > 13) {
      logger.info("param error , year=" + year + ",month=" + month);
      return false;
    }
    List<SaManufacturerDetail> ssmList;
    if (month == 13) {
      ssmList = saManufacturerDetailMapper
          .getCommodityYearPurchaseQuantity(year + "", ctid, mfid, gid);
    } else {
      ssmList = saManufacturerDetailMapper
          .getCommodityPurchaseQuantity(year + "", month + "", ctid, mfid, gid);
    }

    if (!CommonTools.isListNullOrEmpty(ssmList)) {
      for (final SaManufacturerDetail ssm : ssmList) {
        // 有则更新，没有则写入
        SaManufacturerDetail detailInfo =
            saManufacturerDetailMapper.getSaManufacturerDetailInfo(ssm.getGid(),
                ssm.getMfid(), year + "", ssm.getCtid(), ssm.getSmdMonth());
        if (detailInfo == null) {
          detailInfo = new SaManufacturerDetail();
          detailInfo.setCtid(ssm.getCtid());
          detailInfo.setMfid(ssm.getMfid());
          detailInfo.setCtName(ssm.getCtName());
          detailInfo.setPurchaseQuantity(ssm.getPurchaseQuantity());
          detailInfo.setSmdYear(ssm.getSmdYear());
          detailInfo.setSmdMonth(ssm.getSmdMonth());
          detailInfo.setGid(ssm.getGid());
          ssm.setCreateTime(new Date());
          saManufacturerDetailMapper.insertSelective(detailInfo);
        } else {
          detailInfo.setPurchaseQuantity(ssm.getPurchaseQuantity());
          detailInfo.setLastUpdateTime(new Date());
          saManufacturerDetailMapper.updateByPrimaryKey(detailInfo);
        }
      }
      logger.info("生成" + year + "-" + month + "生產商分析-客戶購買情況-详情的统计数据，并写入DB。");
    } else if (ctid != null && mfid != null && gid != null) {
      saManufacturerDetailMapper.deleteSaManufacturerDetailByYearAndMonth(
          year + "", month + "", ctid, mfid, gid);
    }
    return true;
  }

  @Override
  public List<SaManufacturerLoyaltyView> getAcquireLoyaltyList(
      final String year, final Long gid, final Long mfid) {
    try {
      final String endYear = (Integer.valueOf(year) - 5) + "";
      return saManufacturerDetailMapper.getAcquireLoyaltyList(year, endYear,
          gid, mfid);
    } catch (final Exception e) {
      logger.info("get Acquire Loyalty List Exception", e);
    }
    return null;
  }

  @Override
  public List<SalesAnalysisDataView> getCommodityAnalysisStatisticsList(
      final Long gid, final Long mfid, final Integer year, final Long ctid) {
    try {
      List<SalesAnalysisDataView> list = null;
      final List<SalesAnalysisDataView> sdvlist = saManufacturerDetailMapper
          .getCommodityAnalysisStatisticsList(gid, mfid, year + "", ctid);
      if (sdvlist != null && !sdvlist.isEmpty()) {
        final List<SalesAnalysisDataView> lastList = saManufacturerDetailMapper
            .getCommodityAnalysisStatisticsList(gid, mfid, year - 1 + "", ctid);
        list = SaDataAnalysisUtil.completeDetailedMonthlyData(sdvlist, lastList,
            year);
      }
      return list;
    } catch (final Exception e) {
      logger.info("get Commodity Analysis StatisticsList Exception", e);
    }
    return null;
  }

  @Override
  public List<SaManufacturerLoyaltyView> getManufacturersRelatedGroups(
      final Long mfid, final String year) {
    try {
      return saManufacturerDetailMapper.getManufacturersRelatedGroups(mfid,
          year);
    } catch (final Exception e) {
      logger.info("get Manufacturers Related Groups Exception", e);
    }
    return null;
  }

  @Override
  public SaManufacturerTotalDataView obtainManufacturerRelatedParameters(
      final Long gid, final Long mfid, final String year, final Long lid) {
    final SaManufacturerTotalDataView view = saManufacturerDetailMapper
        .obtainManufacturerRelatedParameters(gid, mfid, year, lid);
    if (view != null) {
      final List<SaManufacturerCommodityView> list = saManufacturerDetailMapper
          .getManufacturerCommodityList(gid, mfid, year + "", null);
      if (list != null && !list.isEmpty()) {
        final String quantity = list.get(0).getQuantity();
        view.setAnnualPurchaseVolume(quantity);
      }
    }
    return view;
  }

  @Override
  public boolean initAllManufacturerAnalysisData() {
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
    final Calendar eCalendar = Calendar.getInstance();
    eCalendar.setTime(eDate);
    final Calendar lCalendar = Calendar.getInstance();
    lCalendar.setTime(lDate);
    int currentYear = 0;
    int currentMonth = 0;
    while (eCalendar.compareTo(lCalendar) <= 0) {
      currentYear = eCalendar.get(Calendar.YEAR);// 当前年
      currentMonth = eCalendar.get(Calendar.MONTH) + 1;// 当前月
      generateSalesManufacturerAnalysisForMonth(currentYear, currentMonth, null,
          null);
      if (currentMonth == 12) {// 如果是12月，则需要计算一次当年的统计数据
        generateSalesManufacturerAnalysisForMonth(currentYear, 13, null, null);
      }
      eCalendar.add(Calendar.MONTH, 1);
    }
    generateSalesManufacturerAnalysisForMonth(currentYear, 13, null, null);
    logger.info("Generaet all Manufacturer Analysis Data success!!");
    return true;
  }

  // 客戶購買情況详情
  @Override
  public boolean initManufacturerDetail() {
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
    final Calendar eCalendar = Calendar.getInstance();
    eCalendar.setTime(eDate);
    final Calendar lCalendar = Calendar.getInstance();
    lCalendar.setTime(lDate);
    int currentYear = 0;
    int currentMonth = 0;
    while (eCalendar.compareTo(lCalendar) <= 0) {
      currentYear = eCalendar.get(Calendar.YEAR);// 当前年
      currentMonth = eCalendar.get(Calendar.MONTH) + 1;// 当前月
      generateSalesManufacturerDetailAnalysisForMonth(currentYear, currentMonth,
          null, null, null);
      if (currentMonth == 12) {// 如果是12月，则需要计算一次当年的统计数据
        generateSalesManufacturerDetailAnalysisForMonth(currentYear, 13, null,
            null, null);
      }
      eCalendar.add(Calendar.MONTH, 1);
    }
    generateSalesManufacturerDetailAnalysisForMonth(currentYear, 13, null, null,
        null);
    logger.info("Generaet all Manufacturer Analysis Detail success!!");
    return true;
  }
}
