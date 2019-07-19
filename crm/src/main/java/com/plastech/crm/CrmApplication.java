package com.plastech.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@tk.mybatis.spring.annotation.MapperScan(
    basePackages = "com.plastech.crm.mapper")
@SpringBootApplication
public class CrmApplication {

  public static void main(final String[] args) {
    SpringApplication.run(CrmApplication.class, args);
  }

}

