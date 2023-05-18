package com.example.apisecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidEmailError extends ResponseStatusException {
    public InvalidEmailError(){
        super(HttpStatus.UNAUTHORIZED, " Invalid Email Error!");
    }
}
