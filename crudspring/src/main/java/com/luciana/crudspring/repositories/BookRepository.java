package com.luciana.crudspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luciana.crudspring.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
