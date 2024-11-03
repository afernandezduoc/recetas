package com.demo.recetas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/", "/login", "/buscar", "/css/**", "/images/**").permitAll() // Rutas públicas
                        .anyRequest().authenticated() // Cualquier otra ruta requiere autenticación
                )
                .formLogin(form -> form
                        .loginPage("/login") // Página personalizada de login
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("usuario1")
                .password("password1")
                .roles("USER")
                .build();

        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("usuario2")
                .password("password2")
                .roles("USER")
                .build();

        UserDetails user3 = User.withDefaultPasswordEncoder()
                .username("usuario3")
                .password("password3")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
}
