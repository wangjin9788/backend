package com.plastech.crm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.base.Strings;

/**
 * moke send httpRequest( Get And Post ).
 *
 * @author yemin
 *
 */
public final class HttpRequestSenderUtil {

  private HttpRequestSenderUtil() {}

  /**
   * 日志类
   */
  protected static Logger logger =
      LoggerFactory.getLogger(HttpRequestSenderUtil.class);

  public static String sendYunZhiXunPost(final String url, final String param,
      final String authorization) {
    System.setProperty("https.protocols", "TLSv1,TLSv1.2,TLSv1.1,SSLv3");
    return sendPost(url, param, "application/json",
        "application/json;charset=utf-8", authorization);
  }

  /**
   * 向指定 URL 发送POST方法的请求.
   *
   * @param url 发送请求的 URL
   * @param accept accept
   * @param contenttype contentType
   * @param authorization authorizTion
   * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
   * @return 所代表远程资源的响应结果
   */
  public static String sendPost(final String url, final String param,
      final String accept, final String contenttype,
      final String authorization) {
    PrintWriter out = null;
    BufferedReader in = null;
    String result = "";
    try {
      final URL realUrl = new URL(url);
      // 打开和URL之间的连接
      final URLConnection conn = realUrl.openConnection();
      // 设置通用的请求属性
      if (!Strings.isNullOrEmpty(accept)) {
        conn.setRequestProperty("Accept", accept);
      } else {
        conn.setRequestProperty("accept", "*/*");
      }
      if (!Strings.isNullOrEmpty(contenttype)) {
        conn.setRequestProperty("Content-Type", contenttype);
      }
      if (!Strings.isNullOrEmpty(contenttype)) {
        conn.setRequestProperty("Authorization", authorization);
      }

      conn.setRequestProperty("connection", "Keep-Alive");
      conn.setRequestProperty("user-agent",
          "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

      conn.setConnectTimeout(10000); // 连接超时 单位毫秒
      conn.setReadTimeout(5000); // 读取超时 单位毫秒

      // 发送POST请求必须设置如下两行
      conn.setDoOutput(true);
      conn.setDoInput(true);
      // 获取URLConnection对象对应的输出流
      out = new PrintWriter(
          new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
      // 发送请求参数
      out.print(param);
      // flush输出流的缓冲
      out.flush();
      // 定义BufferedReader输入流来读取URL的响应
      in = new BufferedReader(
          new InputStreamReader(conn.getInputStream(), "UTF-8"));
      final StringBuilder buider = new StringBuilder();
      while ((result = in.readLine()) != null) {
        buider.append(result);
      }
      result = buider.toString();
    } catch (final Exception e) {
      logger.info("Error occur when send httpRequest-POST！{}", e);
    } finally {
      try {
        if (out != null) {
          out.close();
        }
        if (in != null) {
          in.close();
        }
      } catch (final IOException ex) {
        logger.error("Error: {}", ex);
      }
    }
    return result;
  }
}
