package com.example.webflux.api.auth.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RefreshAccessTokenResponse {
    private final String accessToken;
}
