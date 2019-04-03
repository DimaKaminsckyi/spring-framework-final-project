package com.basecamp.springframeworkfinalproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UuidResultNotFoundException extends RuntimeException {

    public UuidResultNotFoundException(String message) {
        super(message);
    }
}
