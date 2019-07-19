package com.plastech.crmsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CrmSaApplication {

	public static void main(final String[] args) {
		SpringApplication.run(CrmSaApplication.class, args);
	}

}

