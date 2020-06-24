package com.bookapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.models.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer>{ 
		
}





