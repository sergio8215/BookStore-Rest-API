package com.book.store.xyz.book;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class BookRepresentationModelAssembler implements RepresentationModelAssembler<Book,
	EntityModel<Book>> {

	@Override
	public EntityModel<Book> toModel(Book book) {
	
		return new EntityModel<>(book,
				linkTo(methodOn(BookController.class).one(book.getId())).withSelfRel(),
				linkTo(methodOn(BookController.class).all()).withRel("book"));
	}
}
