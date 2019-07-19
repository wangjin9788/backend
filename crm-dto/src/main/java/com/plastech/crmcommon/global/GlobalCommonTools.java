package com.plastech.crmcommon.global;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.base.Strings;

/**
 *
 * global common Util
 *
 * @author yemin
 *
 */
public final class GlobalCommonTools {

  private GlobalCommonTools() {}

  private static Logger logger =
      LoggerFactory.getLogger(GlobalCommonTools.class);

  public static final String DATEFORMAT_Y4_MM = "yyyy-MM";
  public static final String DATEFORMAT_Y4_MM_DD = "yyyy-MM-dd";
  public static final String DATEFORMAT_Y4MM_DD = "yyyy年MM月dd日";
  public static final String DATEFORMAT_Y2_MM_DD = "yy-MM-dd";
  public static final String DATEFORMAT_Y4_MM_DD_HMS = "yyyy-MM-dd HH:mm:ss";
  public static final String DATEFORMAT_Y4_MM_DD_HM = "yyyy-MM-dd HH:mm";
  public static final String DATEFORMAT_HMS = "HH:mm:ss";
  public static final String DATEFORMAT_HM = "HH:mm";
  public static final String DATEFORMAT_Y4MMDD = "yyyyMMdd";
  public static final String DATEFORMAT_Y4MMDDHMS = "yyyyMMddHHmmss";
  public static final String DATEFORMAT_DDMMY4 = "dd/MM/yyyy";

  /**
   * yyyyMMddHHmm格式的时间字符串，转成Date
   *
   * @param dateStr
   * @return
   */
  public static Date parseStringToDate(final String dateStr,
      final String format) {
    SimpleDateFormat sdfOrd = new SimpleDateFormat(DATEFORMAT_Y4_MM_DD_HMS);
    Date date = null;
    try {
      if (!Strings.isNullOrEmpty(format)) {
        sdfOrd = new SimpleDateFormat(format);
      }
      if (!Strings.isNullOrEmpty(dateStr)) {
        date = sdfOrd.parse(dateStr);
      }
    } catch (final ParseException e) {
      try {
        sdfOrd = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        date = sdfOrd.parse(dateStr);
      } catch (final ParseException e1) {
        logger.error("Error ", e1);
        return null;
      }
    }
    return date;
  }

  /**
   * 将date类型转成字串
   *
   * @param date
   * @return
   */
  public static String parseDateToString(final Date date,
      final String formart) {
    String s = "";
    try {
      SimpleDateFormat sdf1 = new SimpleDateFormat(DATEFORMAT_Y4_MM_DD_HMS);
      if (formart != null && !"".equals(formart.trim())) {
        sdf1 = new SimpleDateFormat(formart);
      }
      if (date != null) {
        s = sdf1.format(date);
      }
    } catch (final Exception e) {
      logger.error("Error ", e);
      s = "";
    }
    return s;
  }

}
