package com.example.webflux.api.auth.controller;

import com.example.webflux.api.auth.request.RefreshAccessTokenRequest;
import com.example.webflux.api.auth.request.SignInRequest;
import com.example.webflux.api.auth.request.SignUpRequest;
import com.example.webflux.api.auth.response.RefreshAccessTokenResponse;
import com.example.webflux.api.auth.response.SignInResponse;
import com.example.webflux.api.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    Mono<SignInResponse> signIn(
            @Valid @RequestBody SignInRequest signInRequest
    ) {
        return authService.signIn(signInRequest.getUserId(), signInRequest.getPassword())
                .map(SignInResponse::new);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    Mono<Void> signUp(
            @Valid @RequestBody SignUpRequest signUpRequest
    ) {
        return authService.signUp(
                signUpRequest.getUserId(),
                signUpRequest.getPassword(),
                signUpRequest.getEmail()
        );
    }

    @PostMapping("/refresh")
    @ResponseStatus(HttpStatus.OK)
    Mono<RefreshAccessTokenResponse> refreshAccessToken(
            @Valid @RequestBody RefreshAccessTokenRequest refreshAccessTokenRequest
    ) {
        return authService.refreshAccessToken(
                refreshAccessTokenRequest.getAccessToken(),
                refreshAccessTokenRequest.getRefreshToken()
        )
                .map(RefreshAccessTokenResponse::new);
    }
}
