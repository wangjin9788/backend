package com.plastech.crmoauthclient.jwt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.google.common.base.Strings;

/**
 * Connection util
 *
 * @author yemin:
 * @date 2018年5月18日 上午11:13:39
 *
 */
@Component
public class ConnectionUtil {

  @Value("${db.url}")
  private String db_url;
  @Value("${db.loginName}")
  private String db_login_name;
  @Value("${db.loginPassword}")
  private String db_login_password;
  @Value("${db.driver}")
  private String db_driver;

  private ConnectionUtil() {}

  private static ConnectionUtil connectionUtil;

  @PostConstruct
  public void init() {
    connectionUtil = this;
    connectionUtil.db_url = this.db_url;
    connectionUtil.db_login_name = this.db_login_name;
    connectionUtil.db_login_password = this.db_login_password;
  }

  public final String getDb_url() {
    return db_url;
  }

  public final String getDb_login_name() {
    return db_login_name;
  }

  public final String getDb_login_password() {
    return db_login_password;
  }

  public final String getDb_driver() {
    return db_driver;
  }

  public static Connection getConnection(final String dbName)
      throws SQLException, ClassNotFoundException {
    final String dbUrl = !Strings.isNullOrEmpty(dbName)
        ? connectionUtil.db_url.replace("idpdb", dbName) : connectionUtil.db_url;
    Class.forName(connectionUtil.db_driver);
    final Connection conn = DriverManager.getConnection(dbUrl,
        connectionUtil.db_login_name, connectionUtil.db_login_password);// （url数据库的IP地址，user数据库用户名，password数据库密码）
    return conn;
  }

}
