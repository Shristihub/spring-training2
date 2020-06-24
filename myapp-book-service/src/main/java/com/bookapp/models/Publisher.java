package com.bookapp.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Publisher {
	@Id
	@GeneratedValue(generator = "pub_sequence",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "pub_sequence",sequenceName ="pub_seq" )
	private Integer publisherId;
	private String publisherName;
	@ManyToMany(mappedBy = "publisher")
	@JsonIgnore
	private Set<Book> bookList;
	public Publisher(String publisherName) {
		super();
		this.publisherName = publisherName;
	}
	@Override
	public String toString() {
		return "Publisher [publisherName=" + publisherName + "]";
	}
	
}
