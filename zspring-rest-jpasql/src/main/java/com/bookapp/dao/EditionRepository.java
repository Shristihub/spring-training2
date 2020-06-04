package com.bookapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.models.Edition;

@Repository
public interface EditionRepository extends JpaRepository<Edition, Integer>{ 
		
}





