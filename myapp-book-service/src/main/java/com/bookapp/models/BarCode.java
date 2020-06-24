package com.bookapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@AllArgsConstructor
public class BarCode {
	@Id
	@GeneratedValue(generator = "bar_sequence",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "bar_sequence",sequenceName ="bar_seq" )
	int barId;
	int ISBNnumber; 
	String description; // fiction ,
	public BarCode(int iSBNnumber, String description) {
		super();
		ISBNnumber = iSBNnumber;
		this.description = description;
	}
	
	
}
