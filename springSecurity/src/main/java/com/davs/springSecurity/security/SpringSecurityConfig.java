package com.davs.springSecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.davs.springSecurity.security.filter.JwtAuthenticationFilter;
import com.davs.springSecurity.security.filter.JwtValidationFilter;

@Configuration
public class SpringSecurityConfig {

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;


    @Bean
    AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests((authz) -> authz
            .requestMatchers(HttpMethod.GET, "/api/users").permitAll() // deja publica la ruta users
            .requestMatchers(HttpMethod.POST, "/api/users/register").permitAll() // deja publica la ruta users/register
            .requestMatchers(HttpMethod.POST, "/api/users").hasRole("ADMIN") // deja publica la ruta users/register
            .requestMatchers(HttpMethod.GET, "/api/products", "api/products/{id}").hasAnyRole("ADMIN", "USER") // deja publica la ruta users/register
            .requestMatchers(HttpMethod.POST, "/api/products").hasRole("ADMIN") // deja publica la ruta users/register
            .requestMatchers(HttpMethod.PUT, "/api/products/{id}").hasRole("ADMIN") // deja publica la ruta users/register
            .requestMatchers(HttpMethod.DELETE, "/api/products/{id}").hasRole("ADMIN") // deja publica la ruta users/register
            .anyRequest().authenticated()) //todo lo demas requiere autenticacion
            .addFilter(new JwtAuthenticationFilter(authenticationManager())) //filtro que crea el token al hacer login
            .addFilter(new JwtValidationFilter(authenticationManager())) //filtro que valida el token en otras rutas protegidas
            .csrf(config -> config.disable()) // desabilitar el token csrf - ()esto aplica solo para formularios (front)
            .sessionManagement(managment -> managment.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // para que la session no tenga estado y todo se maneje por un token
            .build();
    }

}
