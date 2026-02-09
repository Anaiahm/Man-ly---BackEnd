package com.example.demo.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void canCreateUserWithRequiredFields() {
        User user = new User(
                "testuser",
                "test@example.com",
                "password123",
                "Test User",
                null
        );

        assertEquals("testuser", user.getUsername());
        assertEquals("test@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
    }

    @Test
    void userCanHaveProfilePhoto() {
        User user = new User(
                "testuser",
                "test@example.com",
                "password123",
                "Test User",
                null       
        );

        user.setProfilePhotoUrl("https://example.com/photo.jpg");

        assertEquals("https://example.com/photo.jpg", user.getProfilePhotoUrl());
    }

    @Test
    void userDefaultsAreNullWhenOptionalFieldsNotSet() {
        User user = new User(
                "testuser",
                "test@example.com",
                "password123",
                "Test User",
                null   
        );

        assertNull(user.getProfilePhotoUrl());
    }
}
