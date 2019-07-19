package com.plastech.crm.util.constant;

/**
 * Constant.
 *
 * @author yemin:
 * @date 创建时间：2018年05月13日 下午2:17:55
 *
 */

public final class Constant {

  private Constant() {}

  public static final String LOGIN_URL = "/login-management/users/login/web";

  public static final String ENVIRONMENT_DEBUG = "DEBUG";
  public static final String ENVIRONMENT_RELEASE = "RELEASE";

  // Web Api Version
  public static final String VERSION_1_0 = "1.0";

  /**
   * （保存用户token的）cookie的key
   */
  public static final String TOKEN_NAME = "token";
  /**
   * （保存用户token的）cookie的有效期(秒)
   */
  public static final int VALID_TIME = 3600 * 24;


}
