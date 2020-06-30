package com.bookapp.models;

import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonDeserialize
public class Book {
	private Integer bookId;
	private String title;
	private String author;
	double price;
	
	private Set<Edition> editions;
	private Set<Publisher> publisher;
	private BarCode barcode;
	
	public Book(String title, String author, double price, Set<Edition> editions, Set<Publisher> publisher,
			BarCode barcode) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.editions = editions;
		this.publisher = publisher;
		this.barcode = barcode;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + ", editions=" + editions
				+ ", publisher=" + publisher + ", barcode=" + barcode + "]";
	}

	public Book(Integer bookId, String title, String author, double price) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public Book(String title) {
		super();
		this.title = title;
	}

	

}




