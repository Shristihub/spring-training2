package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.models.Book;
import com.bookapp.models.BookDTO;
import com.bookapp.service.HystrixExceptionService;

@RestController
@RequestMapping("/hystrix-api")
public class HystrixExceptionController {

	@Autowired
	HystrixExceptionService hystrixExceptionService;
	
	@GetMapping(value ="/hystrix-books", produces="application/json")
	public List<Book> findAll() {
		ResponseEntity<List> response = hystrixExceptionService.findAll();
		return response.getBody();
	}
	
	@GetMapping(value="/hystrix-author/{author}", produces = "application/json")
	public List<Book> findByAuthor(@PathVariable String author) {
		ResponseEntity<List> response = hystrixExceptionService.findByAuthor(author);
		return response.getBody();
	}

	
	@GetMapping(value="/hystrix-id/{id}", produces = "application/json")
	public BookDTO findById(@PathVariable("id") int bookid) {
		ResponseEntity<BookDTO> response= hystrixExceptionService.findById(bookid);
		return response.getBody();
	}
	
	
	

}





