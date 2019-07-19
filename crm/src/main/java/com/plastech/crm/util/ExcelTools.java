package com.plastech.crm.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelTools {

  protected static final Logger logger =
      LoggerFactory.getLogger(ExcelTools.class);

  public static List<String[]> readExcelByPoi(final String filePath,
      final int sheetNumber, final int columnSize) throws Exception {
    Workbook wb = null;
    InputStream input = null;
    final List<String[]> resultList = new ArrayList<String[]>();
    try {
      input = new FileInputStream(filePath); // 建立输入流
      // 根据文件格式(2003或者2007)来初始化
      if (filePath.endsWith("xlsx")) {
        wb = new XSSFWorkbook(input);// 2007
      } else {
        wb = new HSSFWorkbook(input);
      }
      final Sheet sheet = wb.getSheetAt(sheetNumber); // 获得第一个表单
      final Iterator<Row> rows = sheet.rowIterator(); // 获得第一个表单的迭代器
      while (rows.hasNext()) {
        final Row row = rows.next(); // 获得行数据
        if (row.getRowNum() == 0) {
          final String cell0 = row.getCell(0).getStringCellValue();
          final String cell1 = row.getCell(1).getStringCellValue();
          if (!"客戶".equals(cell0.trim()) || !"End-user".equals(cell1.trim())) {
            logger.error("Excel header does not match");
            break;
          }
          continue;// 不读第一行（行号为0）
        }

        final String[] s = new String[columnSize];// 存放一行数据
        for (int celli = 0; celli < columnSize; celli++) {// 一列列取
          final Cell cell = row.getCell(celli);
          if (cell == null) {
            s[celli] = null;
            continue;
          }
          if (cell.getColumnIndex() == columnSize) {
            break;
          }

          switch (cell.getCellType()) { // 根据cell中的类型来输出数据
            case Cell.CELL_TYPE_NUMERIC: // 数字
              // case HSSFCell.CELL_TYPE_NUMERIC:
              if (HSSFDateUtil.isCellDateFormatted(cell)) {
                try {
                  final SimpleDateFormat sdf =
                      new SimpleDateFormat("yyyy-MM-dd");
                  final Date date =
                      HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                  s[celli] = sdf.format(date).toString();
                } catch (final Exception e) {
                  logger.error("Date format error:[" + row.getRowNum() + "]["
                      + celli + "]");
                  s[celli] = "";
                }
              } else {
                try {
                  final double d = cell.getNumericCellValue();
                  s[celli] = new DecimalFormat("#.###").format(d);
                } catch (final Exception e) {
                  logger.error("Decimal format error:[" + row.getRowNum() + "]["
                      + celli + "]");
                  s[celli] = "";
                }
              }
              break;
            case Cell.CELL_TYPE_STRING: // 字符串
              s[celli] = String.valueOf(cell.getStringCellValue());
              break;
            case Cell.CELL_TYPE_BOOLEAN: // Boolean
              s[celli] = String.valueOf(cell.getBooleanCellValue());
              break;
            case Cell.CELL_TYPE_FORMULA: // 公式
              s[celli] = String.valueOf(cell.getNumericCellValue());
              break;
            case Cell.CELL_TYPE_BLANK: // 空值
              s[celli] = "";
              break;
            case Cell.CELL_TYPE_ERROR: // 故障
              s[celli] = "非法字符";
              break;
            default:
              s[celli] = "未知类型";
              break;
          }
        }
        if (s[0] == null) {
          break;
        }
        resultList.add(s);
      }
      return resultList;
    } catch (final Exception e) {
      logger.error("Excel read error,{}", e);
    } finally {
      if (wb != null) {
        wb.close();
      }
      if (input != null) {
        input.close();
      }
    }
    return Collections.emptyList();
  }
}
