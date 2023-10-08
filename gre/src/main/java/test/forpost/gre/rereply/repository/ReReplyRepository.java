package test.forpost.gre.rereply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.forpost.gre.rereply.dto.ReReply;

@Repository
public interface ReReplyRepository extends JpaRepository<ReReply,Long>
{
    
}
