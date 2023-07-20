package exchange.rate.proto.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import exchange.rate.proto.model.entity.UserAuth;

public class PrincipalDetails implements UserDetails 
{
    private  UserAuth                                            userAuth;
    public   PrincipalDetails(UserAuth userAuth)                 { this.userAuth = userAuth; }
    public   UserAuth           getUserAuth()                    { return this.userAuth ; }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() 
    {    
        Collection<GrantedAuthority>            authList                    =   new ArrayList<>();
        userAuth.getLoginUserRoleList().forEach( r->{ authList.add(()-> r); } );
        return authList;
    }

    @Override
    public String getPassword() { return userAuth.getLoginPassword();}

    @Override
    public String getUsername() { return userAuth.getLoginEmail();   }


    @Override
    public boolean isAccountNonExpired()        { return true; } 

    @Override
    public boolean isAccountNonLocked()         { return true; }

    @Override
    public boolean isCredentialsNonExpired()    { return true; }

    @Override
    public boolean isEnabled()                  { return true; }
    
}
