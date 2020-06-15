package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.models.Book;
import com.bookapp.models.BookDTO;
import com.bookapp.service.BookService;

@RestController
@RequestMapping("/book-api")
public class BookController {

	@Autowired
	BookService bookService;
	
	@PostMapping("/books")
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		bookService.addBook(book);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	@PatchMapping("/books/{bookid}/{author}")
	public ResponseEntity<String> updatePartBook(@PathVariable Integer bookid,@PathVariable String author) {
		bookService.updatePartBook(bookid, author);
		return ResponseEntity.ok("updated");
	}
	@PutMapping("/books")
	public ResponseEntity<String> updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
		return ResponseEntity.ok("updated");
	}
	@PutMapping("/books/update/{bookid}")
	public ResponseEntity<String> nupdateBook(@PathVariable int bookid, @RequestBody Book book) {
		book.setBookId(bookid);
		bookService.updateBook(book);
		return ResponseEntity.ok("updated");
	}
	@DeleteMapping("/books/{bookid}")
	public ResponseEntity<String> deleteBook(@PathVariable int bookid) {
		bookService.deleteBook(bookid);
		return ResponseEntity.ok("deleted");
		
	}
	@GetMapping("/userbooks")
	public ResponseEntity<List<Book>> findAll() {
		System.out.println("From REST API");
		List<Book> bookList = bookService.getAll();
		return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
	}
	
	@GetMapping("/userbooks/books-by-author/{author}")
	public ResponseEntity<List<Book>> findByAuthor(@PathVariable String author) {
		System.out.println("From REST API");
		List<Book> bookList =  bookService.getBooksByAuthor(author);
		if(bookList.isEmpty()) {
			throw new BookNotFoundException("Author not available");
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "booklist by author");
		headers.add("authcode", "001");
		return new ResponseEntity<List<Book>>(bookList, headers,HttpStatus.OK);
		
		
	}
	@GetMapping("/userbooks/books-by-desc")
	public ResponseEntity<List<Book>> findByDesc(@RequestParam("desc") String desc) {
		List<Book> bookList =  bookService.getBooksBydesc(desc);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "booklist by desc");
		return ResponseEntity.ok().headers(headers).body(bookList);
	}
	
	@GetMapping("/userbooks/book-by-id/{id}")
	public ResponseEntity<BookDTO> findById(@PathVariable("id") int bookid) {
		BookDTO book =  bookService.getById(bookid);
		return ResponseEntity.ok().body(book);
	}
	
	
	//@ExceptionHandler(BookNotFoundException.class)
	public String handleBookNotFoundException(Exception e){
		System.out.println(e.getMessage());
		return e.getMessage();
	}

}





