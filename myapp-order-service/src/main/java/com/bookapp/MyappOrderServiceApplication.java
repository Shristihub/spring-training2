package com.bookapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class MyappOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappOrderServiceApplication.class, args);
	}
	
@Bean
@LoadBalanced
public RestTemplate restTemplate() {
	RestTemplate restTemplate = new RestTemplate();
	List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
	//Add the Jackson Message converter
	MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

	converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));        
	messageConverters.add(converter);  
	restTemplate.setMessageConverters(messageConverters); 
	return restTemplate;
}
}
