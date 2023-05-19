package com.example.apisecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class LinkedError extends ResponseStatusException {
    public LinkedError(){
        super(HttpStatus.UNAUTHORIZED,"Token Linked Error!");
    }
}
