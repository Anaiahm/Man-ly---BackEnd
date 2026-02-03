package com.example.demo.services;

import com.example.demo.models.ProviderCategory;
import com.example.demo.repositories.ProviderRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProviderServiceTest {

    private final ProviderService providerService =
            new ProviderService(new ProviderRepository());

    @Test
    void shouldReturnAllProviders() {
        var providers = providerService.getAllProviders();
        assertThat(providers).isNotEmpty();
    }

    @Test
    void shouldFilterByCategory() {
        var providers = providerService.getProvidersByCategory(
                ProviderCategory.MENTAL_HEALTH
        );

        assertThat(providers)
                .allMatch(p -> p.getCategory() == ProviderCategory.MENTAL_HEALTH);
    }
}
