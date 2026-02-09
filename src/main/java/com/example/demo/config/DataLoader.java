package com.example.demo.config;

import com.example.demo.models.Provider;
import com.example.demo.models.ProviderCategory;
import com.example.demo.models.User;
import com.example.demo.repositories.ProviderRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProviderRepository providerRepository;
    private final UserRepository userRepository;

    public DataLoader(ProviderRepository providerRepository, UserRepository userRepository) {
        this.providerRepository = providerRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        System.out.println("DataLoader running...");
        System.out.println("Current provider count: " + providerRepository.count());

        seedProvidersIfEmpty();
        User demoUser = seedDemoUserIfMissing();
        seedCareTeamIfEmpty(demoUser);

        System.out.println("DataLoader finished. Final provider count: " + providerRepository.count());
    }

    private void seedProvidersIfEmpty() {
        if (providerRepository.count() > 0) return;

        List<Provider> providers = List.of(
                new Provider("Dr. Alana Smith", "Therapist", "Trauma-informed therapy and coping strategies.", ProviderCategory.MENTAL_HEALTH),
                new Provider("Marcus Reed", "Career Coach", "Resume, interviewing, and career planning.", ProviderCategory.MENTORSHIP_CAREER),
                new Provider("Nina Patel", "Financial Mentor", "Budgeting basics and debt payoff guidance.", ProviderCategory.MENTORSHIP_FINANCIAL),
                new Provider("Tanya Brooks", "Family Mentor", "Family dynamics, communication, boundaries.", ProviderCategory.MENTORSHIP_FAMILY),
                new Provider("Jordan Lee", "Personal Mentor", "Accountability, routines, personal growth.", ProviderCategory.MENTORSHIP_PERSONAL)
        );

        providerRepository.saveAll(providers);
    }

    private User seedDemoUserIfMissing() {
        return userRepository.findByUsername("demo")
                .orElseGet(() -> userRepository.save(
                        new User(
                                "demo",
                                "demo@example.com",
                                "password123", // MVP only (we'll hash later when you add auth)
                                "Demo User",
                                null
                        )
                ));
    }

    private void seedCareTeamIfEmpty(User user) {
        // Refresh the managed instance (safe when dealing with JPA + relationships)
        User managedUser = userRepository.findById(user.getId()).orElseThrow();

        if (!managedUser.getCareTeam().isEmpty()) return;

        List<Provider> allProviders = providerRepository.findAll();

        // Pick 1-3 providers (MVP requirement). Here we add up to 3.
        int limit = Math.min(3, allProviders.size());
        for (int i = 0; i < limit; i++) {
            managedUser.addProviderToCareTeam(allProviders.get(i));
        }

        userRepository.save(managedUser);
    }
}

