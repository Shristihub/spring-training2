package com.bookapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Edition {

	private Integer editionId;
	private Integer totalCopies;
	private Integer editionNumber;
	@JsonIgnore
	private Book book; // many editions for one book
	
	
	public Edition(Integer totalCopies, Integer editionNumber) {
		super();
		this.totalCopies = totalCopies;
		this.editionNumber = editionNumber;
	}
	@Override
	public String toString() {
		return "Edition [totalCopies=" + totalCopies + ", editionNumber=" + editionNumber + "]";
	}
	
	
}
