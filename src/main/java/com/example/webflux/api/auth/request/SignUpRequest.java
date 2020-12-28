package com.example.webflux.api.auth.request;

import com.sun.istack.NotNull;
import lombok.Getter;

import javax.validation.constraints.Email;

@Getter
public class SignUpRequest {
    @NotNull
    private String userId;
    @NotNull
    private String password;
    @NotNull
    @Email
    private String email;
}
