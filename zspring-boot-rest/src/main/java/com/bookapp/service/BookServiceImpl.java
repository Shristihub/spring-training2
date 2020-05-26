package com.bookapp.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bookapp.models.Book;
@Service
public class BookServiceImpl implements BookService {

	@Override
	public Book getById(int bookid) {
		return getBookList()
				.stream()
				.filter((book)-> book.getBookid()==bookid)
				.findAny()
				.orElse(new Book());
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		return getBookList()
				.stream()
				.filter((book)->book.getAuthor().equals(author))
				.sorted((b1,b2)->b1.getTitle().compareTo(b2.getTitle()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Book> getBooksByCategory(String category) {
		return getBookList()
				.stream()
				.filter((book)->book.getCategory().equals(category))
				.collect(Collectors.toList());
	}
	
	private List<Book> getBookList(){
		return Arrays.asList(new Book("Java","Kathy","Tech",10),
				new Book("Spring","Rod","Tech",11),
				new Book("Miracle","Kathy","Fiction",12),
				new Book("Ferrari","Robin","Fiction",13),
				new Book("Captain","Hal","Comic",14),
				new Book("Skull Glow","Kumaran","Horror",15));
		
				
				
	}
	

}
