package com.example.webflux.api.auth.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class RefreshAccessTokenRequest {
    @NotNull
    private String accessToken;
    @NotNull
    private String refreshToken;
}
