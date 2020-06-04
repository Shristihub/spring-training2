package com.bookapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Edition {

	@Id
	@GeneratedValue(generator = "edit_sequence",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "edit_sequence",sequenceName ="edition_seq" )
	private Integer editionId;
	private Integer totalCopies;
	private Integer editionNumber;
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book; // many editions for one book
	
	
	public Edition(Integer totalCopies, Integer editionNumber) {
		super();
		this.totalCopies = totalCopies;
		this.editionNumber = editionNumber;
	}
	@Override
	public String toString() {
		return "Edition [totalCopies=" + totalCopies + ", editionNumber=" + editionNumber + "]";
	}
	
	
}
