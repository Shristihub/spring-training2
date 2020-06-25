package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bookapp.models.Book;
import com.bookapp.models.BookDTO;

@RestController
@RequestMapping("/ribbon-api")
public class RibbonController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	String BASEURL="http://ORDER-SERVICE/order-api";
	
	
	@GetMapping(value ="/ribbon-books", produces="application/json")
	public List<Book> findAll() {
		System.out.println("From RIBBON API");
		ServiceInstance instance = loadBalancerClient.choose("ORDER-SERVICE");
		int port = instance.getPort();
		String host = instance.getHost();
		System.out.println("**********");
		System.out.println(host+" "+port);
		System.out.println(instance.getServiceId());
		System.out.println(instance.getUri());
			String url = BASEURL+"/view-books";
		ResponseEntity<List> entity = restTemplate.getForEntity(url,List.class);
		List<Book> bookList = entity.getBody();
		return bookList;
	}
	
	@GetMapping(value="/ribbon-author/{author}", produces = "application/json")
	public List<Book> findByAuthor(@PathVariable String author) {
		System.out.println("From RIBBON API");
		String url = BASEURL+"/view-by-author/"+author;
		ResponseEntity<List> entity = restTemplate.getForEntity(url,List.class);
		List<Book> bookList = (List<Book>) entity.getBody();
		return bookList;
	}
	@GetMapping(value="/ribbon-id/{id}", produces = "application/json")
	public BookDTO findById(@PathVariable("id") int bookid) {
		String url = BASEURL+"/view-by-id/"+bookid;
		ResponseEntity<BookDTO> entity = (ResponseEntity)restTemplate.getForEntity(url,ResponseEntity.class);
		BookDTO book = entity.getBody();
		return book;
	}
	
	
	

}





