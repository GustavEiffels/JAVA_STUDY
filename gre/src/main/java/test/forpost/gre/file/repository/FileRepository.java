package test.forpost.gre.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.forpost.gre.file.dto.File;

@Repository
public interface FileRepository extends JpaRepository<File,Long>
{
    
}
