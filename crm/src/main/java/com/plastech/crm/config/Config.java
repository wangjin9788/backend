package com.plastech.crm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *
 * @author : yemin
 *
 */
@Configuration
@PropertySource(value = {"classpath:application.properties"},
    ignoreResourceNotFound = true, encoding = "utf-8")
public class Config {

  @Value("${upload.uploadTempFolderPath}")
  private String uploadTempFolderPath;

  @Value("${cookie.secure}")
  private boolean cookieSecure;

  @Value("${export.exportTempFolderPath}")
  private String exportTempFolderPath;

  @Value("${init.initTempFolderPath}")
  private String intTempFolderPath;

  @Value("${download.downloadTempFolderPath}")
  private String downloadTempFolderPath;

  @Value("${download.downloadLocalhost}")
  private String downloadLocalhost;

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  public final boolean isCookieSecure() {
    return cookieSecure;
  }

  public final String getUploadTempFolderPath() {
    return uploadTempFolderPath;
  }

  public String getExportTempFolderPath() {
    return exportTempFolderPath;
  }

  public String getIntTempFolderPath() {
    return intTempFolderPath;
  }

  public String getDownloadTempFolderPath() {
    return downloadTempFolderPath;
  }

  public String getDownloadLocalhost() {
    return downloadLocalhost;
  }

  public void setDownloadLocalhost(final String downloadLocalhost) {
    this.downloadLocalhost = downloadLocalhost;
  }



}
