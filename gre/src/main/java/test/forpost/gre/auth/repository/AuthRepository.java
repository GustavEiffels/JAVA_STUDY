package test.forpost.gre.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.forpost.gre.auth.dto.Auth;

@Repository
public interface AuthRepository extends JpaRepository<Auth,Long>
{
    
}
