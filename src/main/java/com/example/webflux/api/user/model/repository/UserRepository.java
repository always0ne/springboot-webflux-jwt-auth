package com.example.webflux.api.user.model.repository;

import com.example.webflux.api.auth.model.UserStatus;
import com.example.webflux.api.user.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUserIdAndState(String userId, UserStatus state);
}
