package com.plastech.crm.util.thread;

import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.plastech.crm.service.SaCommodityAnalysisServer;

/**
 * @author wangJin
 *
 * @date 2019年3月21日 上午10:19:45
 *
 */
public class GenerateAllSalesCommodityDetailAnalysis  implements Runnable{
  private static final Logger logger =
      LoggerFactory.getLogger(GenerateAllSalesCommodityDetailAnalysis.class);

  private final Date eDate;
  private final Date lDate;
  private final SaCommodityAnalysisServer saCommodityAnalysisServer;

  /**
   * @param eDate
   * @param lDate
   * @param saCommodityAnalysisServer
   */
  public GenerateAllSalesCommodityDetailAnalysis(final Date eDate, final Date lDate,
      final SaCommodityAnalysisServer saCommodityAnalysisServer) {
    super();
    this.eDate = eDate;
    this.lDate = lDate;
    this.saCommodityAnalysisServer = saCommodityAnalysisServer;
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
      saCommodityAnalysisServer.generateSalesCommodityDetailAnalysisForMonth(currentYear,
          currentMonth, null, null, null);
      if (currentMonth == 12) {// 如果是12月，则需要计算一次当年的统计数据
        saCommodityAnalysisServer
            .generateSalesCommodityDetailAnalysisForMonth(currentYear, 13, null, null, null);
      }
      eCalendar.add(Calendar.MONTH, 1);
    }
    logger.info("Generaet all salesManagerAnalysis success!!");
  }
}
