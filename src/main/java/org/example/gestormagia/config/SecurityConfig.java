package org.example.gestormagia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/hechizos/**").hasRole("MAGO")
                        .anyRequest().authenticated()
                )
                .formLogin(customizer -> customizer.loginPage("/login").permitAll()) // Configura una página de login personalizada si es necesario
                .httpBasic(customizer -> customizer.realmName("GestorMagia")) // Puedes personalizar el realm name
                .csrf(csrf -> csrf.disable()); // Deshabilita CSRF si no es necesario para pruebas y desarrollo

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

