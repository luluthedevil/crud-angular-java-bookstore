package com.luciana.crudspring.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.luciana.crudspring.domain.Book;
import com.luciana.crudspring.domain.Category;
import com.luciana.crudspring.repositories.BookRepository;
import com.luciana.crudspring.repositories.CategoryRepository;

@Service
public class DBService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    public void dataBaseInstance() {
        Category cat1 = new Category(null, "IT", "IT books");
        Category cat2 = new Category(null, "Science fiction", "Science fiction");
        Category cat3 = new Category(null, "Bibliographies", "Bibliographies books");

        Book l1 = new Book(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
        Book l2 = new Book(null, "Software Engenieer", "Louis V. Gerstner", "Lorem ipsum", cat1);
        Book l3 = new Book(null, "The Time Machine", "H.G. Wells", "Lorem ipsum", cat2);
        Book l4 = new Book(null, "The War of the Worlds", "H.G. Wells", "Lorem ipsum", cat2);
        Book l5 = new Book(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", cat2);

        cat1.getBooks().addAll(Arrays.asList(l1, l2));
        cat2.getBooks().addAll(Arrays.asList(l3, l4, l5));

        this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.bookRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
    }
}
