package test.forpost.gre.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.forpost.gre.post.dto.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>
{
    
}
