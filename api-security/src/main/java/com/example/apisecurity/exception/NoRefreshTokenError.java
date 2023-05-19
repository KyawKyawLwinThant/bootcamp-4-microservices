package com.example.apisecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoRefreshTokenError extends ResponseStatusException {

    public NoRefreshTokenError(){
        super(HttpStatus.UNAUTHORIZED,"No Refresh Token!");
    }
}
