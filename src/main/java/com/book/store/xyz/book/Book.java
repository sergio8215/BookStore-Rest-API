package com.book.store.xyz.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Book {

	private @Id @GeneratedValue long id;
	private long isbn;
	private String name;
	private String author;
	//private ArrayList<Category> categories;
	//private User user; // User who added the book
	
	Book ()	{}

	/**
	 * @param id
	 * @param isbn
	 * @param name
	 * @param author
	 * @param categories
	 */
	public Book(long isbn, String name, String author) {
		
		this.isbn = isbn;
		this.name = name;
		this.author = author;
	}
}
