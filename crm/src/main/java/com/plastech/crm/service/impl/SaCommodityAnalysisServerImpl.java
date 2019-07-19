package com.plastech.crm.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.plastech.crm.model.SaCommodityAnalysis;
import com.plastech.crm.model.SaCommodityDetail;
import com.plastech.crm.model.parameter.SaCommodityParameters;
import com.plastech.crm.model.vo.SaCommodityAnalysisView;
import com.plastech.crm.model.vo.SaCommodityCustomerView;
import com.plastech.crm.model.vo.SaCommodityDetailView;
import com.plastech.crm.model.vo.SaGroupsCommodityOrManufacturerView;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;
import com.plastech.crm.service.SaCommodityAnalysisServer;
import com.plastech.crm.util.CommonTools;
import com.plastech.crm.util.SaDataAnalysisUtil;

/**
 * @author wangJin
 *
 * @date 2019年2月22日 上午10:22:57
 *
 */
@Service
public class SaCommodityAnalysisServerImpl extends BaseService
    implements SaCommodityAnalysisServer {

  protected static final Logger log =
      LoggerFactory.getLogger(SaCommodityAnalysisServerImpl.class);

  @Override
  public SalesAnalysisView commoditySalesList(final Map<String, Object> map,
      final Integer year) {
    try {
      // 根据条件查询数据
      final SalesAnalysisView totalQuantity =
          saCommodityAnalysisMapper.getCommodityTotalQuantity(map);
      /*
       * if (totalQuantity == null) { // 查询统计表中的数据 final SaCommodityAnalysis
       * checkSaCommodity = saCommodityAnalysisMapper.checkSaCommodity(); if
       * (checkSaCommodity == null) { initAllCommodityAnalysisData(1, map,
       * year); } }
       */
      if (totalQuantity != null) {
        final List<SaCommodityAnalysisView> list =
            saCommodityAnalysisMapper.searchCommodityAnalysisById(map);
        if (totalQuantity != null) {
          totalQuantity.setCommList(list);
        }
      }
      return totalQuantity;
    } catch (final Exception e) {
      log.info("searchCommodityAnalysis Exception", e);
    }
    return null;
  }

  @Override
  public boolean generateSalesCommodityAnalysisForMonth(final int year,
      final int month, final Long ctid, final Long mfid) {
    if (year < 1970 || year > 2100 || month < 1 || month > 13) {
      log.info("param error , year=" + year + ",month=" + month);
      return false;
    }

    List<SaCommodityAnalysis> ssmList;
    if (month == 13) {// 一整年的销售经理销售统计数据
      ssmList = saCommodityAnalysisMapper
          .getCommodityAnalysisFromContractDataForYear(year + "", ctid, mfid);
    } else {// 单个月的销售经理销售统计数据
      final String monthStr = month < 10 ? "0" + month : month + "";
      ssmList = saCommodityAnalysisMapper.getCommodityAnalysis(year + "",
          monthStr, ctid, mfid);
    }

    if (!CommonTools.isListNullOrEmpty(ssmList)) {
      for (final SaCommodityAnalysis ssm : ssmList) {
        // 有则更新，没有则写入
        SaCommodityAnalysis info = saCommodityAnalysisMapper
            .getSaCommodityInfoById(Integer.parseInt(ssm.getYear()),
                ssm.getMonth(), ssm.getCtid(), ssm.getMfid());
        if (info == null) {
          info = new SaCommodityAnalysis();
          info.setCtid(ssm.getCtid());
          info.setMfid(ssm.getMfid());
          info.setCtName(ssm.getCtName());
          info.setMfName(ssm.getMfName());
          info.setCustomersCount(ssm.getCustomersCount());
          info.setYear(ssm.getYear());
          info.setMonth(ssm.getMonth());
          info.setSalesTotal(ssm.getSalesTotal());
          info.setCreateTime(new Date());
          saCommodityAnalysisMapper.insertSelective(ssm);
        } else {
          info.setCustomersCount(ssm.getCustomersCount());
          info.setSalesTotal(ssm.getSalesTotal());
          info.setLastUpdateTime(new Date());
          saCommodityAnalysisMapper.updateByPrimaryKey(info);
        }
      }
      log.info("生成" + year + "-" + month + "的銷售分析-熱門品類銷售情況，并写入DB");
    } else if (ctid != null && mfid != null) {
      saCommodityAnalysisMapper.deleteSaCommodityByYearAndMonth(month + "",
          year + "", ctid, mfid);
    }
    return true;
  }

  @Override
  public boolean searchSaCommodityDetail(final Map<String, Object> map,
      final Integer year) {
    try {
      final Calendar cal = Calendar.getInstance();
      final int currentYear = cal.get(Calendar.YEAR);
      if (year > currentYear) {
        return false;
      }
      // 查询saCommodityDetail表中是否数据
      final SaCommodityDetail detail =
          saCommodityDetailMapper.checkSaCommodityDetail();
      if (detail == null) {
        initSaConnodityDetail();
      } else {
        generateSalesCommodityDetailAnalysisForMonth(year, 13, null, null,
            null);
        generateSalesCommodityDetailAnalysisForMonth(year - 1, 13, null, null,
            null);
      }
      return true;
    } catch (final Exception e) {
      log.info("insert SaCommodity Detail Exception", e);
    }
    return false;
  }

  @Override
  public boolean generateSalesCommodityDetailAnalysisForMonth(final int year,
      final int month, final Long ctid, final Long mfid, final Long gid) {
    if (year < 1970 || year > 2100 || month < 1 || month > 13) {
      log.info("param error , year=" + year + ",month=" + month);
      return false;
    }
    List<SaCommodityParameters> ssmList;
    if (month == 13) {// 统计一整年数据
      ssmList = saCommodityDetailMapper
          .getCommodityDetailAnalysisFromContractDataForYear(year + "", ctid,
              mfid, gid);
    } else {// 单个月的销售经理销售统计数据
      ssmList = saCommodityDetailMapper.getSaCommodityDetailAnalysis(year + "",
          month + "", ctid, mfid, gid);
    }
    if (!CommonTools.isListNullOrEmpty(ssmList)) {
      for (final SaCommodityParameters param : ssmList) {
        // 有则更新，没有则写入
        SaCommodityDetail detailInfo =
            saCommodityDetailMapper.getSaCommodityDetailInfo(
                Integer.parseInt(param.getYear()), param.getMonth(),
                param.getCtid(), param.getMfid(), param.getName());
        if (detailInfo == null) {
          detailInfo = new SaCommodityDetail();
          detailInfo.setCtid(param.getCtid());
          detailInfo.setMfid(param.getMfid());
          detailInfo.setGid(param.getGid());
          detailInfo.setCuName(param.getName());
          detailInfo.setScdYear(param.getYear());
          detailInfo.setScdMonth(param.getMonth());
          detailInfo.setPurchaseQuantity(param.getQuantity());
          detailInfo.setCreateTime(new Date());
          saCommodityDetailMapper.insertSelective(detailInfo);
        } else {
          detailInfo.setPurchaseQuantity(param.getQuantity());
          detailInfo.setLastUpdateTime(new Date());
          saCommodityDetailMapper.updateByPrimaryKey(detailInfo);
        }
      }
      log.info("生成" + year + "-" + month + "銷售分析-的熱門品類銷售情況-详情，并写入DB");
    } else if (ctid != null && mfid != null && gid != null) {
      saCommodityDetailMapper.deleteSaCommodityDetailByYearAndMonth(year, month,
          ctid, mfid, gid);
    }
    return true;
  }



  @Override
  public SaCommodityDetailView commodityAnalysisDetail(
      final Map<String, Object> map, final Integer year) {
    try {
      // 根据条件查询
      final SaCommodityDetailView detailView =
          saCommodityAnalysisMapper.getCommodityAnalysisDetail(map);
      if (detailView == null) {
        final SaCommodityDetail checkSaCommodityDetail =
            saCommodityDetailMapper.checkSaCommodityDetail();
        if (checkSaCommodityDetail == null) {
          initSaConnodityDetail();
        }
      } else {
        final List<SalesAnalysisDataView> savList =
            saCommodityAnalysisMapper.getCommodityAnalysisMonthDetail(map);
        map.remove("year");
        map.put("year", year - 1);
        final List<SalesAnalysisDataView> lastList =
            saCommodityAnalysisMapper.getCommodityAnalysisMonthDetail(map);
        final List<SalesAnalysisDataView> list = SaDataAnalysisUtil
            .completeDetailedMonthlyData(savList, lastList, year);
        detailView.setMonthyList(list);
      }
      return detailView;
    } catch (final Exception e) {
      log.info("commodity Analysis Detail Exception", e);
    }
    return null;
  }


  @Override
  public List<SaCommodityCustomerView> getCommodityAnalysisCustomer(
      final Map<String, Object> map, final Integer year) {
    try {
      final List<SaCommodityCustomerView> list =
          saCommodityDetailMapper.getCommodityAnalysisCustomer(map);
      /*
       * if (list == null || list.isEmpty()) { searchSaCommodityDetail(map,
       * year); }
       */
      return list;
    } catch (final Exception e) {
      log.info("get Commodity Analysis Customer Exception", e);
    }
    return null;
  }

  @Override
  public List<SalesAnalysisDataView> getCommodityCustomerStatistics(
      final Map<String, Object> map, final Integer year) {
    try {
      final List<SalesAnalysisDataView> savList =
          saCommodityDetailMapper.getCustomerStatistics(map);
      List<SalesAnalysisDataView> list = null;
      if (savList != null) {
        map.remove("year");
        map.put("year", year - 1 + "");
        final List<SalesAnalysisDataView> lastList =
            saCommodityDetailMapper.getCustomerStatistics(map);
        // 补全十二个月数据
        list = SaDataAnalysisUtil.completeDetailedMonthlyData(savList, lastList,
            year);
      }
      return list;
    } catch (final Exception e) {
      log.info("get Commodity Customer Statistics Exception", e);
    }
    return null;
  }

  @Override
  public List<SaGroupsCommodityOrManufacturerView> getCommodity(
      final Integer year) {
    return saCommodityAnalysisMapper.getCommodity(year + "");
  }

  @Override
  public List<SaGroupsCommodityOrManufacturerView> getManufacturer(
      final Integer year) {
    return saCommodityAnalysisMapper.getManufacturer(year + "");
  }

  // 初始化熱門品類銷售情況
  @Override
  public void initAllCommodityAnalysisData() {
    final String shipmt_e =
        contractGradeMapper.selectEarliestContractGradeShipmt();
    final String shipmt_l =
        contractGradeMapper.selectLatestContractGradeShipmt();

    final Date eDate =
        CommonTools.parseStringToDate(shipmt_e, CommonTools.DATEFORMAT_Y4_MM);
    final Date lDate =
        CommonTools.parseStringToDate(shipmt_l, CommonTools.DATEFORMAT_Y4_MM);

    final Calendar eCalendar = Calendar.getInstance();
    eCalendar.setTime(eDate);
    final Calendar lCalendar = Calendar.getInstance();
    lCalendar.setTime(lDate);
    int currentYear = 0;
    int currentMonth = 0;

    while (eCalendar.compareTo(lCalendar) <= 0) {
      currentYear = eCalendar.get(Calendar.YEAR);// 当前年
      currentMonth = eCalendar.get(Calendar.MONTH) + 1;// 当前月
      generateSalesCommodityAnalysisForMonth(currentYear, currentMonth, null,
          null);
      if (currentMonth == 12) {// 如果是12月，则需要计算一次当年的统计数据
        generateSalesCommodityAnalysisForMonth(currentYear, 13, null, null);
      }
      eCalendar.add(Calendar.MONTH, 1);
    }
    generateSalesCommodityAnalysisForMonth(currentYear, 13, null, null);
  }

  @Override
  public void initSaConnodityDetail() {
    final String shipmt_e =
        contractGradeMapper.selectEarliestContractGradeShipmt();
    final String shipmt_l =
        contractGradeMapper.selectLatestContractGradeShipmt();
    final Date eDate =
        CommonTools.parseStringToDate(shipmt_e, CommonTools.DATEFORMAT_Y4_MM);
    final Date lDate =
        CommonTools.parseStringToDate(shipmt_l, CommonTools.DATEFORMAT_Y4_MM);
    final Calendar eCalendar = Calendar.getInstance();
    eCalendar.setTime(eDate);
    final Calendar lCalendar = Calendar.getInstance();
    lCalendar.setTime(lDate);
    int currentYear = 0;
    int currentMonth = 0;
    while (eCalendar.compareTo(lCalendar) <= 0) {
      currentYear = eCalendar.get(Calendar.YEAR);// 当前年
      currentMonth = eCalendar.get(Calendar.MONTH) + 1;// 当前月
      generateSalesCommodityDetailAnalysisForMonth(currentYear, currentMonth,
          null, null, null);
      if (currentMonth == 12) {// 如果是12月，则需要计算一次当年的统计数据
        generateSalesCommodityDetailAnalysisForMonth(currentYear, 13, null,
            null, null);
      }
      eCalendar.add(Calendar.MONTH, 1);
    }
    generateSalesCommodityDetailAnalysisForMonth(currentYear, 13, null, null,
        null);
  }
}

