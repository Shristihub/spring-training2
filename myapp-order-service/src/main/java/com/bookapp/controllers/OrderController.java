package com.bookapp.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bookapp.models.Book;
import com.bookapp.models.BookDTO;

@RestController
@RequestMapping("/order-service")
public class OrderController {

	@Autowired
	RestTemplate restTemplate;
	String BASEURL="http://BOOK-SERVICE/book-api";
	//String BASEURL="http://localhost:8085/book-api";
	
	@GetMapping(value = "/order-hello",produces = "application/json")
	public ResponseEntity<String> sayHello(){
		String url = BASEURL+"/book-hello";
		
		ResponseEntity<String> entity = restTemplate.getForEntity(url,String.class);
		System.out.println(entity.getBody());
		return entity;
	}
	@GetMapping(value = "/order-book",produces="application/json")
	public Book getbook(){
		String url = BASEURL+"/book-one";
		ResponseEntity<Book> entity = restTemplate.getForEntity(url,Book.class);
		System.out.println(entity.getBody());
		return entity.getBody();
	}
	@GetMapping(value="/order-book-data" ,produces="application/json")
	public Book getOnebook(){
		String url = BASEURL+"/book-one";
		Book book = restTemplate.getForObject(url,Book.class);
		System.out.println(book);
		return book;
	}
	@GetMapping(value = "/view-books-list")
	public List<Book> findAllBooks() {
		String url = BASEURL+"/user-books-list";
		List<Book> bookList = restTemplate.getForObject(url,List.class);
		return bookList;
	}
	
	@GetMapping(value ="/view-books", produces="application/json")
	public List<Book> findAll() {
		System.out.println("From REST API");
		String url = BASEURL+"/userbooks";
		
		ResponseEntity<List> entity = restTemplate.getForEntity(url,List.class);
		System.out.println(entity.getBody());
		List<Book> bookList = entity.getBody();
		System.out.println(bookList);
		return bookList;
		
		
	}
	
	@GetMapping(value="/view-by-author/{author}", produces = "application/json")
	public List<Book> findByAuthor(@PathVariable String author) {
		System.out.println("From ORDER SeRVICE");
		String url = BASEURL+"/userbooks/books-by-author/"+author;
		ResponseEntity<List> entity = restTemplate.getForEntity(url,List.class);
		List<Book> bookList = (List<Book>) entity.getBody();
		return bookList;
		
		
	}
	@GetMapping(value="/view-by-desc/{desc}", produces = "application/json")
	public List<Book> findByDesc(@PathVariable("desc") String description) {
		String url = BASEURL+"/userbooks/books-by-desc/?desc="+description;
		ResponseEntity<List<Book>> entity = (ResponseEntity)restTemplate.getForEntity(url,ResponseEntity.class);
		List<Book> bookList = entity.getBody();
		return bookList;
	}
	
	@GetMapping(value="/view-by-id/{id}", produces = "application/json")
	public BookDTO findById(@PathVariable("id") int bookid) {
		String url = BASEURL+"/userbooks/book-by-id/"+bookid;
		ResponseEntity<BookDTO> entity = (ResponseEntity)restTemplate.getForEntity(url,ResponseEntity.class);
		BookDTO book = entity.getBody();
		return book;
	}
	
	
	//@ExceptionHandler(BookNotFoundException.class)
	public String handleBookNotFoundException(Exception e){
		System.out.println(e.getMessage());
		return e.getMessage();
	}

}





