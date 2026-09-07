package com.study.springsecurity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        httpSecurity.csrf(customizer->customizer.disable());  //disables csrf
        httpSecurity.authorizeHttpRequests(request->request.anyRequest().authenticated()); //ensures that every request is authenticated.
        httpSecurity.formLogin(Customizer.withDefaults());  //enables or login
        httpSecurity.httpBasic(Customizer.withDefaults());  //enables postman login or login via api
        return httpSecurity.build();
    }
}
