package com.luciana.crudspring.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.luciana.crudspring.domain.Category;

public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "NAME is required")
    @Length(min = 3, max = 100, message = "Name has to be between 3 and 100 characters long")
    private String name;

    @NotEmpty(message = "DESCRIPTION is required")
    @Length(min = 3, max = 200, message = "Description has to be between 3 and 200 characters long")
    private String description;

    public CategoryDTO() {
        super();
    }

    public CategoryDTO(Category obj) {
        super();
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
