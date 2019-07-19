package com.plastech.crm.util.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.plastech.crm.config.ConfigUtil;
import com.plastech.crm.model.vo.ExportSupplierAndGroupsView;

public class ExportSupplierAndCustomerExcelTools {


  public static String exportXml(final String fileName,
      final List<ExportSupplierAndGroupsView> list,final String xlsxName) throws Exception {
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

    final Sheet sheet = wb.getSheetAt(0); // 获得第一个表单（模板）

    final CellStyle cellStyle = wb.createCellStyle();
    final Font font = wb.createFont();//设置字体
    font.setFontName("Times New Roman");
    cellStyle.setFont(font);
    // sheet.setForceFormulaRecalculation(true);
    int rowint = 1;// 第几行开始
    for (final ExportSupplierAndGroupsView sv : list) {
      final Row row = sheet.createRow(rowint); // 创建Excel中一行(从第几行开始)
      for (int tci = 0; tci < 9; tci++) {
        final Cell tc = row.createCell(tci); // 获取列第一个
        String keyvalue = "";
        switch (tci) {
          case 0:
            keyvalue = sv.getName();
            break;
          case 1:
            keyvalue = sv.getFullName();
            break;
          case 2:
            keyvalue = sv.getAddress();
            break;
          case 3:
            keyvalue = sv.getlName();
            break;
          case 4:
            keyvalue = sv.getPosition();
            break;
          case 5:
            keyvalue = sv.getPhone();
            break;
          case 6:
            keyvalue = sv.getMail();
            break;
          case 7:
            keyvalue = sv.getTags();
            break;
          case 8:
            keyvalue = sv.getNote();
            break;
          default:
            break;
        }
        tc.setCellStyle(cellStyle);
        tc.setCellValue(keyvalue);// 设置列名
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
