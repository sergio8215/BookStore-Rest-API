package com.book.store.xyz.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.book.store.xyz.model.Book;

@Component
public class BookRepresentationModelAssembler implements RepresentationModelAssembler<Book,
	EntityModel<Book>> {

	@Override
	public EntityModel<Book> toModel(Book book) {
	
		return new EntityModel<>(book,
				linkTo(methodOn(BookStoreController.class).one(book.getId())).withSelfRel(),
				linkTo(methodOn(BookStoreController.class).all()).withRel("book"));
	}
}
