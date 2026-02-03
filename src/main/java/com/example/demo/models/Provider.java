package com.example.demo.models;

public class Provider {

    private Long id;
    private String name;
    private String title;
    private String bio;
    private ProviderCategory category;

    public Provider(
            Long id,
            String name,
            String title,
            String bio,
            ProviderCategory category
    ) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.bio = bio;
        this.category = category;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getTitle() { return title; }
    public String getBio() { return bio; }
    public ProviderCategory getCategory() { return category; }
}
