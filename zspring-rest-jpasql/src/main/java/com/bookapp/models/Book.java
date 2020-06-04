package com.bookapp.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
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
	double price;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id")
	private Set<Edition> editions;
	@JoinTable(name="hiberbook_publisher",
			  joinColumns = @JoinColumn(name="book_id"),
			  inverseJoinColumns = @JoinColumn(name="publisher_id")
			)
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Publisher> publisher;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bar_id")// foreign
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

	

}




