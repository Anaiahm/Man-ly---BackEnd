package com.example.demo.controllers;

import com.example.demo.models.Provider;
import com.example.demo.models.User;
import com.example.demo.repositories.ProviderRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/care-team")
@CrossOrigin(origins = {"http://localhost:5173"})
public class CareTeamController {

    private final UserRepository userRepository;
    private final ProviderRepository providerRepository;

    public CareTeamController(UserRepository userRepository, ProviderRepository providerRepository) {
        this.userRepository = userRepository;
        this.providerRepository = providerRepository;
    }

    // MVP: treat user with id=1 as the "logged in" user
    private User currentUser() {
        return userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Demo user not found (id=1)."));
    }

    @GetMapping
    public Set<Provider> getCareTeam() {
        return currentUser().getCareTeam();
    }

    @DeleteMapping("/{providerId}")
    public ResponseEntity<Void> removeFromCareTeam(@PathVariable Long providerId) {
        User user = currentUser();

        Provider provider = providerRepository.findById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found: " + providerId));

        user.removeProviderFromCareTeam(provider);
        userRepository.save(user);

        return ResponseEntity.noContent().build();
    }
}