package com.luciana.crudspring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luciana.crudspring.domain.Book;
import com.luciana.crudspring.domain.Category;
import com.luciana.crudspring.repositories.BookRepository;
import com.luciana.crudspring.repositories.CategoryRepository;

@SpringBootApplication
public class CrudspringApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudspringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Tech", "IT book");

		Book book1 = new Book(null, "Clean code", "Robert", "Lorem ipsum", cat1);

		cat1.getBooks().addAll(Arrays.asList(book1));

		this.categoryRepository.saveAll(Arrays.asList(cat1));
		this.bookRepository.saveAll(Arrays.asList(book1));
	}

}
