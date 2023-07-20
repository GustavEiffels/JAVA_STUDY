package exchange.rate.proto.model.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAuth extends BaseEntity 
{
    private String loginEmail;
    private String loginPassword;
    private String loginUserRole;


    public List<String>        getLoginUserRoleList()
    {
        if( this.loginUserRole.length() > 0 )   return Arrays.asList(this.loginUserRole.split(","));
                                                return new ArrayList<>();
    }

}
