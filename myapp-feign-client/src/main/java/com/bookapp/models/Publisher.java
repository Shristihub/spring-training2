package com.bookapp.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Publisher {
	private Integer publisherId;
	private String publisherName;
	@JsonIgnore
	private Set<Book> bookList;
	public Publisher(String publisherName) {
		super();
		this.publisherName = publisherName;
	}
	@Override
	public String toString() {
		return "Publisher [publisherName=" + publisherName + "]";
	}
	
}
