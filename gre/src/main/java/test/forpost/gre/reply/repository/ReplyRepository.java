package test.forpost.gre.reply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.forpost.gre.reply.dto.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply,Long> 
{
    
}
