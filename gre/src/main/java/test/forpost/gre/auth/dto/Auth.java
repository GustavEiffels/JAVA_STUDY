package test.forpost.gre.auth.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import test.forpost.gre.common.entity.BaseEntity;
import test.forpost.gre.user.dto.UserTable;

@Entity
@Getter @Setter @ToString @EqualsAndHashCode 
@NoArgsConstructor
@AllArgsConstructor
public class Auth extends BaseEntity
{
    @Column(nullable = false, unique = true)
    private String Id       ;

    @Column(nullable = false)
    private String password ;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_table_pid", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private UserTable userTable;
}
