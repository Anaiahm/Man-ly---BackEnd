// package com.example.demo.config;

// import java.util.List;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// @Configuration
// public class SecurityConfig {

//   @Bean
//   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//     http
//       .cors(Customizer.withDefaults())
//       .csrf(csrf -> csrf.disable())
//       .authorizeHttpRequests(auth -> auth
//         .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//         .requestMatchers("/**").permitAll()
//       );

//     return http.build();
//   }

//   @Bean
//   public CorsConfigurationSource corsConfigurationSource() {
//     CorsConfiguration config = new CorsConfiguration();

//     // IMPORTANT: must match EXACTLY your Netlify origin
//     config.setAllowedOrigins(List.of(
//       "https://man-ly.netlify.app"
//     ));

//     config.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
//     config.setAllowedHeaders(List.of("*"));

//     // Since you're doing token auth (Option B), credentials are not required.
//     // Keeping this false avoids extra cookie-related complexity.
//     config.setAllowCredentials(false);

//     // Cache preflight response for 1 hour
//     config.setMaxAge(3600L);

//     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//     source.registerCorsConfiguration("/**", config);
//     return source;
//   }
// }
