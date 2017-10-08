package com.dbbyte.sbspring5framework.repositories;

import com.dbbyte.sbspring5framework.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
