package com.example.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher; 

import com.example.bankapp.service.AccountService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AccountService accountService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF, be careful with this for production!
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/register").permitAll()  // Public registration page
                        .requestMatchers("/login").permitAll()    // Allow login page
                        .anyRequest().authenticated())  // All other requests need authentication
                .formLogin(form -> form
                        .loginPage("/login")  // Login form page URL
                        .loginProcessingUrl("/login")  // Form POST URL to process login
                        .defaultSuccessUrl("/dashboard", true)  // Where to redirect after login
                        .permitAll())
                .logout(logout -> logout
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))  // Logout URL
                        .logoutSuccessUrl("/login?logout")  // Redirect after logout
                        .permitAll())
                .headers(header -> header
                        .frameOptions(frameOptions -> frameOptions.sameOrigin()));  // Optional: Prevent clickjacking

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountService).passwordEncoder(passwordEncoder());
    }
}
