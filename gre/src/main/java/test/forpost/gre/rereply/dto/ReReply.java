package test.forpost.gre.rereply.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import test.forpost.gre.common.entity.BaseEntity;

@Entity
@Getter @Setter @ToString @EqualsAndHashCode 
@AllArgsConstructor
@NoArgsConstructor
public class ReReply extends BaseEntity
{
    @Column(nullable = false)
    private String contents;
}
