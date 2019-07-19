package com.plastech.crm.util.thread;

import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.plastech.crm.service.SaCommodityAnalysisServer;
import com.plastech.crm.service.SaCommodityPurchaseService;
import com.plastech.crm.service.SaGroupsAnalysisService;
import com.plastech.crm.service.SaManufacturerAnalysisService;
import com.plastech.crm.util.CommonTools;

/**
 * @author wangJin
 *
 * @date 2019年5月5日 上午9:40:45
 *
 */
public class StatisticalCustomerDataAnalysis implements Runnable {

  private static final Logger logger =
      LoggerFactory.getLogger(StatisticalCustomerDataAnalysis.class);

  private final String shipmt_e;
  private final String shipmt_l;
  private final SaCommodityAnalysisServer saCommodityAnalysisServer;

  private final SaManufacturerAnalysisService saManufacturerAnalysisService;

  private final SaGroupsAnalysisService saGroupsAnalysisService;
  private final SaCommodityPurchaseService saCommodityPurchaseService;


  /**
   * @param shipmt_e
   * @param shipmt_l
   * @param saCommodityAnalysisServer
   * @param saManufacturerAnalysisService
   * @param saGroupsAnalysisService
   * @param saCommodityPurchaseService
   */
  public StatisticalCustomerDataAnalysis(final String shipmt_e, final String shipmt_l,
      final SaCommodityAnalysisServer saCommodityAnalysisServer,
      final SaManufacturerAnalysisService saManufacturerAnalysisService,
      final SaGroupsAnalysisService saGroupsAnalysisService,
      final SaCommodityPurchaseService saCommodityPurchaseService) {
    super();
    this.shipmt_e = shipmt_e;
    this.shipmt_l = shipmt_l;
    this.saCommodityAnalysisServer = saCommodityAnalysisServer;
    this.saManufacturerAnalysisService = saManufacturerAnalysisService;
    this.saGroupsAnalysisService = saGroupsAnalysisService;
    this.saCommodityPurchaseService = saCommodityPurchaseService;
  }

  @Override
  public void run() {
    final Date eDate =
        CommonTools.parseStringToDate(shipmt_e, CommonTools.DATEFORMAT_Y4_MM);
    final Date lDate =
        CommonTools.parseStringToDate(shipmt_l, CommonTools.DATEFORMAT_Y4_MM);
    if (eDate == null || lDate == null) {
      logger.error("shipmt error , init salesAnalysis failure");
    }
    initAllCommodityAnalysisData(eDate, lDate);
    initAllCommodityDetailAnalysisData(eDate, lDate);
    initAllManufacturerAnalysisData(eDate, lDate);
    initAllGroupsYearAnalysisData(eDate, lDate);
    initAllCommodityPurchaseData(eDate, lDate);
  }

  private void initAllCommodityAnalysisData(final Date eDate,
      final Date lDate) {
    final Calendar eCalendar = Calendar.getInstance();
    eCalendar.setTime(eDate);
    final Calendar lCalendar = Calendar.getInstance();
    lCalendar.setTime(lDate);

    while (eCalendar.compareTo(lCalendar) <= 0) {
      final int currentYear = eCalendar.get(Calendar.YEAR);// 当前年
      final int currentMonth = eCalendar.get(Calendar.MONTH) + 1;// 当前月
      saCommodityAnalysisServer
          .generateSalesCommodityAnalysisForMonth(currentYear, currentMonth, null, null);
      if (currentMonth == 12) {// 如果是12月，则需要计算一次当年的统计数据
        saCommodityAnalysisServer
            .generateSalesCommodityAnalysisForMonth(currentYear, 13, null, null);
      }
      eCalendar.add(Calendar.MONTH, 1);
    }
    logger.info("Generaet all CommodityAnalysis success!!");
  }

  private void initAllCommodityDetailAnalysisData(final Date eDate,
      final Date lDate) {
    final Calendar eCalendar = Calendar.getInstance();
    eCalendar.setTime(eDate);
    final Calendar lCalendar = Calendar.getInstance();
    lCalendar.setTime(lDate);

    while (eCalendar.compareTo(lCalendar) <= 0) {
      final int currentYear = eCalendar.get(Calendar.YEAR);// 当前年
      final int currentMonth = eCalendar.get(Calendar.MONTH) + 1;// 当前月
      saCommodityAnalysisServer.generateSalesCommodityDetailAnalysisForMonth(
          currentYear, currentMonth, null, null, null);
      if (currentMonth == 12) {// 如果是12月，则需要计算一次当年的统计数据
        saCommodityAnalysisServer
            .generateSalesCommodityDetailAnalysisForMonth(currentYear, 13, null, null, null);
      }
      eCalendar.add(Calendar.MONTH, 1);
    }
    logger.info("Generaet all CommodityDetailAnalysis success!!");
  }

  private void initAllManufacturerAnalysisData(final Date eDate,
      final Date lDate) {
    final Calendar eCalendar = Calendar.getInstance();
    eCalendar.setTime(eDate);
    final Calendar lCalendar = Calendar.getInstance();
    lCalendar.setTime(lDate);

    while (eCalendar.compareTo(lCalendar) <= 0) {
      final int currentYear = eCalendar.get(Calendar.YEAR);// 当前年
      final int currentMonth = eCalendar.get(Calendar.MONTH) + 1;// 当前月
      saManufacturerAnalysisService
          .generateSalesManufacturerAnalysisForMonth(currentYear, currentMonth, null, null);
      if (currentMonth == 12) {// 如果是12月，则需要计算一次当年的统计数据
        saManufacturerAnalysisService
            .generateSalesManufacturerAnalysisForMonth(currentYear, 13, null, null);
      }
      eCalendar.add(Calendar.MONTH, 1);
    }
    logger.info("Generaet all salesManagerAnalysis success!!");
  }

  private void initAllGroupsYearAnalysisData(final Date eDate,
      final Date lDate) {
    final Calendar eCalendar = Calendar.getInstance();
    eCalendar.setTime(eDate);
    final Calendar lCalendar = Calendar.getInstance();
    lCalendar.setTime(lDate);

    while (eCalendar.compareTo(lCalendar) <= 0) {
      final int currentYear = eCalendar.get(Calendar.YEAR);// 当前年
      final int currentMonth = eCalendar.get(Calendar.MONTH) + 1;// 当前月
      saGroupsAnalysisService.generateSaGroupsAnalysisForMonth(currentYear,
          currentMonth, null);
      if (currentMonth == 12) {// 如果是12月，则需要计算一次当年的统计数据
        saGroupsAnalysisService.generateSaGroupsAnalysisForMonth(currentYear,
            13, null);
      }
      eCalendar.add(Calendar.MONTH, 1);
    }
    logger.info("Generaet all GroupsYearAnalysis success!!");
  }

  private void initAllCommodityPurchaseData(final Date eDate,
      final Date lDate) {
    final Calendar eCalendar = Calendar.getInstance();
    eCalendar.setTime(eDate);
    final Calendar lCalendar = Calendar.getInstance();
    lCalendar.setTime(lDate);

    while (eCalendar.compareTo(lCalendar) <= 0) {
      final int currentYear = eCalendar.get(Calendar.YEAR);// 当前年
      final int currentMonth = eCalendar.get(Calendar.MONTH) + 1;// 当前月
      saCommodityPurchaseService
          .generateSaCommodityPurchaseForMonth(currentYear, currentMonth, null, null, null);
      if (currentMonth == 12) {// 如果是12月，则需要计算一次当年的统计数据
        saCommodityPurchaseService
            .generateSaCommodityPurchaseForMonth(currentYear, 13, null, null, null);
      }
      eCalendar.add(Calendar.MONTH, 1);
    }
    logger.info("Generaet all CommodityPurchase success!!");
  }
}
