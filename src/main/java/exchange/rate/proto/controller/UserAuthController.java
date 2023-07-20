package exchange.rate.proto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import exchange.rate.proto.model.dto.JoinDto;
import exchange.rate.proto.service.UserAuthService;
import lombok.extern.slf4j.Slf4j;

@Controller 
@Slf4j
public class UserAuthController 
{

    @Autowired
    private                 UserAuthService                     userAuthService;

    @PostMapping("/join")
    public @ResponseBody String joinProcess(JoinDto joinDto)
    {
        String              result              =   "DONE";
        try   { userAuthService.joinUser(joinDto); } 
        catch (Exception e) 
        {
            log.info("ERROR EMERGE : ",e.getMessage());
            result =  "ERROR";
        }
        return result;
    }    
}
