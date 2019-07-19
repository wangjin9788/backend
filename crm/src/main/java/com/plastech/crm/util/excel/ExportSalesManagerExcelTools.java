package com.plastech.crm.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import com.plastech.crm.mapper.CommodityMapper;
import com.plastech.crm.model.parameter.ExportDataInfoView;
import com.plastech.crm.model.vo.ExportPropertyfeeInfoView;

public class ExportSalesManagerExcelTools {



  public static String exportXml(final String fileName, final String year,
      final CommodityMapper commodityMapper,
      final List<Map<String, Object>> userList,final String xlsxName) throws Exception {
    boolean isE2007 = false; // 判断是否是excel2007格式
    if (fileName.endsWith("xlsx"))
      isE2007 = true;
    final InputStream input = new FileInputStream(fileName); // 建立输入流
    Workbook wb = null;
    // 根据文件格式(2003或者2007)来初始化
    if (isE2007) {
      wb = new XSSFWorkbook(input);
    } else {
      wb = new HSSFWorkbook(input);
    }
    final String uuid = UUID.randomUUID().toString();
    final FileOutputStream revertFile = new FileOutputStream(
        ConfigUtil.getDownloadTempFolderPath() + "/" + uuid + ".xlsx");
    List<ExportDataInfoView> exportInfoList = new ArrayList<>();
    for (int i = 0; i < userList.size(); i++) {
      final String name = (String) userList.get(i).get("uname");
      if (i >= 1) {
        wb.createSheet(name);
      }else{
        wb.setSheetName(0, name);
      }
      exportInfoList = commodityMapper.getExportSalesManagerInfoList(
          (Integer) userList.get(i).get("uid"), year);
      if (exportInfoList != null && !exportInfoList.isEmpty()) {
        // 获取最大月份
        final Integer maxMonth = ExcelDataUtil.getMaxMonth(exportInfoList);
        // 调整数据将相同的数据合并成一条
        final List<ExportPropertyfeeInfoView> salesManagerList =
            ExcelDataUtil.completeExportedData(exportInfoList, 2, maxMonth);
        // 某个品类总计
        final List<ExportPropertyfeeInfoView> totalDataList =
            ExcelDataUtil.getCommodityTotalData(salesManagerList, maxMonth);
        // 获取总计
        final ExportPropertyfeeInfoView totalQuantity =
            ExcelDataUtil.totalQuantity(totalDataList,2);
        totalDataList.add(totalQuantity);
        // 4.保存待导入的文件
        filePath();

        final Sheet sheet = wb.getSheetAt(i); // 获得第一个表单（模板）
        final CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.000"));


        final Row firstRows = sheet.createRow(0);// 创建行
        final Cell firstCells = firstRows.createCell(0);// 创建列
        final String title = "销售经理分析-" + (String) userList.get(i).get("uname");
        firstCells.setCellValue(title);

        final Row firstRow = sheet.createRow(1);// 创建行
        final Cell firstCell = firstRow.createCell(0);// 创建列
        firstCell.setCellValue(year + "年");

        // sheet.setForceFormulaRecalculation(true);
        int rowint = 2;// 第几行开始
        for (final ExportPropertyfeeInfoView sv : totalDataList) {
          final Row row = sheet.createRow(rowint); // 创建Excel中一行(从第几行开始)
          for (int tci = 0; tci < maxMonth + 4; tci++) {
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
                keyvalue = sv.getCuName();
                break;
              case 3:
                value = sv.getJanuaryMoney();
                break;
              case 4:
                value = sv.getFebruaryMoney();
                break;
              case 5:
                value = sv.getMarchMoney();
                break;
              case 6:
                value = sv.getAprilMoney();
                break;
              case 7:
                value = sv.getMayMoney();
                break;
              case 8:
                value = sv.getJuneMoney();
                break;
              case 9:
                value = sv.getJulyMoney();
                break;
              case 10:
                value = sv.getAugustMoney();
                break;
              case 11:
                value = sv.getSeptemberMoney();
                break;
              case 12:
                value = sv.getOctoberMoney();
                break;
              case 13:
                value = sv.getNovemberMoney();
                break;
              case 14:
                value = sv.getDecemberMoney();
                break;
              case 15:
                value = sv.getColumnMoney();
                break;
              default:
                break;
            }

            // 动态生成月份
            if (tci >= 3 && sv.getCtName().equals("品类")) {
              if (tci == (maxMonth + 3)) {
                tc.setCellValue("总计");
              } else {
                keyvalue = (tci - 2) + "月";
              }
            }
            tc.setCellStyle(cellStyle);
            if (!Strings.isNullOrEmpty(keyvalue)) {
              tc.setCellValue(keyvalue);// 设置列名
            }
            // 设置每个月的值
            if (tci > 2 && rowint > 2 && !sv.getCtName().equals("品类")
                && value != null) {
              sheet.setColumnWidth(tci, 4000);
              tc.setCellStyle(cellStyle);
              tc.setCellValue(value != null ? value : 0);
            }
          }
          rowint++;
        }
      }
    }
    wb.write(revertFile);
    revertFile.flush();
    revertFile.close();
    wb.close();
    input.close();
    return ConfigUtil.getDownloadLocalhost()
        + "/export-management/download?uuid=" + uuid + "&fileName=" + xlsxName;

  }

  private static void filePath() {
    final String folderPath = ConfigUtil.getExportTempFolderPath();
    final File folder = new File(folderPath);
    if (!folder.exists()) {
      folder.mkdirs();
    }
    final String downloadPath = ConfigUtil.getDownloadTempFolderPath();
    final File downloadFolder = new File(downloadPath);
    if (!downloadFolder.exists()) {
      downloadFolder.mkdirs();
    }
  }
}
