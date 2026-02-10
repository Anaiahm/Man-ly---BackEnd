package com.example.demo.dto.auth;

public class AuthResponse {
    private Long userId;
    private String username;
    private String name;

    public AuthResponse(Long userId, String username, String name) {
        this.userId = userId;
        this.username = username;
        this.name = name;
    }

    public Long getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getName() { return name; }
}
