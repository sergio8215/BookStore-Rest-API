package main.java.com.book.store.xyz;

public class BookNotFoundException extends Exception {
	
	private static final long serialVersionUID = -2218344590773979743L;

	public BookNotFoundException (long id) {
		System.err.println("Book with the id: " + id + " not found.");
	}	
}
