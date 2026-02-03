package com.example.demo.repositories;

import com.example.demo.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        // Hardcoded users for MVP
        users.add(new User("testuser", "test@example.com", "password123", "Test User", "https://example.com/photo.jpg"));
        users.add(new User("jane", "jane@example.com", "securepass", "Jane Doe", "https://example.com/jane.jpg"));
    }

    public List<User> findAll() {
        return users;
    }

    public Optional<User> findByUsername(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username)).findFirst();
    }

    public void save(User user) {
        users.add(user);
    }
}
