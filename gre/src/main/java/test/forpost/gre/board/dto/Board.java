package test.forpost.gre.board.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import test.forpost.gre.common.entity.BaseEntity;
import test.forpost.gre.post.dto.Post;

@Entity
@Getter @Setter @EqualsAndHashCode @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board extends BaseEntity
{
    @Column(nullable = false)
    private String name;    

    @OneToMany
    @JoinColumn(name = "board_pid", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<Post> postes = new ArrayList<>();
}
