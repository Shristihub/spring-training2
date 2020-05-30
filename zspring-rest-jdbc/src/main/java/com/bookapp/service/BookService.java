package com.bookapp.service;

import java.util.List;

import com.bookapp.models.Book;

public interface BookService {
		
		void addBook(Book book);
		Book getById(int bookid);
		List<Book> getAll();
		List<Book> getBooksByAuthor(String author);
		List<Book> getBooksByCategory(String category);
		void updateBook(int bookid,String category);
		void deleteBook(int bookid);
}
