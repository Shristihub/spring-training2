package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bookapp.models.Book;
import com.bookapp.models.BookDTO;
import com.bookapp.service.OrderFeignClient;

@RestController
@RequestMapping("/feign-api")
public class FeignController {

	@Autowired
	OrderFeignClient feignClient;
	
	@GetMapping(value ="/view-books", produces="application/json")
	public List<Book> findAll() {
		return feignClient.findAll();
	}
	
	@GetMapping(value="/view-by-author/{author}", produces = "application/json")
	public List<Book> findByAuthor(@PathVariable String author) {
		List<Book> bookList = feignClient.findByAuthor(author);
		return bookList;
	}

	@GetMapping(value="/view-by-id/{id}", produces = "application/json")
	public BookDTO findById(@PathVariable("id") int bookid) {
		BookDTO book = feignClient.findById(bookid);
		return book;
	}
	
	
	

}





