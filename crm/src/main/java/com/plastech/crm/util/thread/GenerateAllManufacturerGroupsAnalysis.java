package com.plastech.crm.util.thread;

import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.plastech.crm.mapper.SaManufacturerAnalysisMapper;
import com.plastech.crm.model.SaManufacturerAnalysis;
import com.plastech.crm.service.SaManufacturerAnalysisService;

/**
 * 生成所有的销售经理销售统计数据
 *
 * @author : yemin
 * @date : 2019年3月6日 上午10:54:16
 *
 */
public class GenerateAllManufacturerGroupsAnalysis implements Runnable {

  private static final Logger logger =
      LoggerFactory.getLogger(GenerateAllManufacturerGroupsAnalysis.class);

  private final Date eDate;
  private final Date lDate;
  private final Integer year;
  private final SaManufacturerAnalysisService saManufacturerAnalysisService;
  private final  SaManufacturerAnalysisMapper saManufacturerMapper;

  /**
   * @param eDate
   * @param lDate
   * @param year
   * @param saManufacturerAnalysisService
   * @param saManufacturerMapper
   */
  public GenerateAllManufacturerGroupsAnalysis(final Date eDate, final Date lDate,
      final Integer year, final SaManufacturerAnalysisService saManufacturerAnalysisService,
      final SaManufacturerAnalysisMapper saManufacturerMapper) {
    super();
    this.eDate = eDate;
    this.lDate = lDate;
    this.year = year;
    this.saManufacturerAnalysisService = saManufacturerAnalysisService;
    this.saManufacturerMapper = saManufacturerMapper;
  }

  @Override
  public void run() {
    checkManufacturerInfo();
  }

  private boolean checkManufacturerInfo() {
    try {
      final Calendar cal = Calendar.getInstance();
      final int currentYear = cal.get(Calendar.YEAR);
      if (year > currentYear) {
        return false;
      }
      final SaManufacturerAnalysis analysis =
          saManufacturerMapper.checkSaManufacturerInfo();
      if (analysis == null) {
        initAllManufacturerAnalysisData();
      } else {
        // 最近一年的总数据
        saManufacturerAnalysisService
            .generateSalesManufacturerAnalysisForMonth(year, 13, null, null);
        saManufacturerAnalysisService
            .generateSalesManufacturerAnalysisForMonth(year - 1, 13, null, null);
      }

      return true;
    } catch (final Exception e) {
      logger.info("insert exception", e);
    }
    return false;
  }

  private void initAllManufacturerAnalysisData() {
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
}
