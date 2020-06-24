package com.bookapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class BarCode {
	int barId;
	int ISBNnumber; 
	String description; // fiction ,
	public BarCode(int iSBNnumber, String description) {
		super();
		ISBNnumber = iSBNnumber;
		this.description = description;
	}
	
	
}
