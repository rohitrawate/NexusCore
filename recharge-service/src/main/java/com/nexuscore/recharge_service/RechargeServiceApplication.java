package com.nexuscore.recharge_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.nexuscore.recharge_service.client")
public class RechargeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RechargeServiceApplication.class, args);
	}

}
