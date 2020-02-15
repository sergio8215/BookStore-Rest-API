package main.java.com.book.store.xyz;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookStoreController {

	private final BookRepository repository;
	
	BookStoreController(BookRepository repository) {
		this.repository = repository;
	}
	
	// Aggregate root
	
	@GetMapping("/books")
	List<Book> all() {
		return repository.findAll();
	}
	
	@PostMapping("books")
	Book newBook(@RequestBody Book newBook) {
		return repository.save(newBook);
	}
	
	// Single item
	
	@GetMapping("/books/{id}")
	Book one(@PathVariable Long id) throws BookNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new BookNotFoundException(id));
	}
	
	@PutMapping("/books/{id}")
	Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {
		
		return repository.findById(id)
				.map(book -> {
					book.setName(newBook.getName());
					book.setIsbn(newBook.getIsbn());
					book.setAuthor(newBook.getAuthor());
					return repository.save(book);
				})
				.orElseGet(() -> {
					newBook.setId(id);
					return repository.save(newBook);
				});
	}
}
