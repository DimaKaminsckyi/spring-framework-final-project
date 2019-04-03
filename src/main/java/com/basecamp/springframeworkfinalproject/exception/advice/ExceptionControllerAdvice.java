package com.basecamp.springframeworkfinalproject.exception.advice;

import com.basecamp.springframeworkfinalproject.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ErrorDetails> personNotFoundException(PersonNotFoundException ex) {
        ErrorDetails exception = new ErrorDetails(404, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }

    @ExceptionHandler(InvalidStateException.class)
    public ResponseEntity<ErrorDetails> invalidStateException(InvalidStateException ex) {
        ErrorDetails exception = new ErrorDetails(400, ex.getMessage());
        return ResponseEntity.badRequest().body(exception);
    }

    @ExceptionHandler(PersonDoesNotHaveStarshipOrVehicleException.class)
    public ResponseEntity<ErrorDetails> personDoesNotHaveMachineException(PersonDoesNotHaveStarshipOrVehicleException ex) {
        ErrorDetails exception = new ErrorDetails(404, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }

    @ExceptionHandler(InvalidMachineRequestException.class)
    public ResponseEntity<ErrorDetails> invalidMachineRequestException(InvalidMachineRequestException ex) {
        ErrorDetails exception = new ErrorDetails(400, ex.getMessage());
        return ResponseEntity.badRequest().body(exception);
    }
}
