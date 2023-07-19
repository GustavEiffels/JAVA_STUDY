package exchange.rate.proto.config;

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
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                    .csrf(      csrf  -> csrf.disable()  )
                    .formLogin( login -> login.disable() )
                    .httpBasic( basic -> basic.disable() )
                    .authorizeRequests( (auth) -> {
                        auth
                            .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                            .anyRequest().permitAll();
                    })
        .build();
    }    
}
