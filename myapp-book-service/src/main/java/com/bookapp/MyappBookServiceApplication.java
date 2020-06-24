package com.bookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyappBookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappBookServiceApplication.class, args);
	}

}
