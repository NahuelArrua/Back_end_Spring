package com.example.Login.config


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity // <-- ¡Esta importación y anotación son CRUCIALES!
import org.springframework.security.web.SecurityFilterChain
@Configuration
@EnableWebSecurity
open class SecurityConfig {

    @Bean
    open fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { csrf ->
                // AHORA TAMBIÉN IGNORAMOS /users/** (sin el /api/)
                csrf.ignoringRequestMatchers("/h2-console/**", "/api/users/**", "/users/**")
            }
            .authorizeHttpRequests { authorize ->
                authorize
                    .requestMatchers("/h2-console/**").permitAll()
                    // AHORA TAMBIÉN PERMITIMOS /users/register (sin el /api/)
                    .requestMatchers("/api/users/register", "/users/register").permitAll()
                    .requestMatchers("/api/users/login", "/users/login").permitAll()
                    .anyRequest().authenticated()
            }
            .headers { headers ->
                headers.frameOptions { frameOptions ->
                    frameOptions.sameOrigin()
                }
            }
        return http.build()
    }
}