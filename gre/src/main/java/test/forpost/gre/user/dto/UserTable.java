package test.forpost.gre.user.dto;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import test.forpost.gre.board.dto.Board;
import test.forpost.gre.common.entity.BaseEntity;
import test.forpost.gre.file.dto.File;
import test.forpost.gre.post.dto.Post;
import test.forpost.gre.reply.dto.Reply;
import test.forpost.gre.rereply.dto.ReReply;

@Entity
@Getter @Setter @EqualsAndHashCode @ToString
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "nick"), @UniqueConstraint(columnNames = "email")})
@AllArgsConstructor
@NoArgsConstructor
public class UserTable extends BaseEntity
{
    
    @Column( nullable =  false )
    private String  name   ;

    @Column( nullable =  false )
    private String  nick   ;

    @Column( nullable =  false )
    private String  email  ;

    private Integer age    ;

    private String  gender ;


    @Enumerated(EnumType.STRING)
    @Column    ( nullable =  false )
    private Role    role   ;

    @OneToMany
    @JoinColumn(name = "user_table_pid")
    private List<File> file_list = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_table_pid")
    private List<ReReply> reReplies = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_table_pid")
    private List<Reply> replies = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_table_pid")
    private List<Post> posts = new ArrayList();

    @OneToMany
    @JoinColumn(name = "user_table_pid")
    private List<Board> boards = new ArrayList<>();


}
