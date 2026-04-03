package com.AZTradingCC.inventory_tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("123"))
                .roles("ADMIN")
                .build();

        UserDetails viewer = User.builder()
                .username("view")
                .password(passwordEncoder.encode("123"))
                .roles("VIEWER")
                .build();

        return new InMemoryUserDetailsManager(admin, viewer);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                        .csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler())
                )
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/home").authenticated()
                        .requestMatchers("/inventory/pokemon/search").hasAnyRole("ADMIN", "VIEWER")
                        .requestMatchers("/inventory/pokemon").hasAnyRole("ADMIN", "VIEWER")
                        .requestMatchers("/inventory/pokemon/sealed/print").hasAnyRole("ADMIN", "VIEWER")
                        .requestMatchers("/inventory/pokemon/sealed/print/data").hasAnyRole("ADMIN", "VIEWER")
                        .requestMatchers("/inventory/pokemon/edit").hasRole("ADMIN")

                        .requestMatchers("/inventory/pokemon/singles/*/price").hasRole("ADMIN")
                        .requestMatchers("/inventory/pokemon/singles/*/verify").hasRole("ADMIN")
                        .requestMatchers("/inventory/pokemon/sealed/*/price").hasRole("ADMIN")
                        .requestMatchers("/inventory/pokemon/sealed/*/verify").hasRole("ADMIN")

                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }
}
