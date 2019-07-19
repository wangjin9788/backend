package com.plastech.crm.util.excel;

import java.util.ArrayList;
import java.util.List;
import com.google.common.base.Strings;
import com.plastech.crm.model.parameter.ExportDataInfoView;
import com.plastech.crm.model.vo.ExportPropertyfeeInfoView;

/**
 * @author wangJin
 *
 * @date 2019年3月7日 下午3:26:18
 *
 */
public class ExcelDataUtil {

  // 整理查询后的数据
  public static List<ExportPropertyfeeInfoView> completeExportedData(
      final List<ExportDataInfoView> exportList, final Integer mark,
      final Integer maxMonth) {
    // 已经获取到数据
    final List<ExportPropertyfeeInfoView> monthAnalysis = new ArrayList<>();
    // 动态生成名称
    ExportPropertyfeeInfoView insertTitle = new ExportPropertyfeeInfoView();
    if (mark == 1 || mark == 2) {
      insertTitle = insertTitle(exportList, 1);
    } else if (mark == 3) {
      insertTitle = insertTitle(exportList, 3);
    } else if (mark == 4) {
      insertTitle = insertTitle(exportList, 4);
    } else if (mark == 5) {
      insertTitle = insertTitle(exportList, 5);
    }
    monthAnalysis.add(insertTitle);

    // 新建list
    final List<ExportDataInfoView> identicals = new ArrayList<>();
    for (final ExportDataInfoView exportInfo : exportList) {
      if (identicals != null && !identicals.isEmpty()) {
        for (final ExportDataInfoView identicalsInfo : identicals) {
          if (exportInfo.getCtid().equals(identicalsInfo.getCtid())
              && exportInfo.getMfid().equals(identicalsInfo.getMfid())
              && exportInfo.getGid().equals(identicalsInfo.getGid())
              && mark <= 3) {
            identicals.add(exportInfo);
            break;
          } else if (mark == 4
              && exportInfo.getGid().equals(identicalsInfo.getGid())) {
            identicals.add(exportInfo);
            break;
          } else if (mark == 5
              && exportInfo.getGid().equals(identicalsInfo.getGid())) {
            identicals.add(exportInfo);
            break;
          } else {
            final ExportPropertyfeeInfoView proInfo =
                fillTheAnalysisDataIntoTheCorrespondingMonth(identicals,
                    maxMonth);
            monthAnalysis.add(proInfo);
            identicals.clear();
            identicals.add(exportInfo);
          }
        }
      } else {
        identicals.add(exportInfo);
      }
    }
    // 最后一个list
    if (identicals != null) {
      final ExportPropertyfeeInfoView proInfo =
          fillTheAnalysisDataIntoTheCorrespondingMonth(identicals, maxMonth);
      monthAnalysis.add(proInfo);
    }
    return monthAnalysis;
  }

  /**
   * 设置销售分析标题
   *
   * @param list
   * @param mark
   * @return
   */
  private static ExportPropertyfeeInfoView insertTitle(
      final List<ExportDataInfoView> list, final Integer mark) {
    final Integer length = getMaxMonth(list);
    final List<ExportDataInfoView> exportList = new ArrayList<>();
    final ExportDataInfoView export = new ExportDataInfoView();
    ExportPropertyfeeInfoView insertTitle = new ExportPropertyfeeInfoView();
    if (mark <= 2) {
      export.setCtName("品类");
      export.setMfName("生产商");
      export.setgName("客户");
      exportList.add(export);
    } else if (mark == 3) {
      export.setMfName("生产商");
      export.setCtName("品类");
      export.setgName("客户");
      exportList.add(export);
    } else if (mark == 4) {
      export.setMfName("客户");
      exportList.add(export);
    } else if (mark == 5) {
      export.setCtName("客户");
      export.setMfName("忠诚度");

      exportList.add(export);
    }
    export.setMonth(1);
    insertTitle =
        fillTheAnalysisDataIntoTheCorrespondingMonth(exportList, length);
    return insertTitle;
  }


  // 将相同数据合并成一条数据
  private static ExportPropertyfeeInfoView fillTheAnalysisDataIntoTheCorrespondingMonth(
      final List<ExportDataInfoView> exportList, final Integer maxMonth) {
    final ExportDataInfoView vi = new ExportDataInfoView();
    vi.setMonth(maxMonth + 1);
    vi.setVolume(0D);
    exportList.add(vi);
    Double number = 0D;
    final ExportPropertyfeeInfoView export = new ExportPropertyfeeInfoView();
    for (final ExportDataInfoView saMonthAnalysis : exportList) {
      // 获取标题
      if (Strings.isNullOrEmpty(export.getCtName())
          && Strings.isNullOrEmpty(export.getMfName())) {
        export.setCtName(saMonthAnalysis.getCtName());
        export.setMfName(saMonthAnalysis.getMfName());
        export.setCuName(saMonthAnalysis.getgName());
      }
      if (saMonthAnalysis.getVolume() != null) {
        number = number + saMonthAnalysis.getVolume();
        if (saMonthAnalysis.getMonth() == (maxMonth + 1)) {
          saMonthAnalysis.setVolume(number);
        }
      }
      switch (saMonthAnalysis.getMonth().intValue()) {
        case 1:
          export.setJanuaryMoney(saMonthAnalysis.getVolume());
          break;
        case 2:
          export.setFebruaryMoney(saMonthAnalysis.getVolume());
          break;
        case 3:
          export.setMarchMoney(saMonthAnalysis.getVolume());
          break;
        case 4:
          export.setAprilMoney(saMonthAnalysis.getVolume());
          break;
        case 5:
          export.setMayMoney(saMonthAnalysis.getVolume());
          break;
        case 6:
          export.setJuneMoney(saMonthAnalysis.getVolume());
          break;
        case 7:
          export.setJulyMoney(saMonthAnalysis.getVolume());
          break;
        case 8:
          export.setAugustMoney(saMonthAnalysis.getVolume());
          break;
        case 9:
          export.setSeptemberMoney(saMonthAnalysis.getVolume());
          break;
        case 10:
          export.setOctoberMoney(saMonthAnalysis.getVolume());
          break;
        case 11:
          export.setNovemberMoney(saMonthAnalysis.getVolume());
          break;
        case 12:
          export.setDecemberMoney(saMonthAnalysis.getVolume());
          break;
        case 13:
          export.setColumnMoney(saMonthAnalysis.getVolume());
          break;
      }

    }
    return export;
  }


  // 获取品类总计
  public static List<ExportPropertyfeeInfoView> getCommodityTotalData(
      final List<ExportPropertyfeeInfoView> proList, final Integer maxMonth) {
    final List<ExportPropertyfeeInfoView> totalList = new ArrayList<>();
    String ctName = null;
    Double januaryMoney = 0D;
    Double februaryMoney = 0D;
    Double marchMoney = 0D;
    Double aprilMoney = 0D;
    Double mayMoney = 0D;
    Double juneMoney = 0D;
    Double julyMoney = 0D;
    Double augustMoney = 0D;
    Double septemberMoney = 0D;
    Double octoberMoney = 0D;
    Double novemberMoney = 0D;
    Double decemberMoney = 0D;
    Integer mark = 0;
    for (final ExportPropertyfeeInfoView proInfoList : proList) {
      final ExportPropertyfeeInfoView exports = new ExportPropertyfeeInfoView();
      mark++;
      if (!Strings.isNullOrEmpty(proInfoList.getCtName())
          && proInfoList.getCtName().equals("品类")) {
        totalList.add(proInfoList);
        continue;
      }
      if(ctName != null && !proInfoList.getCtName().equals(ctName)){
        exports.setCtName(ctName+ "总计");
        exports.setJanuaryMoney(januaryMoney);
        exports.setFebruaryMoney(februaryMoney);
        exports.setMarchMoney(marchMoney);
        exports.setAprilMoney(aprilMoney);
        exports.setMayMoney(mayMoney);
        exports.setJuneMoney(juneMoney);
        exports.setJulyMoney(julyMoney);
        exports.setAugustMoney(augustMoney);
        exports.setSeptemberMoney(septemberMoney);
        exports.setOctoberMoney(octoberMoney);
        exports.setNovemberMoney(novemberMoney);
        exports.setDecemberMoney(decemberMoney);
        totalList.add(exports);
        ctName= proInfoList.getCtName();
        januaryMoney = 0D;
        februaryMoney = 0D;
        marchMoney = 0D;
        aprilMoney = 0D;
        mayMoney = 0D;
        juneMoney = 0D;
        julyMoney = 0D;
        augustMoney = 0D;
        septemberMoney = 0D;
        octoberMoney = 0D;
        novemberMoney = 0D;
        decemberMoney = 0D;
      }
     if(ctName == null || proInfoList.getCtName().equals(ctName)){
        ctName = proInfoList.getCtName();
        if (proInfoList.getJanuaryMoney() != null) {
          januaryMoney = januaryMoney + proInfoList.getJanuaryMoney();
        }
        if (proInfoList.getFebruaryMoney() != null) {
          februaryMoney = februaryMoney + proInfoList.getFebruaryMoney();
        }
        if (proInfoList.getMarchMoney() != null) {
          marchMoney = marchMoney + proInfoList.getMarchMoney();
        }
        if (proInfoList.getAprilMoney() != null) {
          aprilMoney = aprilMoney + proInfoList.getAprilMoney();
        }
        if (proInfoList.getMayMoney() != null) {
          mayMoney = mayMoney + proInfoList.getMayMoney();
        }
        if (proInfoList.getJuneMoney() != null) {
          juneMoney = juneMoney + proInfoList.getJuneMoney();
        }
        if (proInfoList.getJulyMoney() != null) {
          julyMoney = julyMoney + proInfoList.getJulyMoney();
        }
        if (proInfoList.getAugustMoney() != null) {
          augustMoney = augustMoney + proInfoList.getAugustMoney();
        }
        if (proInfoList.getSeptemberMoney() != null) {
          septemberMoney = septemberMoney + proInfoList.getSeptemberMoney();
        }
        if (proInfoList.getOctoberMoney() != null) {
          octoberMoney = octoberMoney + proInfoList.getOctoberMoney();
        }
        if (proInfoList.getNovemberMoney() != null) {
          novemberMoney = novemberMoney + proInfoList.getNovemberMoney();
        }
        if (proInfoList.getDecemberMoney() != null) {
          decemberMoney = decemberMoney + proInfoList.getDecemberMoney();
        }
      }
      if (proList.size() == mark) {
        final ExportPropertyfeeInfoView export = new ExportPropertyfeeInfoView();
        export.setCtName(ctName + "总计");
        export.setJanuaryMoney(januaryMoney);
        export.setFebruaryMoney(februaryMoney);
        export.setMarchMoney(marchMoney);
        export.setAprilMoney(aprilMoney);
        export.setMayMoney(mayMoney);
        export.setJuneMoney(juneMoney);
        export.setJulyMoney(julyMoney);
        export.setAugustMoney(augustMoney);
        export.setSeptemberMoney(septemberMoney);
        export.setOctoberMoney(octoberMoney);
        export.setNovemberMoney(novemberMoney);
        export.setDecemberMoney(decemberMoney);
        totalList.add(proInfoList);
        totalList.add(export);
        continue;
      }
      totalList.add(proInfoList);
    }
    return totalList;
  }


  // 总计
  public static ExportPropertyfeeInfoView totalQuantity(
      final List<ExportPropertyfeeInfoView> proList ,final Integer mark) {
    final ExportPropertyfeeInfoView exports = new ExportPropertyfeeInfoView();
    Double januaryMoney = 0D;
    Double februaryMoney = 0D;
    Double marchMoney = 0D;
    Double aprilMoney = 0D;
    Double mayMoney = 0D;
    Double juneMoney = 0D;
    Double julyMoney = 0D;
    Double augustMoney = 0D;
    Double septemberMoney = 0D;
    Double octoberMoney = 0D;
    Double novemberMoney = 0D;
    Double decemberMoney = 0D;
    Double columnMoney = 0D;
    for (final ExportPropertyfeeInfoView proInfoList : proList) {
      if (!Strings.isNullOrEmpty(proInfoList.getCtName())) {
        final int length = proInfoList.getCtName().length();
        if (proInfoList.getCtName().substring(length - 2).equals("总计")) {
          continue;
        }
      }
      if (proInfoList.getJanuaryMoney() != null) {
        januaryMoney = januaryMoney + proInfoList.getJanuaryMoney();
      }
      if (proInfoList.getFebruaryMoney() != null) {
        februaryMoney = februaryMoney + proInfoList.getFebruaryMoney();
      }
      if (proInfoList.getMarchMoney() != null) {
        marchMoney = marchMoney + proInfoList.getMarchMoney();
      }
      if (proInfoList.getAprilMoney() != null) {
        aprilMoney = aprilMoney + proInfoList.getAprilMoney();
      }
      if (proInfoList.getMayMoney() != null) {
        mayMoney = mayMoney + proInfoList.getMayMoney();
      }
      if (proInfoList.getJuneMoney() != null) {
        juneMoney = juneMoney + proInfoList.getJuneMoney();
      }
      if (proInfoList.getJulyMoney() != null) {
        julyMoney = julyMoney + proInfoList.getJulyMoney();
      }
      if (proInfoList.getAugustMoney() != null) {
        augustMoney = augustMoney + proInfoList.getAugustMoney();
      }
      if (proInfoList.getSeptemberMoney() != null) {
        septemberMoney = septemberMoney + proInfoList.getSeptemberMoney();
      }
      if (proInfoList.getOctoberMoney() != null) {
        octoberMoney = octoberMoney + proInfoList.getOctoberMoney();
      }
      if (proInfoList.getNovemberMoney() != null) {
        novemberMoney = novemberMoney + proInfoList.getNovemberMoney();
      }
      if (proInfoList.getDecemberMoney() != null) {
        decemberMoney = decemberMoney + proInfoList.getDecemberMoney();
      }
      if (proInfoList.getColumnMoney() != null) {
        columnMoney = columnMoney + proInfoList.getColumnMoney();
      }
    }

    if(mark==3){
      exports.setMfName("总计");
    }else{
      exports.setCtName("总计");
    }
    exports.setJanuaryMoney(januaryMoney);
    exports.setFebruaryMoney(februaryMoney);
    exports.setMarchMoney(marchMoney);
    exports.setAprilMoney(aprilMoney);
    exports.setMayMoney(mayMoney);
    exports.setJuneMoney(juneMoney);
    exports.setJulyMoney(julyMoney);
    exports.setAugustMoney(augustMoney);
    exports.setSeptemberMoney(septemberMoney);
    exports.setOctoberMoney(octoberMoney);
    exports.setNovemberMoney(novemberMoney);
    exports.setDecemberMoney(decemberMoney);
    exports.setColumnMoney(columnMoney);

    return exports;
  }



  public static Integer getMaxMonth(final List<ExportDataInfoView> list) {
    Integer maxMonth = 0;
    for (final ExportDataInfoView exportInfo : list) {
      if (exportInfo.getMonth().intValue() > maxMonth) {
        maxMonth = exportInfo.getMonth();
      }
    }
    return maxMonth;
  }
}
