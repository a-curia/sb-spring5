package com.dbbyte.sbspring5framework.repositories;

import com.dbbyte.sbspring5framework.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}