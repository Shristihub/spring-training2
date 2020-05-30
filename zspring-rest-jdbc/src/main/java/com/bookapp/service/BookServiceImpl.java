package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.BookDAO;
import com.bookapp.models.Book;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDAO;
	@Override
	public void addBook(Book book) {
		bookDAO.addBook(book);
	}

	@Override
	public Book getById(int bookid) {
		return bookDAO.getById(bookid);
	}

	@Override
	public List<Book> getAll() {
		return bookDAO.getAll();
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		return bookDAO.getBooksByAuthor(author);
	}

	@Override
	public List<Book> getBooksByCategory(String category) {
		return bookDAO.getBooksByCategory(category);
	}

	@Override
	public void updateBook(int bookid, String category) {
		bookDAO.updateBook(bookid, category);
	}

	@Override
	public void deleteBook(int bookid) {
		bookDAO.deleteBook(bookid);
	}

	
	

}
