package exchange.rate.proto.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import exchange.rate.proto.model.entity.UserAuth;
import exchange.rate.proto.repository.UserAuthRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService 
{
    private final UserAuthRepository            userAuthRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        log.info("login!? : ",this.getClass());
        UserAuth                    userAuth                        = userAuthRepository.findByLoginEmail(username).orElseThrow();
        return new PrincipalDetails(userAuth);  
    }

    
}
