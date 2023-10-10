package test.forpost.gre.post.dto;


import test.forpost.gre.common.entity.BaseEntity;
import test.forpost.gre.reply.dto.Reply;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString @EqualsAndHashCode 
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseEntity
{
    @Column(nullable = false)
    private String title;
    
    @Lob
    @Column(nullable = false)
    private String contents;

    @OneToMany
    @JoinColumn(name = "post_pid", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<Reply> replies = new ArrayList<>();
}
