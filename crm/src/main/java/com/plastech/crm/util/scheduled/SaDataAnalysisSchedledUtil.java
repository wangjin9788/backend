package com.plastech.crm.util.scheduled;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import com.plastech.crm.service.ExportService;
import com.plastech.crm.service.SaCommodityAnalysisServer;
import com.plastech.crm.service.SaCommodityPurchaseService;
import com.plastech.crm.service.SaCustomerDetailAnalysisService;
import com.plastech.crm.service.SaGroupsAnalysisService;
import com.plastech.crm.service.SaManagerAnalysisService;
import com.plastech.crm.service.SaManufacturerAnalysisService;
import com.plastech.crm.service.SaSalesAnalysisService;
import com.plastech.crm.util.CommonTools;
import net.javacrumbs.shedlock.core.SchedulerLock;

/**
 * @author wangJin
 *
 * @date 2019年3月6日 上午10:20:45
 *
 */
@Configuration
public class SaDataAnalysisSchedledUtil {
  Logger logger = LoggerFactory.getLogger(SaDataAnalysisSchedledUtil.class);

  private static final int ONE_MONTH = 28 * 24 * 60 * 60 * 1000;

  @Autowired
  protected SaSalesAnalysisService saSalesAnalysisService;

  @Autowired
  protected SaManagerAnalysisService saManagerAnalysisService;

  @Autowired
  protected SaCommodityAnalysisServer saCommodityAnalysisServer;

  @Autowired
  protected SaManufacturerAnalysisService saManufacturerAnalysisService;

  @Autowired
  protected SaSalesAnalysisService salesAnalysisService;

  @Autowired
  protected ExportService exportService;

  @Autowired
  protected SaGroupsAnalysisService saGroupsAnalysisService;

  @Autowired
  protected SaCommodityPurchaseService saCommodityPurchaseService;

  @Autowired
  protected SaCustomerDetailAnalysisService saCustomerDetailAnalysisService;

  /**
   * 销售分析品类
   */
  @Scheduled(cron = "0 0 1 1 * ?")
  @SchedulerLock(name = "insertSaCommodityAnalysis", lockAtMostFor = ONE_MONTH,
      lockAtLeastFor = ONE_MONTH)
  public void insertCommodityAnalysis() {
    try {
      final Integer currentYear =
          Integer.parseInt(getCurrentYearAndLastMonth().get("year"));
      final Integer currentMonth =
          Integer.parseInt(getCurrentYearAndLastMonth().get("month"));
      // 销售列表月
      saSalesAnalysisService.generateSalesAnalysisForMonth(currentYear,
          currentMonth);
      // 销售列表年
      saSalesAnalysisService.generateSalesAnalysisForYear(currentYear);
      // 销售经理月
      saManagerAnalysisService.generateSalesManagerAnalysisForMonth(currentYear,
          currentMonth,null);
      // 销售经理年
      saManagerAnalysisService.generateSalesManagerAnalysisForMonth(currentYear,
          13,null);
      // 销售品类月
      saCommodityAnalysisServer
          .generateSalesCommodityAnalysisForMonth(currentYear, currentMonth, null, null);
      // 销售品类年
      saCommodityAnalysisServer
          .generateSalesCommodityAnalysisForMonth(currentYear, 13, null, null);
      // 品类详情月
      saCommodityAnalysisServer.generateSalesCommodityDetailAnalysisForMonth(
          currentYear, currentMonth, null, null, null);
      // 品类详情年
      saCommodityAnalysisServer
          .generateSalesCommodityDetailAnalysisForMonth(currentYear, 13, null, null, null);
      // 生产商统计月
      saManufacturerAnalysisService.generateSalesAnalysisForMonth(currentYear,
          currentMonth, null);
      // 生产商统计年
      saManufacturerAnalysisService.generateSalesAnalysisForMonth(currentYear,
          13, null);
      // 生产商客户添加月
      saManufacturerAnalysisService
          .generateSalesManufacturerAnalysisForMonth(currentYear, currentMonth, null, null);
      // 生产商客户添加年
      saManufacturerAnalysisService
          .generateSalesManufacturerAnalysisForMonth(currentYear, 13, null, null);
      // 生产商客户详情月
      saManufacturerAnalysisService
          .generateSalesManufacturerDetailAnalysisForMonth(currentYear,
              currentMonth, null, null, null);
      // 生产商客户详情年
      saManufacturerAnalysisService
          .generateSalesManufacturerDetailAnalysisForMonth(currentYear, 13, null, null, null);
      // 客户分析年度購買情況（月）
      saGroupsAnalysisService.generateSaGroupsAnalysisForMonth(currentYear,
          currentMonth, null);
      // 客户分析年度購買情況（年）
      saGroupsAnalysisService.generateSaGroupsAnalysisForMonth(currentYear, 13, null);
      // 品類購買情況(月)
      saCommodityPurchaseService
          .generateSaCommodityPurchaseForMonth(currentYear, currentMonth, null, null, null);
      // 品類購買情況(年)
      saCommodityPurchaseService
          .generateSaCommodityPurchaseForMonth(currentYear, 13, null, null, null);
      // 客户分析客户購買情況（月）
      saCustomerDetailAnalysisService
          .generateSaCustomerDetailForMonth(currentYear, currentMonth, null, null, null, null);
      // 客户分析客户購買情況（年）
      saCustomerDetailAnalysisService
          .generateSaCustomerDetailForMonth(currentYear, 13, null, null, null, null);

      logger.info("insert SaCommodity Analysis : SUCCESS:{}", CommonTools
          .parseDateToString(new Date(), CommonTools.DATEFORMAT_Y4_MM_DD_HMS));
    } catch (final Exception e) {
      logger.info("insert  Commodity Analysis Exception", e);
    }
  }


  private Map<String, String> getCurrentYearAndLastMonth() {
    final Map<String, String> map = new HashMap<>();
    String year = null;
    // 当年
    year = CommonTools.parseDateToString(new Date(), CommonTools.DATEFORMAT_Y4);
    final Calendar lCalendar = Calendar.getInstance();
    lCalendar.setTime(new Date());
    lCalendar.add(Calendar.MONTH, -1);
    // 上一个月
    final String month = CommonTools.parseDateToString(lCalendar.getTime(),
        CommonTools.DATEFORMAT_M2);
    // 如果等于十二说明是去年的
    if (month.equals("12")) {
      year = CommonTools.parseDateToString(lCalendar.getTime(),
          CommonTools.DATEFORMAT_Y4);
    }
    map.put("year", year);
    map.put("month", month);
    return map;
  }
}
