package com.luciana.crudspring.DTO;

import java.io.Serializable;

import com.luciana.crudspring.domain.Book;

public class BookDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;

    public BookDTO() {
        super();
    }

    public BookDTO(Book obj) {
        super();
        this.id = obj.getId();
        this.title = obj.getTitle();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
