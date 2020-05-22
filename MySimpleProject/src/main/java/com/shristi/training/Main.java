package com.shristi.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// creating the IOC Container
		ApplicationContext context = new AnnotationConfigApplicationContext("com.shristi");
		System.out.println("in main");
//		Employee emp = (Employee)context.getBean("employee");
		Employee emp  = context.getBean(Employee.class);
//		Employee emp = context.getBean("employee",Employee.class);
		System.out.println(emp);
	}

}
