package com.example.webflux.api.auth.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class SignInRequest {
    @NotNull
    private String userId;
    @NotNull
    private String password;
}
