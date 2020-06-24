package com.bookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.PublisherRepository;
import com.bookapp.models.Publisher;
@Service
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	PublisherRepository publisherRepository;
	@Override
	public Publisher getById(int pubId) {
		return publisherRepository
				.findById(pubId)
				.orElse(new Publisher());
	}

}
