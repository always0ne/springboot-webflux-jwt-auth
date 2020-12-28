package com.example.webflux.api.user.controller;

import com.example.webflux.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.example.webflux.security.JwtTokenProvider.getUserIdFromAuth;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/getmyid")
    @ResponseStatus(HttpStatus.OK)
    Mono<Void> updateUserInfo() {
        // can get userId by this static method
        return getUserIdFromAuth()
                .flatMap(userService::updateUserInfo);
    }
}
