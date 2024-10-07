package com.DMH.accountsservice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Desactivar CSRF
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/accounts/create/**").permitAll()
                        .requestMatchers("/accounts/update/alias/**").permitAll() // Permitir acceso sin autenticación a ciertos endpoints
                        .anyRequest().authenticated() // Requiere autenticación para el resto
                )
                .addFilterBefore(jwtAuthenticationFilter(), BasicAuthenticationFilter.class); // Agregar el filtro de autenticación JWT

        return http.build();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }
}




