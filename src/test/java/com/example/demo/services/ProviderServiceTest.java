package com.example.demo.services;

import com.example.demo.models.Provider;
import com.example.demo.models.ProviderCategory;
import com.example.demo.repositories.ProviderRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ProviderServiceTest {

    @Test
    void shouldReturnAllProviders() {
        // Arrange
        ProviderRepository providerRepository = mock(ProviderRepository.class);

        when(providerRepository.findAll()).thenReturn(List.of(
                new Provider("Dr. Marcus Hill", "Licensed Therapist",
                        "Specializes in men's mental health and trauma.",
                        ProviderCategory.MENTAL_HEALTH),
                new Provider("Angela Brooks", "Career Mentor",
                        "Helps professionals navigate career transitions.",
                        ProviderCategory.MENTORSHIP_CAREER)
        ));

        ProviderService providerService = new ProviderService(providerRepository);

        // Act
        var providers = providerService.getAllProviders();

        // Assert
        assertThat(providers).isNotEmpty();
        verify(providerRepository, times(1)).findAll();
    }

    @Test
    void shouldFilterByCategory() {
        // Arrange
        ProviderRepository providerRepository = mock(ProviderRepository.class);

        when(providerRepository.findByCategory(ProviderCategory.MENTAL_HEALTH)).thenReturn(List.of(
                new Provider("Dr. Marcus Hill", "Licensed Therapist",
                        "Specializes in men's mental health and trauma.",
                        ProviderCategory.MENTAL_HEALTH),
                new Provider("Dr. Alana Smith", "Therapist",
                        "Trauma-informed therapy and coping strategies.",
                        ProviderCategory.MENTAL_HEALTH)
        ));

        ProviderService providerService = new ProviderService(providerRepository);

        // Act
        var providers = providerService.getProvidersByCategory(ProviderCategory.MENTAL_HEALTH);

        // Assert
        assertThat(providers)
                .isNotEmpty()
                .allMatch(p -> p.getCategory() == ProviderCategory.MENTAL_HEALTH);

        verify(providerRepository, times(1)).findByCategory(ProviderCategory.MENTAL_HEALTH);
    }
}