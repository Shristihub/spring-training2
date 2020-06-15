package com.bookapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.models.BarCode;
import com.bookapp.models.Book;
import com.bookapp.models.Edition;
import com.bookapp.models.Publisher;
import com.bookapp.service.BookService;
import com.bookapp.service.PublisherService;

@SpringBootApplication
public class ZspringRestJpasqlApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ZspringRestJpasqlApplication.class, args);
	}

	@Autowired
	BookService bookService;
	@Autowired
	PublisherService publisherService;
	@Override
	public void run(String... args) throws Exception {
//		BarCode bc1 = new BarCode(12346,"Fiction");
//		Edition edit1 = new Edition(300,1);
//		Edition edit2 = new Edition(400,2);
//		Set<Edition> allEditions = new HashSet<>(Arrays.asList(edit1,edit2));
//		Publisher pub1 = new Publisher("Frank");
//		Publisher pub2 = new Publisher("Covey");
//		Set<Publisher> pubList = new HashSet<>(Arrays.asList(pub1,pub2));
////		
//		Book book1 = new Book("Node JS", "Kathy", 900, allEditions, pubList, bc1);
//		bookService.addBook(book1);
//		bookService.getAll().forEach(System.out::println);
//		
//		BarCode bc2 = new BarCode(12345,"Horror");
//		Edition edit3 = new Edition(300,1);
//		Edition edit4 = new Edition(400,2);
//		Set<Edition> allEditions1 = new HashSet<>(Arrays.asList(edit3,edit4));
//		Publisher publ1 = publisherService.getById(1);
//		Set<Publisher> pubList1 = new HashSet<>(Arrays.asList(publ1));
//		
//		Book book2 = new Book("Night Horror", "Sam", 900, allEditions1, pubList1, bc2);
//		bookService.addBook(book2);
		
//		System.out.println();
////		bookService.getBooksBydesc("Horror")
////		.forEach((book)->System.out.println(book.getTitle()+" "+book.getAuthor()+" "
////		         +book.getPublisher()));
//		bookService.getByPublisherAndDesc("Arihand", "Horror")
//		.forEach((book)->System.out.println(book.getTitle()+" "+book.getAuthor()));
//		
//		
	}

}
