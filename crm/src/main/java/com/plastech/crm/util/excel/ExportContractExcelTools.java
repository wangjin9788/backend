package com.plastech.crm.util.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.google.common.base.Strings;
import com.plastech.crm.config.ConfigUtil;
import com.plastech.crm.model.vo.ContractExportView;

public class ExportContractExcelTools {

  public static String exportXml(final String fileName,
      final List<ContractExportView> list,final String xlsxName) throws Exception {
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

    final DataFormat format = wb.createDataFormat();
    final Sheet sheet = wb.getSheetAt(0); // 获得第一个表单（模板）

    // sheet.setForceFormulaRecalculation(true);
    int rowint = 1;// 第几行开始
    final CellStyle cellStyle = wb.createCellStyle();// 设置样式
    cellStyle.setDataFormat(format.getFormat("0.00"));
    cellStyle.setAlignment(CellStyle.ALIGN_LEFT); // 居左

    final CellStyle moneyStyle = wb.createCellStyle();// 设置金額样式
    moneyStyle.setDataFormat(format.getFormat("$#,##0.00"));
    moneyStyle.setAlignment(CellStyle.ALIGN_LEFT); // 居左

    final CellStyle timeStyle = wb.createCellStyle();// 设置时间样式
    timeStyle.setDataFormat(format.getFormat("mmm-yy"));
    timeStyle.setAlignment(CellStyle.ALIGN_LEFT); // 居左

    final Font font = wb.createFont();//设置字体
    font.setFontName("Times New Roman");
    cellStyle.setFont(font);
    moneyStyle.setFont(font);
    timeStyle.setFont(font);

    for (final ContractExportView sv : list) {
      final Row row = sheet.createRow(rowint); // 创建Excel中一行(从第几行开始)
      for (int tci = 0; tci < 22; tci++) {
        final Cell tc = row.createCell(tci); // 获取列第一个
        String keyvalue = "";
        Double value = 0D;
        switch (tci) {
          case 0:
            keyvalue = sv.getCuName();
            break;
          case 1:
            keyvalue = sv.getgName();
            break;
          case 2:
            keyvalue = sv.getCoNumber();
            break;
          case 3:
            keyvalue = sv.getGeNumber();
            break;
          case 4:
            keyvalue = sv.getCtName();
            break;
          case 5:
            keyvalue = sv.getMfName();
            break;
          case 6:
            value = sv.getSalesVolume();
            break;
          case 7:
            keyvalue = sv.getShipmtDate();
            break;
          case 8:
            value = sv.getSalesUnitPrice();
            break;
          case 9:
            value = sv.getSalesTotal();
            break;
          case 10:
            keyvalue = sv.getCgPaymentTerms();
            break;
          case 11:
            keyvalue = sv.getCpTransportationTerms();
            break;
          case 12:
            value = sv.getPurchasePrices();
            break;
          case 13:
            value = sv.getPurchaseCost();
            break;
          case 14:
            keyvalue = sv.getCpPaymentTerms();
            break;
          case 15:
            keyvalue = sv.getCpTransportationTerms();
            break;
          case 16:
            keyvalue = sv.getSuName();
            break;
          case 17:
            value = sv.getGrossProfit();
            break;
          case 18:
            value = sv.getLogistics();
            break;
          case 19:
            value = sv.getCpOtherCosts();
            break;
          case 20:
            value = sv.getNetProfit();
            break;
          case 21:
            keyvalue = sv.getUname();
            break;
          default:
            break;
        }
        tc.setCellStyle(cellStyle);
        if (!Strings.isNullOrEmpty(keyvalue)) {
          if(tci==7){
            tc.setCellStyle(timeStyle);
          }
          tc.setCellValue(keyvalue);// 设置列名
        }
        // 设置每个月的值
        if (value != null && value > 0) {
          tc.setCellValue(value);
          if (tci == 6) {
            tc.setCellStyle(cellStyle);
          } else {
            tc.setCellStyle(moneyStyle);
          }
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
