package exchange.rate.proto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import exchange.rate.proto.model.dto.JoinDto;
import exchange.rate.proto.model.entity.UserAuth;
import exchange.rate.proto.repository.UserAuthRepository;

@Service
public class UserAuthService 
{   
    @Autowired
    private UserAuthRepository                      userAuthRepository;


    @Autowired
    private PasswordEncoder                         passwordEncoder;

    public void joinUser(JoinDto joinDto)
    {
        try 
        {
            UserAuth                    userAuth                    = new UserAuth();
            userAuth.setLoginEmail(joinDto.getEmail());
            userAuth.setLoginPassword( passwordEncoder.encode(joinDto.getPassword()));
            userAuth.setLoginUserRole("ROLE_ADMIN");
            userAuthRepository.save(userAuth);    
        } 
        catch (Exception e) 
        {
            
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getClass());
        }
        
    }
}
