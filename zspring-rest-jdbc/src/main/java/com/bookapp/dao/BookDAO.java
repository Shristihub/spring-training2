package com.bookapp.dao;

import java.util.List;

import com.bookapp.models.Book;

public interface BookDAO {
		
	void addBook(Book book);
		Book getById(int bookid);
		List<Book> getAll();
		List<Book> getBooksByAuthor(String author);
		List<Book> getBooksByCategory(String category);
		void updateBook(Integer bookid,String category);
		void deleteBook(Integer bookid);
}
