package test.forpost.gre.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.forpost.gre.board.dto.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long>
{
    
}
