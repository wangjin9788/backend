package com.plastech.crm.util;

import java.util.Date;
import java.util.UUID;

/**
 *
 * String Generator.
 *
 * @author yemin
 *
 */
public final class UniqueStringGenerator {

  /**
   * String English
   */
  private static String[] s =
      {"A", "B", "C", "D", "E", "F", "G", "X", "Y", "Z", "V", "L"};

  /**
   * String number
   */
  private static String[] snumber =
      {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

  /**
   * 定义随机类
   */
  private static java.util.Random random = new java.util.Random();

  /**
   * 最大生成数
   */
  private static final int MAX_GENERATE_COUNT = 99999;
  /**
   * 生成数:0
   */
  private static int generateCount = 0;

  private UniqueStringGenerator() {}

  /**
   *
   * 获取用户编号(唯一的)
   *
   * @return
   */
  public static synchronized String getUniqueUid(final Long uid) {
    final StringBuilder unumberBf = new StringBuilder();

    for (int i = 0; i < 4; i++) {
      final int result = random.nextInt(12);
      unumberBf.append(s[result]);
    }

    unumberBf.append(CommonTools.parseDateToString(new Date(), "yyMMdd"));
    unumberBf.append(fillSymbol(uid));

    return unumberBf.toString();
  }

  /**
   * 返回五位数的编号
   *
   * @param uid 用户Id
   * @return String
   */
  private static String fillSymbol(final Long uid) {
    final String tr = uid + "";
    if (tr.length() == 1) {
      return "000" + tr;
    } else if (tr.length() == 2) {
      return "000" + tr;
    } else if (tr.length() == 3) {
      return "0" + tr;
    } else if (tr.length() == 4) {
      return tr;
    } else {
      return tr.substring(tr.length() - 4, tr.length());
    }
  }

  /**
   * 返回（不低于）N位数的编号
   *
   * @param uid
   * @param len
   * @return
   */
  public static String fillSymbolToNumber(final Long uid, final int len) {
    if (uid == null || len > 20) {
      return null;
    }

    final String a = "9999999999999999999999";
    final String b = "0000000000000000000000";
    final String prefix = b.substring(b.length() - len, b.length());
    final int maxNumber =
        Integer.valueOf(a.substring(a.length() - len, a.length()));

    if (uid > maxNumber) {
      return uid + "";
    } else {
      String tr = prefix + uid;
      tr = tr.substring(tr.length() - len, tr.length());
      return tr;
    }
  }

  /**
   *
   * 获得16位长度的十六进制的UUID字符串
   *
   * @return UUID
   */
  public static String get16UUID() {

    final UUID id = UUID.randomUUID();
    final String[] idd = id.toString().split("-");
    return idd[0] + idd[1] + idd[2];
  }

  /**
   *
   * 获得32位长度的十六进制的UUID字符串
   *
   * @return UUID
   */
  public static String get32UUID() {
    return UUID.randomUUID().toString().replace("-", "");
  }

  public static String randomNumber(final int size) {
    final StringBuilder strb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      final int result = random.nextInt(10);
      strb.append(snumber[result]);
    }
    return strb.toString();
  }

  public static synchronized String getUniqueString() {
    final StringBuilder starStr = new StringBuilder();

    for (int i = 0; i < 3; i++) {
      final int result = random.nextInt(12);
      starStr.append(s[result]);
    }

    if (generateCount > MAX_GENERATE_COUNT) {
      generateCount = 0;
    }

    starStr.append(Long.toString(System.currentTimeMillis()));
    starStr.append(Integer.toString(generateCount));
    generateCount++;
    return starStr.toString();
  }

}
