package com.shristi.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("emp")
public class Employee {
	String name;
	int empId;
	
	public Employee() {
		System.out.println("inside employee");
	}
	@Autowired
	public Employee(Address address) {
		System.out.println("in address");
		this.address = address;
	}
	Address address;
	public String getName() {
		return name;
	}
	@Value("Raju")
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpId() {
		return empId;
	}
	@Value("10")
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Address getAddress() {
		return address;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empId=" + empId + ", address=" + address + "]";
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
