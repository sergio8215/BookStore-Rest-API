package com.book.store.xyz.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.xyz.exceptions.BookNotFoundException;
import com.book.store.xyz.model.Book;
import com.book.store.xyz.repository.BookRepository;

@RestController
public class BookStoreController {

	private final BookRepository repository;
	private final BookRepresentationModelAssembler assembler;
	
	BookStoreController(BookRepository repository,
			BookRepresentationModelAssembler assembler) {
		this.repository = repository;
		this.assembler = assembler;
	}
	
	// Aggregate root
	
	@GetMapping("/books")
	CollectionModel<EntityModel<Book>> all() {
		
		List<EntityModel<Book>> books = repository.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		
		return new CollectionModel<>(books,
				linkTo(methodOn(BookStoreController.class).all()).withSelfRel());
	}
	
	@PostMapping("books")
	Book newBook(@RequestBody Book newBook) {
		return repository.save(newBook);
	}
	
	// Single item
	
	@GetMapping("/books/{id}")
	EntityModel<Book> one(@PathVariable Long id) {
		
		Book book = repository.findById(id)
				.orElseThrow(() -> new BookNotFoundException(id));
		
		return assembler.toModel(book);
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
	
	@DeleteMapping("/books/{id}")
	void deleteBook(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
