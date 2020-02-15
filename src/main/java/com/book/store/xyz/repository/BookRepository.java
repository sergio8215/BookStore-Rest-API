package com.book.store.xyz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.store.xyz.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
