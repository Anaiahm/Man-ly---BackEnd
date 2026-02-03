package com.example.demo.models;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserCareTeamTest {

    @Test
    void testAddProviderToCareTeam() {
        User user = new User("jdoe", "jdoe@example.com", "password123", "John Doe", null);

        Provider provider1 = new Provider("Dr. Smith", "Therapist", "Experienced therapist", ProviderCategory.MENTAL_HEALTH);
        Provider provider2 = new Provider("Jane Mentor", "Career Coach", "Helps with careers", ProviderCategory.MENTORSHIP_CAREER);

        user.addProviderToCareTeam(provider1);
        user.addProviderToCareTeam(provider2);

        Set<Provider> careTeam = user.getCareTeam();
        assertEquals(2, careTeam.size());
        assertTrue(careTeam.contains(provider1));
        assertTrue(careTeam.contains(provider2));
    }

    @Test
    void testRemoveProviderFromCareTeam() {
        User user = new User("jdoe", "jdoe@example.com", "password123", "John Doe", null);

        Provider provider1 = new Provider("Dr. Smith", "Therapist", "Experienced therapist", ProviderCategory.MENTAL_HEALTH);
        Provider provider2 = new Provider("Jane Mentor", "Career Coach", "Helps with careers", ProviderCategory.MENTORSHIP_CAREER);

        user.addProviderToCareTeam(provider1);
        user.addProviderToCareTeam(provider2);

        // Remove one provider
        user.removeProviderFromCareTeam(provider1);

        Set<Provider> careTeam = user.getCareTeam();
        assertEquals(1, careTeam.size());
        assertFalse(careTeam.contains(provider1));
        assertTrue(careTeam.contains(provider2));
    }

    @Test
    void testCareTeamInitiallyEmpty() {
        User user = new User("jdoe", "jdoe@example.com", "password123", "John Doe", null);
        assertTrue(user.getCareTeam().isEmpty());
    }
}
