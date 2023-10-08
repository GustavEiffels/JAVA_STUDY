package test.forpost.gre.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SpringSecurityConfig 
{
    @Bean
    public SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception
    {
        return http.csrf().disable().authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
        .build();
    }
    
}
