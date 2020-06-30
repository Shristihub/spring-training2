package com.bookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.bookapp.filters.ErrorFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class MyappZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappZuulGatewayApplication.class, args);
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
}
