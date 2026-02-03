package com.example.demo.repositories;

import com.example.demo.models.Provider;
import com.example.demo.models.ProviderCategory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProviderRepository {

    private final List<Provider> providers = new ArrayList<>();

    public ProviderRepository() {
        providers.add(
            new Provider(
                1L,
                "Dr. Marcus Hill",
                "Licensed Therapist",
                "Specializes in men's mental health and trauma.",
                ProviderCategory.MENTAL_HEALTH
            )
        );

        providers.add(
            new Provider(
                2L,
                "Angela Brooks",
                "Career Mentor",
                "Helps professionals navigate career transitions.",
                ProviderCategory.MENTORSHIP_CAREER
            )
        );

        providers.add(
            new Provider(
                3L,
                "David Chen",
                "Financial Coach",
                "Focuses on budgeting, debt, and generational wealth.",
                ProviderCategory.MENTORSHIP_FINANCIAL
            )
        );
    }

    public List<Provider> findAll() {
        return providers;
    }

    public List<Provider> findByCategory(ProviderCategory category) {
        return providers.stream()
                .filter(p -> p.getCategory() == category)
                .collect(Collectors.toList());
    }
}
