package com.example.webflux.api.auth.exception;

import com.example.webflux.api.auth.exception.exceptions.CantSignInException;
import com.example.webflux.api.auth.exception.exceptions.RefreshTokenExpiredException;
import com.example.webflux.common.response.ErrorResponse;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthExceptionHandler {
    @ExceptionHandler(RefreshTokenExpiredException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorResponse handleExpiredRefreshToken(RefreshTokenExpiredException exception) {
        return new ErrorResponse(HttpStatus.FORBIDDEN, "0004", exception.getMessage());
    }

    @ExceptionHandler(SignatureException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorResponse handleSignatureException() {
        return new ErrorResponse(HttpStatus.FORBIDDEN, "0005", "Invalid Token");
    }

    @ExceptionHandler(MalformedJwtException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorResponse handleMalformedJwt() {
        return new ErrorResponse(HttpStatus.FORBIDDEN, "0006", "Corrupted Token");
    }

    @ExceptionHandler(CantSignInException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorResponse handleCantSignIn(CantSignInException exception) {
        return new ErrorResponse(HttpStatus.FORBIDDEN, "0007", exception.getMessage());
    }
}
