package com.plastech.crm.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.plastech.crm.model.SaCustomerDetailAnalysis;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;
import com.plastech.crm.service.SaCustomerDetailAnalysisService;
import com.plastech.crm.util.CommonTools;
import com.plastech.crm.util.SaDataAnalysisUtil;

/**
 * @author wangJin
 *
 * @date 2019年3月27日 上午10:18:55
 *
 */
@Service
public class SaCustomerDetailAnalysisServiceImpl extends BaseService
    implements SaCustomerDetailAnalysisService {

  @Override
  public SalesAnalysisView getCustomerStatistics(final Map<String, Object> map,
      final Integer year) {
    final SalesAnalysisView total =
        saCustomerDetailAnalysisMapper.getCustomerStatisticsTotal(map);
    if (total != null) {
      final List<SalesAnalysisDataView> sadList =
          saCustomerDetailAnalysisMapper.getCustomerStatisticsMonth(map);
      map.remove("year");
      map.put("year", year - 1);
      final List<SalesAnalysisDataView> lastList =
          saCustomerDetailAnalysisMapper.getCustomerStatisticsMonth(map);
      final List<SalesAnalysisDataView> list = SaDataAnalysisUtil
          .completeDetailedMonthlyData(sadList, lastList, year);
      total.setDataList(list);
    }
    return total;
  }


  @Override
  public Boolean generateSaCustomerDetailForMonth(final int year,
      final int month, final Long ctid, final Long mfid, final Long gid,
      final Long cuid) {
    try {
      if (year < 1970 || year > 2100 || month < 1 || month > 13) {
        logger.info("param error , year=" + year + ",month=" + month);
        return false;
      }
      final String yearStr = year + "";
      final List<SaCustomerDetailAnalysis> salseInfo;
      if (month == 13) {// 一整年的销售经理销售统计数据
        salseInfo = saCustomerDetailAnalysisMapper
            .getSaCustomerInfoByYear(year + "", ctid, mfid, gid, cuid);
      } else {// 单个月的销售经理销售统计数据
        salseInfo = saCustomerDetailAnalysisMapper.getSaCustomerInfoByMonth(
            yearStr, month + "", ctid, mfid, gid, cuid);
      }
      if (salseInfo != null && !salseInfo.isEmpty()) {
        for (final SaCustomerDetailAnalysis smsInfo : salseInfo) {
          SaCustomerDetailAnalysis scd =
              saCustomerDetailAnalysisMapper.getSacustomerInfoById(
                  smsInfo.getGid(), smsInfo.getCuid(), smsInfo.getCtid(),
                  smsInfo.getMfid(), yearStr, smsInfo.getMonth());
          if (scd == null) {
            scd = new SaCustomerDetailAnalysis();
            scd.setGid(smsInfo.getGid());
            scd.setCuid(smsInfo.getCuid());
            scd.setCuName(smsInfo.getCuName());
            scd.setCtid(smsInfo.getCtid());
            scd.setMfid(smsInfo.getMfid());
            scd.setYear(yearStr);
            scd.setPurchaseTotal(smsInfo.getPurchaseTotal());
            scd.setMonth(smsInfo.getMonth());
            scd.setCreateTime(new Date());
            saCustomerDetailAnalysisMapper.insertSelective(scd);
          } else {
            scd.setPurchaseTotal(smsInfo.getPurchaseTotal());
            scd.setLastUpdateTime(new Date());
            saCustomerDetailAnalysisMapper.updateByPrimaryKey(scd);
          }
        }
        logger.info("生成" + year + "-" + month + "客戶分析-品類購買情況-详情，并写入DB。");
      }else if(ctid!=null&&mfid!=null&&gid!=null&&cuid!=null){
        saCustomerDetailAnalysisMapper.deleteSaCustomerDetailByYearAndMonth(year, month,ctid,mfid,gid,cuid);
      }
      return true;
    } catch (final Exception e) {
      logger.error("Generate salesAnalysis error , {}", e);
    }
    return false;
  }
  @Override
  public Boolean initCustomerDetail() {

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
      generateSaCustomerDetailForMonth(currentYear, currentMonth, null, null,
          null, null);
      if (currentMonth == 12) {// 如果是12月，则需要计算一次当年的统计数据
        generateSaCustomerDetailForMonth(currentYear, 13, null, null, null,
            null);
      }
      eCalendar.add(Calendar.MONTH, 1);
    }
    generateSaCustomerDetailForMonth(currentYear, 13, null, null, null, null);
    logger.info("Generaet all init Customer Detail success!!");
    return true;
  }

}
