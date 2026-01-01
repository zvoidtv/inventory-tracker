package com.AZTradingCC.inventory_tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        // This rule protects all pages on your site
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        // This tells Spring to use its default, auto-generated login page
                        .loginProcessingUrl("/login") // The URL the form should submit to
                        .defaultSuccessUrl("/home", true) // Where to go after a good login
                        .permitAll() // Allow everyone to see the login page
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }
}
