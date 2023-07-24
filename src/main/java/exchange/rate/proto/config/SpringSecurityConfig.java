package exchange.rate.proto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import exchange.rate.proto.config.auth.AuthenticationManagerSetting;
import exchange.rate.proto.config.auth.AuthorizationManagerSetting;
import exchange.rate.proto.config.auth.CorsConfig;
import exchange.rate.proto.repository.UserAuthRepository;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig 
{

    @Autowired
    private  CorsConfig config;

    @Autowired
    private UserAuthRepository userAuthRepository;


    public class MyCustomDsl extends AbstractHttpConfigurer<MyCustomDsl, HttpSecurity> {
		@Override
		public void configure(HttpSecurity http) throws Exception {
			AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
			http
                .addFilter(config.corsFilter())
                .addFilter(new AuthenticationManagerSetting(authenticationManager))
                .addFilter(new AuthorizationManagerSetting(authenticationManager, userAuthRepository));
		}

	}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                    .csrf().disable()
                    .formLogin( login -> login.disable() )
                    .httpBasic( basic -> basic.disable() )
                    .apply(new MyCustomDsl())
                    .and()
                    .authorizeRequests( (auth) -> {
                        auth
                            .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                            .anyRequest().permitAll();
                    })
        .build();
    }    

    @Bean 
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }


    
}
