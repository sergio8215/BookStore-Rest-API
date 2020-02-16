package com.book.store.xyz.book.exceptions;

public class BookNotFoundException extends RuntimeException  {

	private static final long serialVersionUID = 7916266717714589201L;

	public BookNotFoundException (long id) {
		super("Book with the id: " + id + " not found.");
	}	
}
