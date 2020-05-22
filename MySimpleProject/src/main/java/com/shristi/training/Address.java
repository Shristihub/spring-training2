package com.shristi.training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
// address
public class Address {
	public Address() {
		System.out.println("inside address");
	}

	String city;

	public String getCity() {
		return city;
	}
	@Value("Pune")
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + "]";
	}
	
}
