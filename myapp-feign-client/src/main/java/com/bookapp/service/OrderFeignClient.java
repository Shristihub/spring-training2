package com.bookapp.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bookapp.models.Book;
import com.bookapp.models.BookDTO;

@FeignClient(name = "order-service",fallback = OrderFeignClientImpl.class)
public interface OrderFeignClient {
   
	@GetMapping(value ="/order-api/view-books", produces="application/json")
	public List<Book> findAll() ;
	
	@GetMapping(value="/order-api/view-by-author/{author}", produces = "application/json")
	public List<Book> findByAuthor(@PathVariable String author) ;
	 
	@GetMapping(value="/order-api/view-by-id/{id}", produces = "application/json")
	public BookDTO findById(@PathVariable("id") int bookid);
}

