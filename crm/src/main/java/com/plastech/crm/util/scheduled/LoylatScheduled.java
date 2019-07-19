package com.plastech.crm.util.scheduled;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import com.plastech.crm.service.LoyaltyService;
import com.plastech.crm.util.CommonTools;
import net.javacrumbs.shedlock.core.SchedulerLock;

/**
 * @author wangJin
 *
 * @date 2019年3月19日 上午10:23:39
 *
 */
@Configuration
public class LoylatScheduled {
  Logger logger = LoggerFactory.getLogger(LoylatScheduled.class);
  @Autowired
  protected LoyaltyService loyaltyService;

  private static final int ONE_YEAR = 365*24*60*60 * 1000;

  @Scheduled(cron = "0 0 3 1 1 ?")
  @SchedulerLock(name = "loyaltyScheduled", lockAtMostFor = ONE_YEAR,
      lockAtLeastFor = ONE_YEAR)
  public void insertCommodityAnalysis() {
    try {
      final Boolean loylaty = loyaltyService.loyaltyTakesEffect(0L);
      if (loylaty) {
        logger.info("insert SaCommodity loylaty : SUCCESS:{}",
            CommonTools.parseDateToString(new Date(),
                CommonTools.DATEFORMAT_Y4_MM_DD_HMS));
      } else {
        logger.info("insert SaCommodity loylaty : FAIL:{}",
            CommonTools.parseDateToString(new Date(),
                CommonTools.DATEFORMAT_Y4_MM_DD_HMS));
      }
    } catch (final Exception e) {
      logger.info("insert  Commodity loylaty Exception", e);
    }
  }
}
