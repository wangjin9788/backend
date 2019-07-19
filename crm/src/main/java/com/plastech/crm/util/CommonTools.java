package com.plastech.crm.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.base.Strings;
import com.plastech.crm.resultcode.ResultCodeSystem;

/**
 *
 * Common Util.
 *
 * @author yemin
 *
 */
public final class CommonTools {

  /**
   * 日志类
   */
  private static Logger logger = LoggerFactory.getLogger(CommonTools.class);

  /**
   * 匹配所有浮点数
   */
  private static final String REG_DOUBLE = "^[-]?[0-9]+[\\.]?[0-9]*$";

  /**
   * 匹配多个非负整数
   */
  private static final String REG_MULTI_NONNEGATIVE_INT = "^[0-9,]+$";

  /**
   * 匹配内地手机号
   */
  private static final String REG_PHONENUMBER = "^[1][3,4,5,7,8][0-9]{9}$";

  /**
   * 匹配香港手机号
   */
  private static final String REG_HONGKONGPHONENUMBER = "^[5,6,9][0-9]{7}$";

  /**
   * 邮箱
   */
  private static final String REG_EMAIL =
      "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
  /**
   * 时间格式：yyyy-MM.
   */
  public static final String DATEFORMAT_Y4_MM = "yyyy-MM";

  /**
   * 时间格式：yyyy-MM-dd.
   */
  public static final String DATEFORMAT_Y4_MM_DD = "yyyy-MM-dd";
  public static final String DATEFORMAT_Y4MM_DD = "yyyy年MM月dd日";
  /**
   * 时间格式：yy-MM-dd.
   */
  public static final String DATEFORMAT_Y2_MM_DD = "yy-MM-dd";

  /**
   * 时间格式：yyyy-MM-dd HH:mm:ss.
   */
  public static final String DATEFORMAT_Y4_MM_DD_HMS = "yyyy-MM-dd HH:mm:ss";

  /**
   * 时间格式：yyyy-MM-dd HH:mm.
   */
  public static final String DATEFORMAT_Y4_MM_DD_HM = "yyyy-MM-dd HH:mm";

  /**
   * 时间格式：HH:mm:ss.
   */
  public static final String DATEFORMAT_HMS = "HH:mm:ss";

  /**
   * 时间格式：HH:mm.
   */
  public static final String DATEFORMAT_HM = "HH:mm";

  /**
   * 时间格式：yyyyMMdd.
   */
  public static final String DATEFORMAT_Y4MMDD = "yyyyMMdd";

  /**
   * 时间格式：yyyyMMddHHmmss.
   */
  public static final String DATEFORMAT_Y4MMDDHMS = "yyyyMMddHHmmss";

  /**
   * 时间格式：yyyy
   */
  public static final String DATEFORMAT_Y4 = "yyyy";

  /**
   * 时间格式：yyyy
   */
  public static final String DATEFORMAT_M2 = "MM";


  /**
   * private
   */
  private CommonTools() {
    super();
    throw new IllegalStateException("Utility class");
  }

  /**
   * yyyyMMddHHmm格式的时间字符串，转成Date
   *
   * @param dateStr str
   * @param format forMat
   * @return date
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
        logger.error(ResultCodeSystem.RESULT_MSG_101022, e1);
        return null;
      }
    }
    return date;
  }

  /**
   * 将date类型转成字串.
   *
   * @param date
   * @param formart forMart
   * @return String
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
      logger.error(ResultCodeSystem.RESULT_MSG_101022, e);
      s = "";
    }
    return s;
  }

  /**
   * 判断字符串是否是浮点数.
   *
   * @param str str
   * @return boolean
   */
  public static boolean isRegAllDouble(final String str) {
    return !Strings.isNullOrEmpty(str) && str.matches(REG_DOUBLE);
  }

  /**
   * 判断字符串是否是手机号.
   *
   * @param str str
   * @return boolean
   */
  public static boolean isRegPhoneNumber(final String str) {
    return (!Strings.isNullOrEmpty(str) && (str.matches(REG_PHONENUMBER)
        || str.matches(REG_HONGKONGPHONENUMBER))) ? true : false;
  }


  /**
   * 判断字符串是否是香港手机号.
   *
   * @param str str
   * @return boolean
   */
  public static boolean isRegPhoneNumberHk(final String str) {
    return (!Strings.isNullOrEmpty(str) && str.matches(REG_HONGKONGPHONENUMBER)
        ? true : false);
  }

  /**
   * 判断字符串是否是内地手机号.
   *
   * @param str str
   * @return boolean
   */
  public static boolean isRegPhoneNumberCn(final String str) {
    return (!Strings.isNullOrEmpty(str) && str.matches(REG_PHONENUMBER) ? true
        : false);
  }

  /**
   * 判断字符串是否是邮箱地址.
   *
   * @param str str
   * @return boolean
   */
  public static boolean isRegEmail(final String str) {
    return !Strings.isNullOrEmpty(str) && str.matches(REG_EMAIL);
  }

  /**
   * 判断字符串是否匹配以逗号连接的多个整数.
   *
   * @param chbid
   * @return boolean
   */
  public static boolean isRegMultiInt(final String chbid) {
    return !Strings.isNullOrEmpty(chbid)
        && chbid.matches(REG_MULTI_NONNEGATIVE_INT);
  }

  public static String getFullRequestParameter(
      final HttpServletRequest request) {
    String requestUrl = "";
    final StringBuilder builder = new StringBuilder();
    try {
      final Map<String, String[]> params = request.getParameterMap();
      if (!params.isEmpty()) {
        for (final Entry<String, String[]> key : params.entrySet()) {
          final String[] values = params.get(key.getKey());
          for (int i = 0; i < values.length; i++) {
            final String value = values[i];
            builder.append(key + "=" + value + "&");
          }
        }
        requestUrl = builder.toString();
        // 去掉最后一个"&"
        if (requestUrl.length() > 0) {
          requestUrl = requestUrl.substring(0, requestUrl.length() - 1);
        }
      }

      return requestUrl;
    } catch (final Exception e) {
      logger.error(ResultCodeSystem.RESULT_MSG_101022, e);
    }

    return requestUrl;
  }

  // 根据天数获取对应的时间
  public static Date obtainingTimeThroughParameters(final Date time,
      final Integer daysNumber) {
    if (daysNumber != null) {
      final Calendar calendar = Calendar.getInstance();
      calendar.setTime(time); // 设置时间
      calendar.set(Calendar.HOUR_OF_DAY, 0);
      calendar.set(Calendar.MINUTE, 0);
      calendar.set(Calendar.SECOND, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      calendar.add(Calendar.DATE, daysNumber);
      return calendar.getTime();
    }
    return null;
  }

  // 获取上一周的时间
  public static List<String> getThePreviousWeekTime(final String dateFormat) {
    final List<String> list = new ArrayList<>();
    final SimpleDateFormat format = new SimpleDateFormat(dateFormat);
    final Calendar c = Calendar.getInstance();
    for (int i = 6; i >= 0; i--) {
      c.setTime(new Date());
      c.add(Calendar.DATE, -i);
      final Date d = c.getTime();
      final String day = format.format(d);
      list.add(day);
    }
    return list;
  }

  /**
   * 对字符串做解码处理
   *
   * @param s 需要解码的字符串
   * @param codeStyle 解码所用码表
   * @return 解码失败，返回""。解码成功，返回解码后得到的字符串。
   * @author: ym
   */
  public static String decode(final String s, final String codeStyle) {
    String str = "";
    try {
      str = URLDecoder.decode(s, codeStyle);
    } catch (final Exception e) {
      logger.error("Error ", e);
      str = "";
    }
    return str;
  }

  /**
   * 判断list是否为null或内容为空
   *
   * @param menuDataList
   * @return
   */
  @SuppressWarnings("rawtypes")
  public static boolean isListNullOrEmpty(final List menuDataList) {
    return menuDataList == null || menuDataList.size() == 0;
  }

  /**
   * 深度复制一个对象
   *
   * @param obj
   * @return
   */
  @SuppressWarnings("unchecked")
  public static <T> T deepCloneObject(final T obj) {
    try {
      final ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
      final ObjectOutputStream out = new ObjectOutputStream(byteOut);
      out.writeObject(obj);

      final ByteArrayInputStream byteIn =
          new ByteArrayInputStream(byteOut.toByteArray());
      final ObjectInputStream in = new ObjectInputStream(byteIn);

      return (T) in.readObject();
    } catch (final IOException e) {
      logger.error("Error,{}", e);
    } catch (final ClassNotFoundException e) {
      logger.error("Error,{}", e);
    }
    return null;
  }

  /**
   * 字符串 反序列化为 对象
   */
  public static Object unSerialize(final String serStr) throws Exception {
    final String redStr = URLDecoder.decode(serStr, "UTF-8");
    final ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream(redStr.getBytes("ISO-8859-1"));
    final ObjectInputStream objectInputStream =
        new ObjectInputStream(byteArrayInputStream);
    final Object obj = objectInputStream.readObject();

    objectInputStream.close();
    byteArrayInputStream.close();
    return obj;
  }

  /**
   * 对象序列化为字符串
   */
  public static String serialize(final Object obj) throws Exception {
    final ByteArrayOutputStream byteArrayOutputStream =
        new ByteArrayOutputStream();
    final ObjectOutputStream objectOutputStream =
        new ObjectOutputStream(byteArrayOutputStream);
    objectOutputStream.writeObject(obj);
    String serStr = byteArrayOutputStream.toString("ISO-8859-1");// 必须是ISO-8859-1
    serStr = URLEncoder.encode(serStr, "UTF-8");// 编码后字符串不是乱码（不编也不影响功能）

    objectOutputStream.close();
    byteArrayOutputStream.close();
    return serStr;
  }
}
