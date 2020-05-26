package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.models.Book;
import com.bookapp.service.BookService;

@RestController
@RequestMapping("/book-api")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/greet")
	public String greet() {
		return "REST API in Spring";
	}
	@GetMapping("/books-by-author/{author}")
	public List<Book> findByAuthor(@PathVariable("author") String author) {
		return bookService.getBooksByAuthor(author);
	}
	@GetMapping("/books-by-category")
	public List<Book> findByCategory(@RequestParam("category") String category) {
		return bookService.getBooksByCategory(category);
	}
	
	@GetMapping("/book-by-id/{id}/category/{cat}")
	public Book findById(@PathVariable("id") int bookid,@PathVariable("cat") String category) {
		System.out.println(category);
		return bookService.getById(bookid);
	}

}





