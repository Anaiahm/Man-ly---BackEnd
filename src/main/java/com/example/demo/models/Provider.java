package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "providers")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String title;

    @Column(length = 1000)
    private String bio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProviderCategory category;

    // Constructors
    public Provider() {}

    public Provider(String name, String title, String bio, ProviderCategory category) {
        this.name = name;
        this.title = title;
        this.bio = bio;
        this.category = category;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public ProviderCategory getCategory() { return category; }
    public void setCategory(ProviderCategory category) { this.category = category; }
}
