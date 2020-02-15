package main.java.com.book.store.xyz.exceptions;

public class BookNotFoundException extends RuntimeException  {

	public BookNotFoundException (long id) {
		super("Book with the id: " + id + " not found.");
	}	
}
