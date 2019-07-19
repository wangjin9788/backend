package com.plastech.crmoauthclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
//@ComponentScan("com.plastech.crmoauthclient")
public class CrmOauthclientApplication {

	public static void main(final String[] args) {
		SpringApplication.run(CrmOauthclientApplication.class, args);
	}

}

