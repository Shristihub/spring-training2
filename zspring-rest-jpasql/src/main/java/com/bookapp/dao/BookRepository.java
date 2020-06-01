package com.bookapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{ 
		
	// derived queries
	
	List<Book> findByAuthor(String author);
	List<Book> readByCategory(String category);
}
