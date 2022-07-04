package com.luciana.crudspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luciana.crudspring.domain.Category;
import com.luciana.crudspring.repositories.CategoryRepository;
import com.luciana.crudspring.service.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category findById(Integer id) {
        Optional<Category> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found :("));
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category create(Category obj) {
        obj.setId(null);
        return repository.save(obj);
    }

}