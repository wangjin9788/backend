package com.plastech.crmoauthclient.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.google.common.base.Strings;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月24日 下午1:23:06
 *
 */
public class ReadFiledata {

  public static void txt2String(final File file) {
    // final StringBuilder result = new StringBuilder();
    try {
      final InputStreamReader reader =
          new InputStreamReader(new FileInputStream(file), "GBK");
      final BufferedReader br = new BufferedReader(reader);// 构造一个BufferedReader类来读取文件
      String s = null;
      long pmid = 0;
      while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
        // System.out.println(s);
        if (!Strings.isNullOrEmpty(s)) {
          // 结束
          if (s.startsWith("###########")) {
            break;
          }

          // 开始
          if (s.startsWith("##")) {
            s = s.replace("##", "").trim();
            pmid = Long.parseLong(s);
            continue;
          }

          final String[] arr = s.split(",");
          if (arr.length != 3) {
            System.out.println("error line:" + s);
          }
          final String note = arr[0].trim();
          final String method = arr[1].trim().toLowerCase();
          final String url = arr[2].trim();
          final int k = url.indexOf("/", 2);
          final String module = url.substring(0, k);
          String inface = url.substring(k, url.length());

          if (inface.matches(".*\\$\\{[(A-Za-z)]+\\}.*")) {
            inface = inface.replaceAll("\\$\\{[(A-Za-z)]+\\}", "[0-9]+");
            inface = "^" + inface + "$";
          }

          System.out.println(module + "," + inface + "," + method + "," + note);
          final long puid = insertPurl(module, inface, method, note);
          if (puid > 0) {
            insertPermissionPurl(puid, pmid);
          }
        }
        // result.append(System.lineSeparator() + s);
      }
      br.close();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    // return result.toString();
  }

  // public static void main(final String[] args) {
  // final File file = new File("C:/Users/Administrator/Desktop/purl.txt");
  // // System.out.println(
  // txt2String(file);
  // // );
  // }

  private static void insertPermissionPurl(final long puid, final long pmid) {
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    try {
      conn = getConnetion();
      final String insertSql =
          "insert into permission_purl (pmid,puid) values (?,?)";
      preparedStatement = conn.prepareStatement(insertSql);
      preparedStatement.setLong(1, puid);
      preparedStatement.setLong(2, pmid);
      final int i = preparedStatement.executeUpdate();
      System.out.println("i:" + i);
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
        e.printStackTrace();
        // logger.error("Error ", e);
      }
    }

  }


  /**
   *
   * @author: ym
   */
  public static long insertPurl(final String module, final String inface,
      final String method, final String note) {
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    try {
      conn = getConnetion();
      final String sql =
          "SELECT puid FROM purl WHERE module=? and inface=? and method=? LIMIT 1";
      preparedStatement = conn.prepareStatement(sql);
      preparedStatement.setString(1, module);
      preparedStatement.setString(2, inface);
      preparedStatement.setString(3, method);
      rs = preparedStatement.executeQuery();
      if (rs.next()) {
        final long puid = rs.getLong(1);
        System.out.println("exist,puid=" + puid);
        return puid;
      } else {
        preparedStatement.close();;
        rs.close();
        final String insertSql =
            "insert into purl (module,inface,method,param_check,note,permissive) values (?,?,?,?,?,?)";
        preparedStatement =
            conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, module);
        preparedStatement.setString(2, inface);
        preparedStatement.setString(3, method);
        preparedStatement.setString(4, "0");
        preparedStatement.setString(5, note);
        preparedStatement.setInt(6, 0);
        final int i = preparedStatement.executeUpdate();
        System.out.println("i:" + i);
        rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
          final long newid = rs.getLong(1);
          return newid;
        }
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
        e.printStackTrace();
        // logger.error("Error ", e);
      }
    }
    return -2;
  }

  private static Connection getConnetion()
      throws ClassNotFoundException, SQLException {
    Connection conn;
    // 1.加载驱动程序
    Class.forName("com.mysql.jdbc.Driver");
    // 2.获得数据库链接
    conn = DriverManager.getConnection(
        "jdbc:mysql://192.168.100.98:3306/pstcrm?useUnicode=true&characterEncoding=utf8&useOldAliasMetadataBehavior=true&useSSL=false",
        "root", "ikmn934k0-srm3Ks");
    return conn;
  }
}
