package test.forpost.gre.file.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
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
public class File extends BaseEntity
{
    @Column(nullable = false)
    private Long    size;

    @Column(nullable = false)
    private String  extention;

    @Column(nullable = false)
    private String  originalName;

    @Lob
    @Column(nullable = false, unique = true)
    private String  fileName;

    @Column(nullable = false)
    private String  mediaType;

    @Column(nullable = false)
    private String  sizeUnit;
}
