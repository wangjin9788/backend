package com.plastech.crm.config;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 *
 * @author yemin
 *
 */
@Component
public final class ConfigUtil {

  @Resource
  private Config configAutowired;

  private static String uploadTempFolderPath;
  private static boolean cookieSecure;
  private static String exportTempFolderPath;
  private static String intTempFolderPath;
  private static String downloadTempFolderPath;
  private static String downloadLocalhost;

  private ConfigUtil() {}

  public static final boolean isCookieSecure() {
    return cookieSecure;
  }

  private static final void setCookieSecure(final boolean cookieSecure) {
    ConfigUtil.cookieSecure = cookieSecure;
  }

  public static String getUploadTempFolderPath() {
    return uploadTempFolderPath;
  }

  private static void setUploadTempFolderPath(
      final String uploadTempFolderPath) {
    ConfigUtil.uploadTempFolderPath = uploadTempFolderPath;
  }



  public static String getExportTempFolderPath() {
    return exportTempFolderPath;
  }

  public static void setExportTempFolderPath(
      final String exportTempFolderPath) {
    ConfigUtil.exportTempFolderPath = exportTempFolderPath;
  }

  public static String getIntTempFolderPath() {
    return intTempFolderPath;
  }

  public static void setIntTempFolderPath(final String intTempFolderPath) {
    ConfigUtil.intTempFolderPath = intTempFolderPath;
  }

  public static String getDownloadTempFolderPath() {
    return downloadTempFolderPath;
  }

  public static void setDownloadTempFolderPath(
      final String downloadTempFolderPath) {
    ConfigUtil.downloadTempFolderPath = downloadTempFolderPath;
  }

  public static String getDownloadLocalhost() {
    return downloadLocalhost;
  }

  public static void setDownloadLocalhost(final String downloadLocalhost) {
    ConfigUtil.downloadLocalhost = downloadLocalhost;
  }

  @PostConstruct
  public void init() {
    ConfigUtil
        .setUploadTempFolderPath(configAutowired.getUploadTempFolderPath());
    ConfigUtil.setCookieSecure(configAutowired.isCookieSecure());
    ConfigUtil
        .setExportTempFolderPath(configAutowired.getExportTempFolderPath());
    ConfigUtil.setIntTempFolderPath(configAutowired.getIntTempFolderPath());
    ConfigUtil
        .setDownloadTempFolderPath(configAutowired.getDownloadTempFolderPath());
    ConfigUtil.setDownloadLocalhost(configAutowired.getDownloadLocalhost());
  }
}
