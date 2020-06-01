package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.service.BookService;

@SpringBootApplication
public class ZspringRestJpasqlApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ZspringRestJpasqlApplication.class, args);
	}

	@Autowired
	BookService bookService;
	@Override
	public void run(String... args) throws Exception {
//		Book book1 = new Book("Spring","Rod","Tech");
//		bookService.addBook(book1);
//		Book book2 = new Book("Captain","Steve","Comic");
//		bookService.addBook(book2);
//		Book book3 = new Book("Geronimo","Jack","Comic");
//		bookService.addBook(book3);
//		Book book4 = new Book("Java","Kathy","Tech");
//		bookService.addBook(book4);
		
//		bookService.getAll().forEach(System.out::println);
//		BookDTO book = bookService.getById(102);
//		System.out.println(book);
//		book.setTitle("Spring Framework");
//		bookService.updateBook(book);
//		book = bookService.getById(200);
//		System.out.println(book);
		
		bookService.getBooksByAuthor("Kathy")
			.forEach(System.out::println);
		bookService.getBooksByCategory("Comic")
		.forEach(System.out::println);
		
	}

}
