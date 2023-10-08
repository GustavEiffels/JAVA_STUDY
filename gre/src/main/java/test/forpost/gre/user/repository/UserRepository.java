package test.forpost.gre.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.forpost.gre.user.dto.UserTable;

@Repository
public interface UserRepository extends JpaRepository<UserTable,Long>
{
    
}
