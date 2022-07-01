package com.luciana.crudspring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luciana.crudspring.domain.Category;
import com.luciana.crudspring.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category findById(Integer id) {
        Optional<Category> obj = repository.findById(id);
        return obj.orElse(null);
    }

}
