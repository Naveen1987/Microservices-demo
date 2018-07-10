package com.springboot.microservice.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/*
 * This was first version when CurrencyExchangeServiceProxy was not added
 */
//@SpringBootApplication
//public class CurrencyApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(CurrencyApplication.class, args);
//	}
//}


/*
 * After @FeignClient added
 */
@SpringBootApplication
@EnableFeignClients("com.springboot.microservice.example.currencyconversion")
@EnableDiscoveryClient
public class CurrencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyApplication.class, args);
	}
}