package com.basecamp.springframeworkfinalproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidMachineRequestException extends RuntimeException {

    public InvalidMachineRequestException(String message) {
        super(message);
    }
}
