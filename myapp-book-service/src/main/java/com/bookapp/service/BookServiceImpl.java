package com.bookapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.dao.BookRepository;
import com.bookapp.exception.BookNotFoundException;
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
		Optional<Book> optional = bookRepository.findById(bookid);
		if(optional.isPresent()) {		
			Book book = optional.get();
			BookDTO book1= new BookDTO(book.getBookId(),book.getTitle(),book.getAuthor());
			return book1;
		}else {
			throw new BookNotFoundException("Invalid Id");
		}
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
	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(int bookid) {
		bookRepository.deleteById(bookid);
	}
	@Override
	public List<Book> getBooksBydesc(String desc) {
		//return bookRepository.findByBarcodeDescription(desc);
		return bookRepository.findByDesc(desc);
	}
	@Override
	public void updatePartBook(int bookid, String author) {
		bookRepository.updatePartBook(bookid,author);
		
	}
	@Override
	public List<Book> getByPublisherAndDesc(String pub, String desc) {
		return bookRepository.getByPubAndDesc(pub,desc);
	}

	
	
	

}
