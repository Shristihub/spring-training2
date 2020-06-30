package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookapp.models.Book;
import com.bookapp.models.BookDTO;

@Component
public class OrderFeignClientImpl implements OrderFeignClient{

	@Override//
	public List<Book> findAll() {
		return new ArrayList<>();
	}

	@Override
	public List<Book> findByAuthor(String author) {
		return new ArrayList<>();
	}

	@Override
	public BookDTO findById(int bookid) {
		return new BookDTO();
	}

}
