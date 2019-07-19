package com.plastech.crm.util.thread;

import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.plastech.crm.service.SaCustomerDetailAnalysisService;

/**
 * 生成所有的销售经理销售统计数据
 *
 * @author : yemin
 * @date : 2019年3月6日 上午10:54:16
 *
 */
public class GenerateSaCustomerDetailAnalysis implements Runnable {

  private static final Logger logger =
      LoggerFactory.getLogger(GenerateSaCustomerDetailAnalysis.class);

  private final Date eDate;
  private final Date lDate;
  private final SaCustomerDetailAnalysisService saCustomerDetailAnalysisService;

  public GenerateSaCustomerDetailAnalysis(final Date eDate, final Date lDate,
      final SaCustomerDetailAnalysisService saCustomerDetailAnalysisService) {
    super();
    this.eDate = eDate;
    this.lDate = lDate;
    this.saCustomerDetailAnalysisService = saCustomerDetailAnalysisService;
  }

  @Override
  public void run() {
    final Calendar eCalendar = Calendar.getInstance();
    eCalendar.setTime(eDate);
    final Calendar lCalendar = Calendar.getInstance();
    lCalendar.setTime(lDate);

    while (eCalendar.compareTo(lCalendar) <= 0) {
      final int currentYear = eCalendar.get(Calendar.YEAR);// 当前年
      final int currentMonth = eCalendar.get(Calendar.MONTH) + 1;// 当前月
      saCustomerDetailAnalysisService.generateSaCustomerDetailForMonth(currentYear, currentMonth, null, null, null, null);
      if (currentMonth == 12) {// 如果是12月，则需要计算一次当年的统计数据
        saCustomerDetailAnalysisService
            .generateSaCustomerDetailForMonth(currentYear, 13, null, null, null, null);
      }
      eCalendar.add(Calendar.MONTH, 1);
    }
    logger.info("Generaet all salesManagerAnalysis success!!");
  }

}
