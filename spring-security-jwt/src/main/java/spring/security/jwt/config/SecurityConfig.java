package spring.security.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import spring.security.jwt.security.JWTFilter;

/**
 * In Spring Boot 3.x and Spring 6, it’s actually recommended to use
 * SecurityFilterChain instead of extending WebSecurityConfigurerAdapter (which was the common
 * approach in earlier Spring Security versions). WebSecurityConfigurerAdapter was removed
 * to encourage a more flexible and modular security configuration using
 * SecurityFilterChain. Here’s why using SecurityFilterChain is a better option and how to implement it:

 * Why Use SecurityFilterChain? Modularity: SecurityFilterChain enables multiple
 * filter chains, which is useful if you have different security requirements for
 * different parts of your application (e.g., public and protected API sections). Simpler
 * Configuration: You create a SecurityFilterChain bean in a configuration class, which keeps
 * the configuration more in line with Spring’s standard way of defining beans.

 * Removed in Spring Security 6: WebSecurityConfigurerAdapter was deprecated and later
 * removed, so moving to SecurityFilterChain is necessary for compatibility with Spring 6
 * and newer versions.
 */

@Configuration
public class SecurityConfig {

    private final JWTFilter jwtFilter;

    public SecurityConfig(JWTFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf ->csrf.disable())//New approach to disable CSRF
                //http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
