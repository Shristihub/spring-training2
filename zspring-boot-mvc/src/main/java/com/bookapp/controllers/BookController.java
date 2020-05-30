package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.bookapp.models.Book;
import com.bookapp.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	@Autowired
	RestTemplate restTemplate;
	
	
	  @GetMapping("/")
	  public String home(Model model) {
		  List<Book> bookList = bookService.getAll();
		  model.addAttribute("bookList",bookList);
		  return "home";
	  }
	  // same mvc
	  @GetMapping("/search-by-category")
	  public String search(@RequestParam("category")String category,Model model) {
		  List<Book> bookList = bookService.getBooksByCategory(category);
		  model.addAttribute("bookList",bookList);
		  return "home";
	  }
	  // call to rest api
	  @GetMapping("/search-by-author")
	  public String searchByAuthor(@RequestParam("author")String author,Model model) {
		  String url = "http://localhost:8081/book-api/books-by-author/"+author;
		  List<Book> bookList = restTemplate.getForObject(url,List.class);
		  
		  model.addAttribute("bookList",bookList);
		  return "home";
	  }
 
	  
	  
	  
}
