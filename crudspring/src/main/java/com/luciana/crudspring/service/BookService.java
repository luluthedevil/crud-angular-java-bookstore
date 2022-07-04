package com.luciana.crudspring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luciana.crudspring.domain.Book;
import com.luciana.crudspring.repositories.BookRepository;
import com.luciana.crudspring.service.exceptions.ObjectNotFoundException;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book findById(Integer id) {
        Optional<Book> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Book not found :("));
    }

}
