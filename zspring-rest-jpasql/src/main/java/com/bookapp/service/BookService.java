package com.bookapp.service;

import java.util.List;

import com.bookapp.models.Book;
import com.bookapp.models.BookDTO;

public interface BookService {
		
		void addBook(Book book);
		BookDTO getById(int bookid);
		List<Book> getAll();
		List<Book> getBooksByAuthor(String author);
		List<Book> getBooksByCategory(String category);
		void updateBook(Book book);
		void deleteBook(int bookid);
}
