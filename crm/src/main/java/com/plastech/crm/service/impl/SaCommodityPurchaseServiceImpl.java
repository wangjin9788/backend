package com.plastech.crm.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.plastech.crm.model.SaCommodityPurchase;
import com.plastech.crm.model.vo.SaCommodityAnalysisView;
import com.plastech.crm.model.vo.SaCommodityPurchaseDetail;
import com.plastech.crm.model.vo.SaManufacturerTotalDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;
import com.plastech.crm.service.SaCommodityPurchaseService;
import com.plastech.crm.util.CommonTools;

/**
 * @author wangJin
 *
 * @date 2019年3月26日 下午4:52:09
 *
 */
@Service
public class SaCommodityPurchaseServiceImpl extends BaseService
    implements SaCommodityPurchaseService {

  @Override
  public SalesAnalysisView getSaCommodityPurchaseStatistics(
      final Map<String, Object> map, final Integer year) {
    final SalesAnalysisView purchaseTotal =
        saCommodityPurchaseMapper.getSaCommodityPurchaseTotal(map);
    if (purchaseTotal == null) {
      selectSaCommodityPurchaseByYear(year);
    } else {
      final List<SaCommodityAnalysisView> info =
          saCommodityPurchaseMapper.getSaCommodityPurchaseTotalById(map);
      purchaseTotal.setCommList(info);
    }
    return purchaseTotal;
  }

  @Override
  public Boolean selectSaCommodityPurchaseByYear(final int year) {
    final Calendar cal = Calendar.getInstance();
    final int currentYear = cal.get(Calendar.YEAR);
    if (year > currentYear) {
      return false;
    }
    final SaCommodityPurchase scp = saCommodityPurchaseMapper.getTableData();
    if (scp == null) {
      initSaCommodityPurchaseAnalysis();
    }
    generateSaCommodityPurchaseForMonth(currentYear, 13, null, null, null);
    generateSaCommodityPurchaseForMonth(currentYear - 1, 13, null, null, null);

    return true;
  }

  @Override
  public Boolean initSaCommodityPurchaseAnalysis() {
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
    initCommodityPurchase(eDate, lDate);
    return true;
  }

  @Override
  public Boolean generateSaCommodityPurchaseForMonth(final int year,
      final int month, final Long ctid, final Long mfid, final Long gid) {
    try {
      if (year < 1970 || year > 2100 || month < 1 || month > 13) {
        logger.info("param error , year=" + year + ",month=" + month);
        return false;
      }
      final String yearStr = year + "";
      final List<SaCommodityPurchase> salseInfo;
      if (month == 13) {// 一整年的销售经理销售统计数据
        salseInfo = saCommodityPurchaseMapper
            .getSaCommodityPurchaseStatisticsInfoByYear(year + "", ctid, mfid,
                gid);
      } else {// 单个月的销售经理销售统计数据
        salseInfo = saCommodityPurchaseMapper
            .getSaCommodityPurchaseStatisticsInfoByMonth(yearStr, month + "",
                ctid, mfid, gid);
      }
      if (salseInfo != null && !salseInfo.isEmpty()) {
        for (final SaCommodityPurchase smsInfo : salseInfo) {
          SaCommodityPurchase scp = saCommodityPurchaseMapper
              .getSacommodityPurchaseInfoById(yearStr, smsInfo.getMonth(),
                  smsInfo.getGid(), smsInfo.getCtid(), smsInfo.getMfid());
          if (scp == null) {
            scp = new SaCommodityPurchase();
            scp.setGid(smsInfo.getGid());
            scp.setCtid(smsInfo.getCtid());
            scp.setCtName(smsInfo.getCtName());
            scp.setMfid(smsInfo.getMfid());
            scp.setMfName(smsInfo.getMfName());
            scp.setYear(yearStr);
            scp.setPurchaseTotal(smsInfo.getPurchaseTotal());
            scp.setMonth(smsInfo.getMonth());
            scp.setCreateTime(new Date());
            saCommodityPurchaseMapper.insertSelective(scp);
          } else {
            scp.setPurchaseTotal(smsInfo.getPurchaseTotal());
            scp.setLastUpdateTime(new Date());
            saCommodityPurchaseMapper.updateByPrimaryKey(scp);
          }
        }
        logger.info("生成" + year + "-" + month + "客戶分析-品類購買情況，并写入DB。");
      } else if (ctid != null && mfid != null && gid != null) {
        saCommodityPurchaseMapper
            .deleteSaCommodityPurchaseDetailByYearAndMonth(year, month,ctid,mfid,gid);
      }
      return true;
    } catch (final Exception e) {
      logger.error("Generate salesAnalysis error , {}", e);
    }
    return false;
  }

  @Override
  public SaManufacturerTotalDataView getSaCommodityPurchaseDetailTotal(
      final Map<String, Object> map) {
    return saCommodityPurchaseMapper.getSaCommodityPurchaseDetailTotal(map);
  }

  @Override
  public List<SaCommodityPurchaseDetail> searchCommodityPurchaseDetailCustomer(
      final Map<String, Object> map) {
    try {
      return saCommodityPurchaseMapper
          .searchCommodityPurchaseDetailCustomer(map);
    } catch (final Exception e) {
      logger.info("searchCommodityPurchaseDetailCustomer exception{}", e);
    }
    return null;
  }

  public void initCommodityPurchase(final Date eDate, final Date lDate) {
    final Calendar eCalendar = Calendar.getInstance();
    eCalendar.setTime(eDate);
    final Calendar lCalendar = Calendar.getInstance();
    lCalendar.setTime(lDate);
    int currentYear = 0;
    int currentMonth = 0;
    while (eCalendar.compareTo(lCalendar) <= 0) {
      currentYear = eCalendar.get(Calendar.YEAR);// 当前年
      currentMonth = eCalendar.get(Calendar.MONTH) + 1;// 当前月
      generateSaCommodityPurchaseForMonth(currentYear, currentMonth, null, null,
          null);
      if (currentMonth == 12) {// 如果是12月，则需要计算一次当年的统计数据
        generateSaCommodityPurchaseForMonth(currentYear, 13, null, null, null);
      }
      eCalendar.add(Calendar.MONTH, 1);
    }
    generateSaCommodityPurchaseForMonth(currentYear, 13, null, null, null);
    logger.info("Generaet all init Commodity Purchase success!!");
  }

}
