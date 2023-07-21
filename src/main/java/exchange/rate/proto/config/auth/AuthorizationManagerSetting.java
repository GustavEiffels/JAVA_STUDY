package exchange.rate.proto.config.auth;

import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import exchange.rate.proto.model.entity.UserAuth;
import exchange.rate.proto.repository.UserAuthRepository;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class AuthorizationManagerSetting  extends BasicAuthenticationFilter
{
    private UserAuthRepository userAuthRepository;

    public AuthorizationManagerSetting(AuthenticationManager authenticationManager, UserAuthRepository userAuthRepository) 
    {
        super(authenticationManager);
        this.userAuthRepository         = userAuthRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
                log.info(" REQUSET GET : {}",request.getRequestURI());


        Optional<String>            getAuthorization            = Optional.ofNullable(request.getHeader("Authorization")); 
        String                      jwtTokenValue               = null;

        if( getAuthorization.isPresent() ) return;
        
        /**
         log - request Url Checking
         */


                                    jwtTokenValue               = getAuthorization.get().replace("Bearer ", "");
        /**
         log - token Checking   
         */ 
        log.info(" GET  JWT TOKEN  : {}",jwtTokenValue);

        Optional<UserAuth>          userAuth                    = userAuthRepository.findByLoginEmail(
                                                                                    JWT.require(
                                                                                        Algorithm.HMAC512("IAMKING")).build()
                                                                                        .verify(jwtTokenValue)
                                                                                        .getClaim("loginEmail")
                                                                                        .asString() );
        
        if( !userAuth.isPresent() ) return;

        PrincipalDetails            principalDetails            = new PrincipalDetails(userAuth.get());
        Authentication              authentication              = new UsernamePasswordAuthenticationToken(principalDetails, null ,principalDetails.getAuthorities());

        /**
         log - token Checking   
         */ 
        log.info(" GET  User Authorization  : {}", principalDetails.getAuthorities() );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }
    
    

    
    
}
