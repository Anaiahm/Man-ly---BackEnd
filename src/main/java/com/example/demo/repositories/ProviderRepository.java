package com.example.demo.repositories;

import com.example.demo.models.Provider;
import com.example.demo.models.ProviderCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
    List<Provider> findByCategory(ProviderCategory category);
}
