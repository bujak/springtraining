package com.bujak.springtraining.repository;

import com.bujak.springtraining.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>{
}
