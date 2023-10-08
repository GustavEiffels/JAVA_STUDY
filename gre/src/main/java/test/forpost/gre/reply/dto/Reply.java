package test.forpost.gre.reply.dto;

import test.forpost.gre.common.entity.BaseEntity;
import test.forpost.gre.rereply.dto.ReReply;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
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
public class Reply extends BaseEntity
{
    @Lob
    @Column(nullable = false)
    private String contents;

    @OneToMany
    @JoinColumn(name = "reply_pid")
    private List<ReReply> reReplies = new ArrayList<>();
}
