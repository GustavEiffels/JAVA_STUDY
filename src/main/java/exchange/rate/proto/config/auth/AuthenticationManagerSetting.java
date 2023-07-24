package exchange.rate.proto.config.auth;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import exchange.rate.proto.model.entity.UserAuth;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
public class AuthenticationManagerSetting extends UsernamePasswordAuthenticationFilter
{
    private final AuthenticationManager         manager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException 
    {
      
        log.info("DETECTING LOGIN : "+"AuthenticationManagerSetting");

        
        try 
        {
            ObjectMapper                            mapper                          = new ObjectMapper();
                                                                                    request.setCharacterEncoding("UTF-8");
            UserAuth                                auth                            = mapper.readValue(request.getInputStream(),UserAuth.class);
            UsernamePasswordAuthenticationToken     token                           = new UsernamePasswordAuthenticationToken(auth.getLoginEmail(), auth.getLoginPassword());

            log.info("Authentication Token", token);
            return manager.authenticate(token);
        } 
        catch (Exception e) 
        {

            log.info("Error "+e.getCause());
            log.info("Error Contents : "+e.getMessage());
        }

        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException 
    {
        try 
        {
            PrincipalDetails                    principalDetails                    = (PrincipalDetails) authResult.getPrincipal();
            log.info("LOGIN EMAIL    : {}",principalDetails.getUsername());
            log.info("LOGIN PASSWORD : {}",principalDetails.getPassword());
            String                              jwtTokenString                      = JWT.create()
                                                                                                    .withSubject("key")
                                                                                                    .withExpiresAt(new Date(System.currentTimeMillis()+60000*10))
                                                                                                    .withClaim("loginEmail", principalDetails.getUsername())
                                                                                                    .sign(Algorithm.HMAC512("IAMKING"));
            log.info("jwtTokenString : "+jwtTokenString);
                   
            
            Map<String,Object>                  body                                = new LinkedHashMap<>();
            body.put("test","TEST");

            response.setStatus(HttpStatus.OK.value());
            response.addHeader("Authorization", "Bearer "+jwtTokenString);
            
            new ObjectMapper().writeValue(response.getOutputStream(), body);
         
            
            
        } 
        catch (Exception e) {  log.info("jwtTokenString Error : {}", e.getMessage()); }
    }
    
    // 로그인 성공 후 리다이렉션 처리를 위한 클래스
    public class LoginSuccessHandler implements AuthenticationSuccessHandler {

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                            Authentication authentication) throws IOException, ServletException {
            response.sendRedirect("http://localhost:8080/joinProc"); // 리다이렉션할 URL
        }
    }
}
