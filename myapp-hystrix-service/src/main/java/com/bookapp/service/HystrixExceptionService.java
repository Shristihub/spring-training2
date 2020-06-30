package com.bookapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookapp.models.ApiErrors;
import com.bookapp.models.Book;
import com.bookapp.models.BookDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HystrixExceptionService {

	@Autowired
	RestTemplate restTemplate;
	String BASEURL="http://RIBBON-SERVICE/ribbon-api";
	
	@HystrixCommand(fallbackMethod = "fallbackFindAll")
	public ResponseEntity<List> findAll() {
		String url = BASEURL+"/ribbon-books";
		ResponseEntity<List> response = restTemplate.getForEntity(url,List.class);
		return response;
	}
	@HystrixCommand(fallbackMethod = "fallbackFindByAuthor")
	public ResponseEntity<List> findByAuthor(String author) {
		String url = BASEURL+"/ribbon-author/"+author;
		ResponseEntity<List> response = restTemplate.getForEntity(url,List.class);
		return response;
	}
	@HystrixCommand(fallbackMethod = "fallbackFindById")
	public ResponseEntity<BookDTO> findById(int bookid) {
		String url = BASEURL+"/ribbon-id/"+bookid;
		ResponseEntity<BookDTO> response = restTemplate.getForEntity(url,BookDTO.class);
		return response;
	}
	public ResponseEntity<List> fallbackFindAll(Throwable e){
		String message = e.getMessage();
		List<String> details = Arrays.asList(message);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
	}
	public ResponseEntity<List> fallbackFindByAuthor(String author,Throwable e){
		String message = e.getMessage();
		List<String> details = Arrays.asList(message);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
	}
	public ResponseEntity<BookDTO> fallbackFindById(int bookid,Throwable e) {
		String message = e.getMessage();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BookDTO());

	}
}





