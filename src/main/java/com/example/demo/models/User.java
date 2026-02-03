package com.example.demo.models;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column
    private String profilePhotoUrl;

    // Unidirectional Many-to-Many to Provider
    @ManyToMany
    @JoinTable(
        name = "user_care_team",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "provider_id")
    )
    private Set<Provider> careTeam = new HashSet<>();

    // Constructors
    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password, String name, String profilePhotoUrl) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.profilePhotoUrl = profilePhotoUrl;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getProfilePhotoUrl() { return profilePhotoUrl; }
    public void setProfilePhotoUrl(String profilePhotoUrl) { this.profilePhotoUrl = profilePhotoUrl; }

    public Set<Provider> getCareTeam() { return careTeam; }
    public void setCareTeam(Set<Provider> careTeam) { this.careTeam = careTeam; }

    // Convenience methods
    public void addProviderToCareTeam(Provider provider) { this.careTeam.add(provider); }
    public void removeProviderFromCareTeam(Provider provider) { this.careTeam.remove(provider); }
}
