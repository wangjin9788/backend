package com.plastech.crmoauthclient.jwt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.jose4j.keys.AesKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * db init util
 *
 * @author yemin:
 * @date 2018年5月18日 上午11:13:39
 *
 */
public class AeskeyInitUtil {

  private AeskeyInitUtil() {}

  private static final AeskeyInitUtil AESKEY_INIT_UTIL = new AeskeyInitUtil();

  private static Logger logger = LoggerFactory.getLogger(AeskeyInitUtil.class);

  public static AeskeyInitUtil getInstance() {
    return AESKEY_INIT_UTIL;
  }

  /**
   * init AesKey
   *
   * @author: ym
   */
  public void initAesKey() {
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    try {
      conn = ConnectionUtil.getConnection(null);
      final String sql = "SELECT aeskey FROM aeskey WHERE status = 1 LIMIT 1";
      preparedStatement = conn.prepareStatement(sql);
      rs = preparedStatement.executeQuery();
      if (rs.next()) {
        final byte[] byteArr = rs.getBytes("aeskey");
        // byte[] byteArr = "tfiidp7RBWaELrtK".getBytes();
        logger.info("aeskey from db:"
            + new String(byteArr).substring(0, byteArr.length - 4) + "....");
        JWTUtil.aeskey = new AesKey(byteArr);
        if (JWTUtil.aeskey == null) {
          throw new ExceptionInInitializerError("aeskey is null");
        }
      } else {
        throw new ExceptionInInitializerError("aeskey is not exist in the db");
      }
    } catch (final Exception e) {
      throw new Error(e);
    } finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (final Exception e) {
        logger.error("Error ", e);
      }
    }
  }
}
