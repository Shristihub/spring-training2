package com.bookapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{ 
		
	// derived queries
	
	List<Book> findByAuthor(String author);
	//List<Book> findByBarcodeDescription(String description);
	

	//  JPQL
//	 @Query("FROM Book b INNER JOIN b.barcode bc WHERE bc.description=?1")
//	 List<Book> findByDesc(String desc);
	
	
	@Query(value = "select * from HIBERBOOK b inner join "
			+ "bar_code bc on b.bar_id= bc.bar_id where bc.description=?1",nativeQuery = true)
	List<Book> findByDesc(String desc);
//	
}





