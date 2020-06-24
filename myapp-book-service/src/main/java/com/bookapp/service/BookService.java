package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.models.Book;
import com.bookapp.models.BookDTO;

public interface BookService {
		
		void addBook(Book book);
		BookDTO getById(int bookid) throws IdNotFoundException;;
		List<Book> getAll();
		List<Book> getBooksByAuthor(String author) throws BookNotFoundException;
		List<Book> getBooksBydesc(String desc)throws BookNotFoundException;;
		void updatePartBook(int bookid, String author)throws IdNotFoundException;;
		void updateBook(Book book)throws IdNotFoundException;;
		void deleteBook(int bookid)throws IdNotFoundException;;
		List<Book> getByPublisherAndDesc(String pub,String desc)throws BookNotFoundException;;
}
