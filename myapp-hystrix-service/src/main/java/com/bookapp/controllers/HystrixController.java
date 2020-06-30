package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.models.Book;
import com.bookapp.models.BookDTO;
import com.bookapp.service.HystrixFaultService;

//@RestController
//@RequestMapping("/hystrix-api")
public class HystrixController {

	@Autowired
	HystrixFaultService hystrixFaultService;
	
	@GetMapping(value ="/hystrix-books", produces="application/json")
	public List<Book> findAll() {
		List<Book> bookList = hystrixFaultService.findAll();
		return bookList;
	}
	
	@GetMapping(value="/hystrix-author/{author}", produces = "application/json")
	public List<Book> findByAuthor(@PathVariable String author) {
		List<Book> bookList = hystrixFaultService.findByAuthor(author);
		return bookList;
	}

	
	@GetMapping(value="/hystrix-id/{id}", produces = "application/json")
	public BookDTO findById(@PathVariable("id") int bookid) {
		BookDTO book = hystrixFaultService.findById(bookid);
		return book;
	}
	
	
	

}





