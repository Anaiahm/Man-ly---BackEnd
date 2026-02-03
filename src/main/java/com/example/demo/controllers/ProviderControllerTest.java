package com.example.demo.controllers;

import com.example.demo.services.ProviderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProviderController.class)
class ProviderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProviderService providerService;

    @Test
    void shouldReturnAllProviders() throws Exception {
        mockMvc.perform(get("/api/providers"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnProvidersByCategory() throws Exception {
        mockMvc.perform(get("/api/providers/category/MENTAL_HEALTH"))
                .andExpect(status().isOk());
    }
}
