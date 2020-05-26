package com.bookapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {
	String city;

	public String getCity() {
		return city;
	}
	@Value("${employee.address.city}")
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + "]";
	}
	

}
