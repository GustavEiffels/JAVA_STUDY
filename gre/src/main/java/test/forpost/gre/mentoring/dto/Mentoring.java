package test.forpost.gre.mentoring.dto;

import test.forpost.gre.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @EqualsAndHashCode @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Mentoring extends BaseEntity
{
    @Column(nullable = false)
    private String teacherId;
    
    @Column(nullable = false)
    private String studentId;
}
