package com.example.demo.services;

import com.example.demo.models.Provider;
import com.example.demo.models.ProviderCategory;
import com.example.demo.repositories.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    private final ProviderRepository providerRepo;

    public ProviderService(ProviderRepository providerRepo) {
        this.providerRepo = providerRepo;
    }

    public List<Provider> getAllProviders() {
        return providerRepo.findAll();
    }

    public List<Provider> getProvidersByCategory(ProviderCategory category) {
        return providerRepo.findByCategory(category);
    }
}
