package com.example.webflux.api.auth.response;

import com.example.webflux.api.auth.dto.JwtTokensDto;
import lombok.Getter;

@Getter
public class SignInResponse {
    private final String accessToken;
    private final String refreshToken;

    public SignInResponse(JwtTokensDto jwtTokensDto) {
        this.accessToken = jwtTokensDto.getAccessToken();
        this.refreshToken = jwtTokensDto.getRefreshToken();
    }
}
