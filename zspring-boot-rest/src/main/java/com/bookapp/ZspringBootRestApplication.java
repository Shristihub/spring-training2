package com.bookapp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.bookapp.models.Book;
import com.bookapp.service.BookService;

@SpringBootApplication
@ComponentScan("com")
public class ZspringBootRestApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ZspringBootRestApplication.class, args);
	}
	
	@Autowired
	BookService bookService;

	@Override
	public void run(String... args) throws Exception {
		
		//collections,List,set,map,Arrays
		
		
//		List<Book> bookList = bookService.getBooksByAuthor("Kathy");
//		for (Book book : bookList) {
//			System.out.println(book);
//		}
//		System.out.println();
//			bookList.forEach((book)-> System.out.println(book));
//			System.out.println();
//		bookService.getBooksByCategory("Fiction")
//		  .forEach(System.out::println);
//		System.out.println();
//		Book book = bookService.getById(12);
//		System.out.println(book);
	
		
	}

}





