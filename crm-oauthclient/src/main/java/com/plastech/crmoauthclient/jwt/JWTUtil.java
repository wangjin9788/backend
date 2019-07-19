package com.plastech.crmoauthclient.jwt;

import java.util.concurrent.TimeUnit;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.NumericDate;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.keys.AesKey;
import org.jose4j.lang.JoseException;
import org.json.JSONObject;
//import org.json.JSONObject;
// import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import com.google.common.base.Strings;
import com.plastech.crmcommon.dto.OauthUserInfo;
import com.plastech.crmcommon.global.GlobalConstant;
import com.plastech.crmoauthclient.util.RedisUtil;

/**
 * Json Web Token util
 *
 * @author yemin
 *
 */
public class JWTUtil {

  private static Logger logger = LoggerFactory.getLogger(JWTUtil.class);

  public static final int VALID_TIME = 60 * 60 * 24;// cookie的有效期(秒)
  public static final int COOKIE_REFRESH_TIME = 60 * 60 * 23;// 如果cookie的剩余有效时间少于此时间(秒)，则更新cookie
  public static final String DOMAIN = null;// cookie的domain属性(为null则不设置)

  public static final int TOKEN_VALID_TIME = 60 * 60 * 24;// token的有效期(秒)
  public static final int REFRESH_INTERVAL = 60 * 60 * 23;// 同一个用户，两次更新token的最短时间间隔(秒)
  public static final int TOKEN_REFRESH_TIME = 60 * 60 * 23;// 如果token的剩余有效时间少于此时间(秒)，则更新token

  public static final String TOKEN_NAME =
      GlobalConstant.GLOBAL_SERVER_NAME + "_token";// 用来保存token的cookie的name值
  public static final String INVALID_KEY =
      GlobalConstant.GLOBAL_SERVER_NAME + "_invalidToken";// 使用该key，将非法token保存到Redis中
  public static final String TOKEN_REFRESH_POINT =
      GlobalConstant.GLOBAL_SERVER_NAME + "tokenRefreshPoint";// 使用该key+userid,将token更新时间点保存到Redis中

  // Token中放的信息对应的key
  public static final String[] tokenInfoArr =
      new String[] {"UID", "UNAME", "UNUMBER"};
  public static AesKey aeskey = null;// 生成和校验token时要用到的key

  /**
   * 生成token
   *
   * @param userInfoArr
   * @param request
   * @param response
   * @return
   * @author: ym
   */
  public static String produceToken(final OauthUserInfo loginInfo) {
    try {
      // JWTClaims：JWT中的信息载体
      final JwtClaims claims = new JwtClaims();
      claims.setIssuer(GlobalConstant.GLOBAL_SERVER_NAME); // who creates the
      // token and
      // signs it
      claims.setAudience(GlobalConstant.GLOBAL_SERVER_NAME + "Users"); // to
      // whom
      // the
      // token
      // is
      // intended
      // to
      // be
      // sent
      claims.setGeneratedJwtId(); // a unique identifier for the token
      claims.setIssuedAtToNow(); // when the token was issued/created
                                 // (now)
      claims.setNotBeforeMinutesInThePast(2); // time before which the
                                              // token is not yet valid (2
                                              // minutes ago)
      claims.setSubject("subject"); // the subject/principal is whom the
                                    // token is about

      claims.setClaim("UID",
          loginInfo.getUid() != null ? loginInfo.getUid() + "" : "");
      claims.setClaim("UNAME", !Strings.isNullOrEmpty(loginInfo.getUname())
          ? loginInfo.getUname() : "");
      claims.setClaim("UNUMBER", !Strings.isNullOrEmpty(loginInfo.getUnumber())
          ? loginInfo.getUnumber() : "");

      // 生成token
      final String jwt = createToken(claims);

      return jwt;
    } catch (final Exception e) {
      logger.error("Error ", e);
    }

    return null;
  }

  /**
   * 根据Claims生成token
   *
   * @param claims
   * @return
   * @author: ym
   */
  private static String createToken(final JwtClaims claims) throws Exception {

    claims.setExpirationTimeMinutesInTheFuture(TOKEN_VALID_TIME / 60); // 设置token的有效期

    // JWTClaims被封装到JWE中
    final JsonWebEncryption jwe = new JsonWebEncryption();
    jwe.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.A128KW);
    jwe.setEncryptionMethodHeaderParameter(
        ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256);
    jwe.setKey(aeskey);
    jwe.setPayload(claims.toJson());

    // 生成JWT
    final String jwt = jwe.getCompactSerialization();
    logger.debug(GlobalConstant.GLOBAL_SERVER_NAME + " Produces A New Token: "
        + jwt.substring(0, 20) + "...");
    logger.debug("ExpirationTime：" + claims.getExpirationTime());
    logger.info(GlobalConstant.GLOBAL_SERVER_NAME + " Produces A New Token: "
        + jwt.substring(0, 20) + "...");
    logger.info("ExpirationTime：" + claims.getExpirationTime());

    return jwt;
  }

  /**
   * 从request中读取携带token的cookie
   *
   * @param request
   * @param response
   * @return
   * @author: ym
   */
  public static Cookie getCookie(final HttpServletRequest request) {
    final Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (final Cookie coki : cookies) {// 获取token
        if (TOKEN_NAME.equals(coki.getName())) {
          return coki;
        }
      }
    }
    return null;
  }

  /**
   * 校验token
   *
   * @param request
   * @param response
   * @return
   * @author: ym
   */
  public static Long checkUserToken(final String token) {
    try {
      logger.info("解析token");
      logger.info("aeskey：" + aeskey.getEncoded().toString());
      // 解析token
      final JsonWebEncryption receiverJwe = new JsonWebEncryption();
      receiverJwe.setCompactSerialization(token);
      receiverJwe.setKey(aeskey);
      final String data = receiverJwe.getPayload();

      logger.info("检查token有效期");
      // 检查token是否过了有效期
      final JwtClaims claims = JwtClaims.parse(data);
      final NumericDate expirationTime = claims.getExpirationTime();
      if (expirationTime.isBefore(NumericDate.now())) {// token已过期
        throw new InvalidJwtException(token + " Expired At " + expirationTime);
      }

      logger.info("检查token是否禁用");
      // 检查token是否被禁用
      final boolean isValid = isTokenValid(claims);
      if (!isValid) {
        return null;
      }

      // 获取token中的JSON数据，放入request域中
      final JSONObject json = new JSONObject(data);
      String userId = "";
      String appIds = "";
      for (int i = 0; i < tokenInfoArr.length; i++) {
        final String key = tokenInfoArr[i];
        String value = "";
        if (json.has(key)) {
          value = json.getString(key);
        }

        if ("UID".equals(key)) {
          userId = value;
        }

        if ("APP_IDS".equals(key)) {
          appIds = value;
        }
      }

      // 检查用户是否有访问当前app的权限
      final String issuer = claims.getIssuer();
      if (!GlobalConstant.GLOBAL_SERVER_NAME.equals(issuer) && (appIds == null
          || appIds.indexOf(GlobalConstant.GLOBAL_SERVER_NAME) == -1)) {
        logger.warn("Token belong to user (uid=" + userId
            + ") does not have privilege to visit "
            + GlobalConstant.GLOBAL_SERVER_NAME);
        return null;
      }

      logger.info("检查token完毕");

      return !Strings.isNullOrEmpty(userId) ? Long.valueOf(userId) : 0L;

    } catch (final InvalidJwtException e) {// token已过期
      logger.warn("Warning! token is expired : " + token);
    } catch (final JoseException e) {// token数据格式错误
      logger.warn("Warning! token format error : " + token);
    } catch (final MalformedClaimException e) {// 读取token有效期出现错误
      logger
          .warn("Warning! Error occur when reading the expire time of token : "
              + token);
    } catch (final Exception e) {// 其他问题
      logger.error("Warning! token is invalid : " + token + " , {}", e);
    }

    return null;
  }

  /**
   * 将token加入“非法token列表”中
   *
   * @param claims
   * @author: ym
   */
  public static void addToInvalidToken(final JwtClaims claims) {
    try {
      final String jwtId = claims.getJwtId();// token的唯一标识符

      if (jwtId == null || jwtId.trim().equals("")) {
        return;
      }

      final String key = "jwttoken:" + jwtId;
      final RedisTemplate<Object, Object> redisTemplate =
          RedisUtil.getRedisTemplate();
      final HashOperations<Object, Object, Object> opsForHash =
          redisTemplate.opsForHash();
      if (opsForHash.hasKey(key, "invalid")) {
        opsForHash.put(key, "invalid", "1");
        redisTemplate.expire(key, TOKEN_VALID_TIME, TimeUnit.SECONDS);// 设置无效时间
        logger.info("Frozen token! Key：" + key);
      }
    } catch (final MalformedClaimException e) {
      logger.error("Error ", e);
    }
  }

  /**
   * 检查token是否已被禁用
   *
   * @param claims
   * @return 可用返回true,不可用返回false
   * @author: ym
   */
  private static boolean isTokenValid(final JwtClaims claims) {
    try {
      final String jwtId = claims.getJwtId();

      if (jwtId == null || jwtId.trim().equals("")) {
        return false;
      }

      final String key = "jwttoken:" + jwtId;
      final RedisTemplate<Object, Object> redisTemplate =
          RedisUtil.getRedisTemplate();
      final HashOperations<Object, Object, Object> opsForHash =
          redisTemplate.opsForHash();
      if (opsForHash.hasKey(key, "invalid")) {
        final String value = (String) opsForHash.get(key, "invalid");
        if ("1".equals(value)) {
          return false;
        }
      }
    } catch (final MalformedClaimException e) {
      logger.error("Error ", e);
    }

    return true;// 检查失败，也返回true(这样即使Redis服务器down机，短期内也不会影响系统的正常运行)
  }

  /**
   * 注销/禁用 token
   *
   * @return
   * @author: ym
   */
  public static boolean consumeToken(final String token) {
    try {
      if (Strings.isNullOrEmpty(token)) {
        return false;
      }

      // 解析token
      final JsonWebEncryption receiverJwe = new JsonWebEncryption();
      receiverJwe.setCompactSerialization(token);
      receiverJwe.setKey(aeskey);
      final String data = receiverJwe.getPayload();
      final JwtClaims claims = JwtClaims.parse(data);

      // 将token加入无效token列表中
      addToInvalidToken(claims);

      return true;
    } catch (final Exception e) {
      logger.error("Error ", e);
    }
    return false;
  }

  /**
   * 往redis中存入键值对 注意：Redis缓存被所有用户共享，请注意key值的唯一性
   *
   * @param key
   * @param value
   * @param userId 用户ID
   * @return
   * @author: ym
   */
  public static boolean putIntoRedis(final String key, final String value,
      final String userId) {
    try {
      if (key == null || key.equals("") || userId == null
          || userId.equals("")) {
        return false;
      }

      RedisUtil.getRedisTemplate().opsForValue().set(key + userId, value);

      return true;
    } catch (final Exception e) {
      logger.error("Error ", e);
    }

    return false;
  }

  /**
   * 根据key，从Redis中取值
   *
   * @param key
   * @param userId 用户ID
   * @return
   * @author: ym
   */
  public static String getFromRedis(final String key, final String userId) {
    if (Strings.isNullOrEmpty(key) || Strings.isNullOrEmpty(userId)) {
      return null;
    }

    try {
      String value = null;
      final RedisTemplate<Object, Object> redisTemplate =
          RedisUtil.getRedisTemplate();
      if (redisTemplate.hasKey(key + userId)) {
        value = (String) redisTemplate.opsForValue().get(key + userId);
      }

      return value;
    } catch (final Exception e) {
      logger.error("Error ", e);
    }

    return null;
  }

  /**
   * 从redis缓存中移除键值对
   *
   * @param key
   * @param userId
   * @return 移除成功返回true，key不存在或者移除失败，则返回false
   * @author: ym
   */
  public static boolean removeFromRedis(final String key, final String userId) {
    if (key == null || key.equals("") || userId == null || userId.equals("")) {
      return false;
    }


    final RedisTemplate<Object, Object> redisTemplate =
        RedisUtil.getRedisTemplate();
    if (redisTemplate.hasKey(key + userId)) {
      redisTemplate.delete(key + userId);
      return true;
    }

    return false;
  }

}
