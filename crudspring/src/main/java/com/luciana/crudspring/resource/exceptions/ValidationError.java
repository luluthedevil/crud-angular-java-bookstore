package com.luciana.crudspring.resource.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldError> errors = new ArrayList<>();

    public ValidationError() {
        super();
    }

    public ValidationError(Long timestanp, Integer status, String error) {
        super(timestanp, status, error);
    }

    public List<FieldError> getErrors() {
        return this.errors;
    }

    public void addErrors(String fieldName, String message) {
        this.errors.add(new FieldError(fieldName, message));
    }

}
