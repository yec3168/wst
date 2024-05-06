package com.solution.pmt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.net.http.HttpClient;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
        http.formLogin(form -> form
                .loginPage("/member/login")
                .loginProcessingUrl("/member/login")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .passwordParameter("password")
        );
        http.logout(form -> form
                .logoutSuccessUrl("/")
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
        );
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
