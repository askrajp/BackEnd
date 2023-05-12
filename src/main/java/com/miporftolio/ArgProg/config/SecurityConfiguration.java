package com.miporftolio.ArgProg.config;

import com.miporftolio.ArgProg.filters.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    
   
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
             .cors().and()
            .authorizeHttpRequests((authorize) -> authorize
                .anyRequest().permitAll()
            )
            .csrf().disable()
            .httpBasic().disable()
            .formLogin().disable()
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
