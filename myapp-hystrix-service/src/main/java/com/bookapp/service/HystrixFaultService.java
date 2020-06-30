package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookapp.models.Book;
import com.bookapp.models.BookDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

//@Service
public class HystrixFaultService {

	@Autowired
	RestTemplate restTemplate;
	String BASEURL="http://RIBBON-SERVICE/ribbon-api";
	
	@HystrixCommand(fallbackMethod = "fallbackFindAll")
	public List<Book> findAll() {
		String url = BASEURL+"/ribbon-books";
		ResponseEntity<List> entity = restTemplate.getForEntity(url,List.class);
		List<Book> bookList = entity.getBody();
		return bookList;
	}
	public List<Book> fallbackFindAll(){
		return new ArrayList<>();
	}
	@HystrixCommand(fallbackMethod = "fallbackFindByAuthor")
	public List<Book> findByAuthor(String author) {
		String url = BASEURL+"/ribbon-author/"+author;
		ResponseEntity<List> entity = restTemplate.getForEntity(url,List.class);
		List<Book> bookList = (List<Book>) entity.getBody();
		return bookList;
	}
	public List<Book> fallbackFindByAuthor(String author){
		return new ArrayList<>();
	}
	@HystrixCommand(fallbackMethod = "fallbackFindById")
	public BookDTO findById(int bookid) {
		String url = BASEURL+"/ribbon-id/"+bookid;
		ResponseEntity<BookDTO> entity = restTemplate.getForEntity(url,BookDTO.class);
		BookDTO book = entity.getBody();
		return book;
	}
	
	public BookDTO fallbackFindById(int bookid) {
		return new BookDTO();
	}
}





