package com.plastech.crm.util.thread;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.plastech.crm.mapper.CustomerLoyaltyMapper;
import com.plastech.crm.mapper.LoyaltyMapper;
import com.plastech.crm.model.CustomerLoyalty;
import com.plastech.crm.model.vo.CustomerLoyaltyView;
import com.plastech.crm.model.vo.LoyaltyDurationView;
import com.plastech.crm.model.vo.LoyaltyView;
import com.plastech.crm.model.vo.UserPurchaseFrequencyView;

/**
 * @author wangJin
 *
 * @date 2019年1月23日 上午9:00:31
 *
 */
public class CustomerLoyaltyThread implements Runnable {
  private static final Logger logger =
      LoggerFactory.getLogger(CustomerLoyaltyThread.class);

  private final List<LoyaltyView> loyaltyInfoList;
  private final LoyaltyMapper loyaltyMapper;
  private final CustomerLoyaltyMapper customerLoyaltyMapper;
  private final Long uid;
  private final Long lid;
  private final LoyaltyDurationView durationView;


  /**
   * @param loyaltyInfoList
   * @param loyaltyMapper
   * @param customerLoyaltyMapper
   * @param uid
   * @param lid
   * @param durationView
   */
  public CustomerLoyaltyThread(final List<LoyaltyView> loyaltyInfoList,
      final LoyaltyMapper loyaltyMapper,
      final CustomerLoyaltyMapper customerLoyaltyMapper, final Long uid,
      final Long lid, final LoyaltyDurationView durationView) {
    super();
    this.loyaltyInfoList = loyaltyInfoList;
    this.loyaltyMapper = loyaltyMapper;
    this.customerLoyaltyMapper = customerLoyaltyMapper;
    this.uid = uid;
    this.lid = lid;
    this.durationView = durationView;
  }

  @Override
  public void run() {
    // 查询客户购买合同信息
    final List<CustomerLoyaltyView> frequencyList =
        loyaltyMapper.selectContractUserBuyingFrequency();
    final int year = getThreeYear();
    // 循环合同信息
    for (final CustomerLoyaltyView customerView : frequencyList) {
      // 获取用户的年月列表
      final List<UserPurchaseFrequencyView> frequencyInfo =
          customerView.getLoyaltyCount();
      analysisOfPurchaseFrequency(frequencyInfo, customerView.getGid(), year);
    }
    logger.info("init loyalty success");
  }

  // 购买频率匹配
  private void analysisOfPurchaseFrequency(
      final List<UserPurchaseFrequencyView> frequencyInfo, final Long gid,
      final Integer year) {
    try {
      Integer mark = 0;
      Integer count = 0;
      Integer duration = durationView.getMinDuration();
      int minMonth = 0;
      int uninterruptedYear = 0;
      final List<UserPurchaseFrequencyView> list = new ArrayList<>();
      for (final UserPurchaseFrequencyView fre : frequencyInfo) {
        // 判断是否连续购买
        if (uninterruptedYear == 0 || fre.getYears() == uninterruptedYear) {
          uninterruptedYear = fre.getYears() + 1;
          list.add(fre);
          if (list.size() > 3) {
            // 三年内的年份
            list.remove(0);
          }
          count++;
        }else{
          count=0;
          uninterruptedYear=0;
        }
        if (count >= durationView.getMaxDuration()) {
          duration = durationView.getMaxDuration();
        }
        CustomerLoyalty cust = new CustomerLoyalty();
        // 先删除信息
        customerLoyaltyMapper.deleteCustomerLoyalty(fre.getYears(),
            fre.getGid(), fre.getMfid());
        for (final LoyaltyView loyaltyView : loyaltyInfoList) {
          mark++;
          final Integer maxFrequency = loyaltyView.getMaxFrequency();
          final Integer minFrequency = loyaltyView.getMinFrequency();
          // 判断是否复合这个购买频率
          if (fre.getMonthCount().intValue() >= minFrequency
              && fre.getMonthCount().intValue() <= maxFrequency) {
            // 判断是否够三年
            if (count >= 3) {
              minMonth = statisticalYearPurchaseMonth(list);
              // 判断这三年中最小的购买如果最小的月份达不到当前最小的频率就改成一年
              if (minMonth < minFrequency) {
                duration = durationView.getMinDuration();
              }
            }
            if (loyaltyView.getDuration() == duration) {
              cust = new CustomerLoyalty();
              cust.setGid(fre.getGid());
              cust.setLid(loyaltyView.getLid());
              cust.setMfid(fre.getMfid());
              cust.setCreatorId(uid);
              cust.setYears(fre.getYears());
              customerLoyaltyMapper.insertSelective(cust);
              mark = 0;
              break;
            }
          } else if (loyaltyInfoList.size() == mark) {
            cust.setGid(gid);
            cust.setLid(lid);// 默认
            cust.setCreatorId(uid);
            cust.setMfid(fre.getMfid());
            cust.setYears(fre.getYears());
            customerLoyaltyMapper.insertSelective(cust);
            mark = 0;
          }
        }
      }
    } catch (final Exception e) {
      logger.info("customer Loyalty Exception:{}", e);
    }
  }


  private int statisticalYearPurchaseMonth(
      final List<UserPurchaseFrequencyView> frequencyInfo) {
    int minCount = 0;
    for (final UserPurchaseFrequencyView purch : frequencyInfo) {
      if (minCount == 0 || purch.getMonthCount() <= minCount) {
        minCount = purch.getMonthCount();
      }
    }
    return minCount;
  }


  private int getThreeYear() {
    final SimpleDateFormat format = new SimpleDateFormat("yyyy");
    final Calendar c = Calendar.getInstance();
    // 过去一年
    c.setTime(new Date());
    c.add(Calendar.YEAR, -3);
    final Date y = c.getTime();
    final String year = format.format(y);
    return Integer.parseInt(year);
  }


}
