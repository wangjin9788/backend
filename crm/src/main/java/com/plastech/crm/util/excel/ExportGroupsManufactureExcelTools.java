package com.plastech.crm.util.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.google.common.base.Strings;
import com.plastech.crm.config.ConfigUtil;
import com.plastech.crm.model.vo.ExportPropertyfeeInfoView;

public class ExportGroupsManufactureExcelTools {
  public static void mains(final String[] args) {
    try {
      final List<ExportPropertyfeeInfoView> spvList = new ArrayList<>();
      final ExportPropertyfeeInfoView v = new ExportPropertyfeeInfoView();
      v.setCtName("ABS");
      v.setMfName("FIPC");
      v.setCuName("Toray");
      v.setJanuaryMoney(123D);
      v.setFebruaryMoney(456D);

      spvList.add(v);
      // exportXml("E:/excel/2.xlsx", spvList, 5, "2019", "测试");
    } catch (final Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("-------------");
    // readXml("d:/test2.xls");
  }


  public static String exportXml(final String fileName,
      final List<ExportPropertyfeeInfoView> spvList, final Integer maxMonth,
      final String year, final String titleValue, final String mfName,
      final String xlsxName) throws Exception {
    boolean isE2007 = false; // 判断是否是excel2007格式
    if (fileName.endsWith("xlsx"))
      isE2007 = true;

    final InputStream input = new FileInputStream(fileName); // 建立输入流
    Workbook wb = null;
    // 根据文件格式(2003或者2007)来初始化
    if (isE2007)
      wb = new XSSFWorkbook(input);
    else
      wb = new HSSFWorkbook(input);

    wb.setSheetName(0, xlsxName);
    final Sheet sheet = wb.getSheetAt(0); // 获得第一个表单（模板）

    final CellStyle cellStyle = wb.createCellStyle();
    cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
    cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
    cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
    cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.000"));


    final Row oneRows = sheet.createRow(0);// 创建行
    final Cell oneCells = oneRows.createCell(0);// 创建列
    oneCells.setCellValue(titleValue);

    final Row twoRow = sheet.createRow(1);// 创建行
    final Cell twoCell = twoRow.createCell(0);// 创建列
    twoCell.setCellValue("生產商-" + mfName);

    final Row firstRow = sheet.createRow(2);// 创建行
    final Cell firstCell = firstRow.createCell(0);// 创建列
    firstCell.setCellValue(year + "年");

    // sheet.setForceFormulaRecalculation(true);
    int rowint = 3;// 第几行开始
    for (final ExportPropertyfeeInfoView sv : spvList) {
      final Row row = sheet.createRow(rowint); // 创建Excel中一行(从第几行开始)
      for (int tci = 0; tci < maxMonth; tci++) {
        final Cell tc = row.createCell(tci); // 获取列第一个
        String keyvalue = "";
        Double value = 0D;
        switch (tci) {
          case 0:
            keyvalue = sv.getCtName();
            break;
          case 1:
            keyvalue = sv.getMfName();
            break;
          case 2:
            value = sv.getJanuaryMoney();
            break;
          case 3:
            value = sv.getFebruaryMoney();
            break;
          case 4:
            value = sv.getMarchMoney();
            break;
          case 5:
            value = sv.getAprilMoney();
            break;
          case 6:
            value = sv.getMayMoney();
            break;
          case 7:
            value = sv.getJuneMoney();
            break;
          case 8:
            value = sv.getJulyMoney();
            break;
          case 9:
            value = sv.getAugustMoney();
            break;
          case 10:
            value = sv.getSeptemberMoney();
            break;
          case 11:
            value = sv.getOctoberMoney();
            break;
          case 12:
            value = sv.getNovemberMoney();
            break;
          case 13:
            value = sv.getDecemberMoney();
            break;
          case 14:
            value = sv.getColumnMoney();
            break;
          default:
            break;
        }

        // 动态生成月份
        if (tci >= 2 && sv.getCtName().equals("客户")) {
          if (tci == (maxMonth - 1)) {
            keyvalue = "总计";
          } else {
            keyvalue = (tci - 1) + "月";
          }
        }
        tc.setCellStyle(cellStyle);
        if (!Strings.isNullOrEmpty(keyvalue)) {
          tc.setCellValue(keyvalue);// 设置列名
        }
        // 设置每个月的值
        if (tci > 1 && rowint > 2 && !sv.getCtName().equals("客户")
            && value != null) {
          sheet.setColumnWidth(tci, 4000);
          tc.setCellStyle(cellStyle);
          tc.setCellValue(value != null ? value : 0);
        }
      }
      rowint++;
    }

    final String uuid = UUID.randomUUID().toString();
    final FileOutputStream revertFile = new FileOutputStream(
        ConfigUtil.getDownloadTempFolderPath() + "/" + uuid + ".xlsx");
    wb.write(revertFile);
    revertFile.flush();
    revertFile.close();
    wb.close();
    input.close();
    return ConfigUtil.getDownloadLocalhost()
        + "/export-management/download?uuid=" + uuid + "&fileName=" + xlsxName;

  }
}
