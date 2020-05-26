package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.service.Employee;

@SpringBootApplication
public class ZspringBootConsoleApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ZspringBootConsoleApplication.class, args);
		System.out.println("in main");
		
	}
//	@Autowired
//	ApplicationContext context;
//	
	
	@Autowired
	Employee emp;
	@Override
	public void run(String... args) throws Exception {
		
//		Employee emp = context.getBean(Employee.class);
		System.out.println(emp);
//		System.out.println();
//		String[] beanNames = context.getBeanDefinitionNames();
//		for (String bean : beanNames) {
//			System.out.println(bean);
//		}
		
		
		
		
		
	}

}




