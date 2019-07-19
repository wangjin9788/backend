package com.plastech.crmeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CrmEurekaApplication {

	public static void main(final String[] args) {
		SpringApplication.run(CrmEurekaApplication.class, args);
	}

}

