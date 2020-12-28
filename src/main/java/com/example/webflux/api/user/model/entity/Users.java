package com.example.webflux.api.user.model.entity;

import com.example.webflux.api.auth.model.Account;
import com.example.webflux.api.auth.model.UserRole;
import com.example.webflux.api.auth.model.UserStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
public class Users extends Account {

    public Users(String userId, String password, String email, UserStatus state,
                 List<UserRole> roles, String refreshToken) {
        super(userId, password, email, state, roles, refreshToken);
    }

    public Users(String userId, String password, String email) {
        super(userId, password, email, UserStatus.NORMAL, Collections.singletonList(UserRole.ROLE_USER), null);
    }

}
