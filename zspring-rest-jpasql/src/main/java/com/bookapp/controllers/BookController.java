package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.models.Book;
import com.bookapp.service.BookService;

@RestController
@RequestMapping("/book-api")
public class BookController {

//	@Autowired
//	BookService bookService;
//	@Autowired
//	ApplicationContext context;
//	
//	@PostMapping("/books")
//	public ResponseEntity<String> addBook(@RequestBody Book book) {
//		bookService.addBook(book);
//		return new ResponseEntity<String>(HttpStatus.OK);
//	}
//	@GetMapping("/books")
//	public List<Book> findAll() {
//		System.out.println("From REST API");
////		String[] beanNames = context.getBeanDefinitionNames(); 
////		for (String bean : beanNames) { System.out.println(bean); }
//		return bookService.getAll();
//	}
//	
//	@GetMapping("/books-by-author/{author}")
//	public List<Book> findByAuthor(@PathVariable("author") String author) {
//		System.out.println("From REST API");
//		return bookService.getBooksByAuthor(author);
//	}
//	@GetMapping("/books-by-category")
//	public List<Book> findByCategory(@RequestParam("category") String category) {
//		return bookService.getBooksByCategory(category);
//	}
//	
//	@GetMapping("/book-by-id/{id}")
//	public Book findById(@PathVariable("id") int bookid) {
//		return bookService.getById(bookid);
//	}
//	
//	@PatchMapping("/books-update/{bookid}/{category}")
//	public ResponseEntity<String> updateBook(@PathVariable Integer bookid,@PathVariable String category) {
//		//bookService.updateBook(bookid, category);
//		return ResponseEntity.ok("updated");
//	}
//	@DeleteMapping("/books-delete/{bookid}")
//	public ResponseEntity<String> deleteBook(@PathVariable int bookid) {
//		bookService.deleteBook(bookid);
//		return ResponseEntity.ok("deleted");
//		
//	}
//	
	

}





