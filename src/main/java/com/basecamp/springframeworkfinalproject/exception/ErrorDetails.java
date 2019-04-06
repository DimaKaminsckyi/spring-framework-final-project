package com.basecamp.springframeworkfinalproject.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorDetails {

    private HttpStatus errCode;
    private String errMessage;

    public ErrorDetails(HttpStatus errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }
}
