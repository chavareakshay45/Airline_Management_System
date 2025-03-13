package com.ams;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/api/login/**").permitAll()
            .antMatchers("/api/v1/**/**").permitAll()
            .antMatchers("/api/customer/**").permitAll() 
            .antMatchers("/api/v1/carrier/**").permitAll()
            .antMatchers("/api/v1/flights/**").permitAll()
            .antMatchers("/api/v1/flightschedules/**").permitAll()           .anyRequest().permitAll() // Allow all requests without authentication
            .and()
            .csrf().disable() // Disable CSRF for simplicity
            .headers().frameOptions().disable(); // Enable frames (useful for H2 console or embedded UI)
    }
}