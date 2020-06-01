package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.dao.BookRepository;
import com.bookapp.models.Book;
import com.bookapp.models.BookDTO;
@Service
@Transactional
public class BookServiceImpl implements BookService {
 
	@Autowired
	BookRepository bookRepository;
	@Override
	public void addBook(Book book) {
		bookRepository.save(book);
		
	}
	@Override
	@Transactional
	public BookDTO getById(int bookid) {
		Book book = bookRepository.getOne(bookid);
		BookDTO book1= new BookDTO(book.getBookId(),book.getTitle(),book.getAuthor(),book.getCategory());
		System.out.println(book1);
		//return bookRepository.findById(bookid).orElse(new Book());
		return book1;
	}

	@Override
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		List<Book> bookList = bookRepository.findByAuthor(author);
		return bookList;
	}

	@Override
	public List<Book> getBooksByCategory(String category) {
		List<Book> bookList = bookRepository.readByCategory(category);
		return bookList;
	}

	@Override
	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(int bookid) {
		bookRepository.deleteById(bookid);
	}

	
	
	

}
