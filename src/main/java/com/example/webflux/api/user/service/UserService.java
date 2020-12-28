package com.example.webflux.api.user.service;

import com.example.webflux.api.auth.exception.exceptions.CantSignInException;
import com.example.webflux.api.auth.model.UserStatus;
import com.example.webflux.api.user.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Mono<Void> updateUserInfo(String requestUserId) {
        return  Mono.fromCallable(() -> userRepository.findByUserIdAndState(requestUserId, UserStatus.NORMAL))
                .subscribeOn(Schedulers.elastic())
                .switchIfEmpty(Mono.error(CantSignInException::new))
                // Code Update Logic
                .then();
    }
}
