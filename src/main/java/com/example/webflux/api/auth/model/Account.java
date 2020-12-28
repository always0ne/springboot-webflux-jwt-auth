package com.example.webflux.api.auth.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Getter
@NoArgsConstructor
@MappedSuperclass
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;

    @Column(unique = true)
    private String userId;
    private String password;
    private String email;

    private UserStatus state;
    private String refreshToken;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<UserRole> roles;

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Account(String userId, String password, String email, UserStatus state, List<UserRole> roles, String refreshToken) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.state = state;
        this.refreshToken = refreshToken;
        this.roles = roles;
    }
}
