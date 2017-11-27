package com.bujak.springtraining.repository;

import com.bujak.springtraining.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
