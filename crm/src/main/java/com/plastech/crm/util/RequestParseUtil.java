package com.plastech.crm.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.base.Strings;
import com.plastech.crm.util.constant.Constant;

/**
 * request tool.
 *
 * @author: YeMin
 * @date 创建时间：2018年5月10日 下午1:44:48
 *
 */
public final class RequestParseUtil {

  private static final String[] WHITE_LIST = {"http://localhost:8080",
      "http://192.168.100.99:8099", "http://192.168.100.99",
      "http://tcl.yemindream.com", "http://47.107.137.68",
      "http://47.107.137.68:8099", "http://119.28.57.48",
      "http://119.28.57.48:8099", "http://192.168.100.85:8099"};

  private RequestParseUtil() {}

  /**
   * 日记类.
   */
  private static Logger logger =
      LoggerFactory.getLogger(RequestParseUtil.class);

  /**
   * uId.
   */
  public static final String UID_KEY = "USER_UID";

  /**
   * token
   */
  public static final String TOKEN_KEY = "USER_TOKEN";

  /**
   * 获得平台.
   *
   * @param request request
   * @return String
   */
  private static String getPlatform(final HttpServletRequest request) {
    final String key = "platform=";
    return getAcceptValue(request, key);
  }

  /**
   * 是否是web.
   *
   * @param request request
   * @return boolean
   */
  public static boolean isWebPlatform(final HttpServletRequest request) {
    final String platform = getPlatform(request);
    return "web".equals(platform) ? true : false;
  }

  /**
   * 是否是web.
   *
   * @param request request
   * @return boolean
   */
  public static boolean isAppPlatform(final HttpServletRequest request) {
    final String platform = getPlatform(request);
    if (platform != null && ("android".equals(platform.toLowerCase())
        || "ios".equals(platform.toLowerCase())
        || "app".equals(platform.toLowerCase()))) {
      return true;
    }
    return false;
  }

  /**
   * 获取版本号.
   *
   * @param request request
   * @return String
   */
  public static String getVersion(final HttpServletRequest request) {
    final String key = "version=";
    final String value = getAcceptValue(request, key);
    return Strings.isNullOrEmpty(value) ? Constant.VERSION_1_0 : value;
  }

  /**
   * 获取环境.
   *
   * @param request request
   * @return String
   */
  public static String getEnvironment(final HttpServletRequest request) {
    final String key = "environment=";
    return getAcceptValue(request, key);
  }

  /**
   * 获取語言.
   *
   * @param request request
   * @return String
   */
  public static String getLanguage(final HttpServletRequest request) {
    final String key = "language=";
    return getAcceptValue(request, key);
  }

  /**
   * 从HttpHeader的Accept中取出数据
   *
   * @param request request
   * @param key key
   * @return string string
   */
  private static String getAcceptValue(final HttpServletRequest request,
      final String key) {
    if (request == null || Strings.isNullOrEmpty(key)) {
      return null;
    }
    try {
      final String accept = request.getHeader("Accept");
      if (!Strings.isNullOrEmpty(accept) && accept.indexOf(key) != -1) {
        final String[] strArr = accept.split(";");
        for (final String str : strArr) {
          if (str.indexOf(key) != -1) {
            return str.replace(key, "");
          }
        }
      }
    } catch (final Exception e) {
      logger.error("Get accept error , {}", e);
    }

    return null;
  }

  /**
   * 设置用户id.
   *
   * @param request request
   * @param uid uid
   */
  public static void setUid(final HttpServletRequest request, final Long uid) {
    request.setAttribute(UID_KEY, uid);
  }

  /**
   * 获取用户id.
   *
   * @param request
   * @return Long
   */
  public static Long getUid(final HttpServletRequest request) {
    // return getUid();
    try {
      final Long uid = (Long) request.getAttribute(UID_KEY);
      return uid != null ? uid : 0L;
    } catch (final Exception e) {
      logger.error("Get uid from request error , {}", e);
    }

    return 0L;
  }

  // public static Long getUid() {
  // try {
  // final Subject subject = SecurityUtils.getSubject();
  // final String uid = (String) subject.getPrincipal();
  // return Strings.isNullOrEmpty(uid) ? 0L : Long.valueOf(uid);
  // } catch (final NumberFormatException e) {
  // logger.error("Get Uid error");
  // }
  // return 0L;
  // }


  /**
   * 设置token.
   *
   * @param request request
   * @param token token
   */
  public static void setToken(final HttpServletRequest request,
      final String token) {
    request.setAttribute(TOKEN_KEY, token);
  }

  /**
   * 获取Token
   *
   * @param request request
   * @return String
   */
  public static String getToken(final HttpServletRequest request) {
    String token = (String) request.getAttribute(TOKEN_KEY);
    if (Strings.isNullOrEmpty(token)) {
      // 获取request中携带token的cookie
      final Cookie cki = getCookie(request);
      // 检查request中是否携带了token，携带的token是否为null或空字符
      if (cki == null || cki.getValue() == null
          || cki.getValue().trim().equals("")) {
        return null;
      }

      token = cki.getValue();
      setToken(request, token);
    }
    return token;
  }

  /**
   * 从request中读取携带token的cookie
   *
   * @param request
   * @param response
   * @return
   * @author: ym
   * @date: 2015年11月18日 下午8:35:25
   */
  public static Cookie getCookie(final HttpServletRequest request) {
    final Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (final Cookie coki : cookies) {// 获取token
        if (Constant.TOKEN_NAME.equals(coki.getName())) {
          return coki;
        }
      }
    }
    return null;
  }

  /**
   * 是否是release环境.
   *
   * @param request
   * @return boolean
   */
  public static boolean isRelease(final HttpServletRequest request) {
    final String envi = getEnvironment(request);
    return (Constant.ENVIRONMENT_RELEASE.equals(envi));
  }

  public static void setOrigin(final HttpServletRequest request,
      final HttpServletResponse response) {
    final String origin = request.getHeader("origin");
    String originNew = "null";
    for (final String domain : WHITE_LIST) {
      if (domain != null && domain.equals(origin)) {
        originNew = domain;
      }
    }
    response.setHeader("Access-Control-Allow-Origin", originNew);
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setHeader("Access-Control-Allow-Methods",
        "POST, GET,PUT,PATCH, OPTIONS, DELETE");
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Headers",
        "content-type,x-requested-with");
  }

}
