package com.example.demo.controllers;

import com.example.demo.models.Provider;
import com.example.demo.models.ProviderCategory;
import com.example.demo.services.ProviderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    // Get all providers
    @GetMapping
    public List<Provider> getAllProviders() {
        return providerService.getAllProviders();
    }

    // Filter by category
    @GetMapping("/category/{category}")
    public List<Provider> getByCategory(@PathVariable ProviderCategory category) {
        return providerService.getProvidersByCategory(category);
    }
}
