package com.plastech.crm.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.google.common.base.Strings;
import com.plastech.crm.model.parameter.SaCommodityParameters;
import com.plastech.crm.model.vo.SalesAnalysisDataView;

/**
 * @author wangJin
 *
 * @date 2019年2月26日 下午2:40:42
 *
 */
public class SaDataAnalysisUtil {



  public static List<SaCommodityParameters> analysisData(

      final List<SaCommodityParameters> analysisList, final Integer mark) {
    final List<List<SaCommodityParameters>> monthAnalysis = new ArrayList<>();
    // 新建list
    final List<SaCommodityParameters> identicals = new ArrayList<>();
    for (final SaCommodityParameters analysisDataList : analysisList) {
      if (identicals != null && !identicals.isEmpty()) {
        for (final SaCommodityParameters identicalList : identicals) {
          final Boolean isInsert =
              getTheSameStatistics(mark, analysisDataList, identicalList);
          if (isInsert) {
            final List<SaCommodityParameters> list =
                completeStatisticalData(identicals);
            monthAnalysis.add(list);
            identicals.clear();
          }
          identicals.add(analysisDataList);
          break;
        }
      } else {
        identicals.add(analysisDataList);
      }
    }
    // 将最后一个元素添加
    if (identicals != null && !identicals.isEmpty()) {
      // 把补全的数据添加到
      final List<SaCommodityParameters> endlist =
          completeStatisticalData(identicals);
      monthAnalysis.add(endlist);
    }

    final List<SaCommodityParameters> ana = new ArrayList<>();
    for (final List<SaCommodityParameters> list : monthAnalysis) {
      for (final SaCommodityParameters saCommodityAnalysis : list) {
        ana.add(saCommodityAnalysis);
      }
    }
    monthAnalysis.clear();
    return ana;
  }

  private static Boolean getTheSameStatistics(final Integer mark,
      final SaCommodityParameters analysisDataList,
      final SaCommodityParameters identicalList) {
    if (analysisDataList.getMfid() == identicalList.getMfid()
        && analysisDataList.getYear().equals(identicalList.getYear())) {
      if (mark == 1 && analysisDataList.getCtid() == identicalList.getCtid()) {
        if (!Strings.isNullOrEmpty(analysisDataList.getName())
            && !analysisDataList.getName().equals(identicalList.getName())) {
          return true;
        }
        return false;
      } else if (mark == 2) {
        if (analysisDataList.getGid() != null
            && analysisDataList.getGid() != identicalList.getGid()) {
          return true;
        }
        return false;
      }
    }
    return true;
  }

  private static List<SaCommodityParameters> completeStatisticalData(
      final List<SaCommodityParameters> identical) {
    final List<SaCommodityParameters> insertMonth =
        fillTheAnalysisDataIntoTheCorrespondingMonth(identical);
    return insertMonth;
  }

  private static List<SaCommodityParameters> fillTheAnalysisDataIntoTheCorrespondingMonth(
      final List<SaCommodityParameters> commodityMonth) {
    List<SaCommodityParameters> monthList = new ArrayList<>();
    for (final SaCommodityParameters saMonthAnalysis : commodityMonth) {
      if (monthList == null || monthList.isEmpty()) {
        // 补全数据
        monthList = monthList(saMonthAnalysis.getYear(),
            saMonthAnalysis.getCtid(), saMonthAnalysis.getMfid(),
            saMonthAnalysis.getGid(), saMonthAnalysis.getCtName(),
            saMonthAnalysis.getMfName(), saMonthAnalysis.getName());
      }
      for (final SaCommodityParameters monthAnalysis : monthList) {
        if (saMonthAnalysis.getMonth() == monthAnalysis.getMonth()) {
          monthList.set(monthAnalysis.getMonth() - 1, saMonthAnalysis);
          break;
        }
      }
    }
    return monthList;
  }

  private static List<SaCommodityParameters> monthList(final String year,
      final Long ctid, final Long mfid, final Long gid, final String ctName,
      final String mfName, final String name) {
    // 创建某年中的12个月
    final List<SaCommodityParameters> monthList = new ArrayList<>();
    for (int i = 1; i <= 13; i++) {
      final SaCommodityParameters saAnalysis = new SaCommodityParameters();
      saAnalysis.setCtid(ctid != null ? ctid : 0L);
      saAnalysis.setCtName(ctName);
      saAnalysis.setName(name);
      saAnalysis.setCustomersCount(0L);
      saAnalysis.setMfid(mfid.longValue());
      saAnalysis.setMfName(mfName);
      saAnalysis.setQuantity(0D);
      saAnalysis.setYear(year);
      saAnalysis.setMonth(i);
      saAnalysis.setCreateTime(new Date());
      saAnalysis.setCommodityCount(0);
      saAnalysis.setGid(gid != null ? gid : 0L);
      monthList.add(saAnalysis);
    }
    return monthList;
  }

  // 补全详情十二个月数据
  public static List<SalesAnalysisDataView> completeDetailedMonthlyData(
      final List<SalesAnalysisDataView> detailList,
      final List<SalesAnalysisDataView> lastList, final Integer year) {
    List<SalesAnalysisDataView> list = new ArrayList<>();
    if (list == null || list.isEmpty()) {
      list = salseDetailMonthList(year);
    }
    for (final SalesAnalysisDataView viewInfo : detailList) {

      for (final SalesAnalysisDataView dataInfo : list) {
        if (dataInfo.getMonth().equals(viewInfo.getMonth())) {
          viewInfo.setPreviousYearMonth(dataInfo.getPreviousYearMonth());
          viewInfo.setSalesTotal(
              dataInfo.getSalesTotal() + viewInfo.getSalesTotal());
          list.set(Integer.valueOf(dataInfo.getMonth()) - 1, viewInfo);
          break;
        }
      }
    }
    for (final SalesAnalysisDataView lastInfo : lastList) {
      for (final SalesAnalysisDataView salesAnalysisDataView : list) {
        if (lastInfo.getMonth().equals(salesAnalysisDataView.getMonth())) {
          salesAnalysisDataView.setPreviousSalesTotal(
              salesAnalysisDataView.getPreviousSalesTotal() + lastInfo.getSalesTotal());
          salesAnalysisDataView
              .setPreviousGroupCount(lastInfo.getPreviousGroupCount());
          salesAnalysisDataView
              .setPreviousCommodityCount(lastInfo.getPreviousCommodityCount());
          break;
        }
      }
    }
    return list;
  }


  private static List<SalesAnalysisDataView> salseDetailMonthList(
      final Integer year) {
    final List<SalesAnalysisDataView> list = new ArrayList<>();
    for (int i = 1; i < 13; i++) {
      final SalesAnalysisDataView param = new SalesAnalysisDataView();
      param.setMonth("0" + i + "");
      param.setYearMonth(year + "-" + i);
      param.setPreviousYearMonth(String.valueOf(year - 1 + "-" + i));
      list.add(param);
    }
    return list;
  }


}
