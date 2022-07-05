package com.luciana.crudspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luciana.crudspring.domain.Book;
import com.luciana.crudspring.domain.Category;
import com.luciana.crudspring.repositories.BookRepository;
import com.luciana.crudspring.service.exceptions.ObjectNotFoundException;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryService cat_service;

    public Book findById(Integer id) {
        Optional<Book> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Book not found :("));
    }

    public List<Book> findAll(Integer id_cat) {
        cat_service.findById(id_cat);
        return repository.FindAllByCategory(id_cat);
    }

    public Book update(Integer id, Book obj) {
        Book newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Book newObj, Book obj) {
        newObj.setTitle(obj.getTitle());
        newObj.setAuthor_name(obj.getAuthor_name());
        newObj.setText(obj.getText());
    }

    public Book create(Integer id_cat, Book obj) {
        obj.setId(null);
        Category cat = cat_service.findById(id_cat);
        obj.setCategory(cat);
        return repository.save(obj);
    }

}
