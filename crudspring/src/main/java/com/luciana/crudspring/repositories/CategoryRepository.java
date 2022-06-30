package com.luciana.crudspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luciana.crudspring.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
