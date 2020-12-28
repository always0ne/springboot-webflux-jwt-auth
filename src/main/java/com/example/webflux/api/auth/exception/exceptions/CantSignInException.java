package com.example.webflux.api.auth.exception.exceptions;

public class CantSignInException extends RuntimeException {
    public CantSignInException() {
        super("Sign-in Failed");
    }
}
