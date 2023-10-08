package test.forpost.gre.mentoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.forpost.gre.mentoring.dto.Mentoring;

@Repository
public interface MentoringRepository extends JpaRepository<Mentoring,Long>
{
    
}
