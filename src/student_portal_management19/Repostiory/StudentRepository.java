package src.student_portal_management19.Repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentpackage.student_portal_management19.Entity.StudentEntity;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
 
    Optional<StudentEntity> findByRegAndPassword(Long reg,String password);
}
