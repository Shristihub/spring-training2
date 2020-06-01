package com.bookapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "hiberbook")
public class Book {
	@Id
	@GeneratedValue(generator = "book_sequence",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "book_sequence",sequenceName ="book_seq" )
	private Integer bookId;
	private String title;
	@Column(name="author_name")
	private String author;
	@Column(name="category_name")
	private String category;
	public Book(String title, String author, String category) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
	}
	

	
	

}




