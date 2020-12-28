package com.example.webflux.api.auth.exception.exceptions;

public class RefreshTokenExpiredException extends RuntimeException {
    public RefreshTokenExpiredException() {
        super("Refresh token is expired");
    }
}
