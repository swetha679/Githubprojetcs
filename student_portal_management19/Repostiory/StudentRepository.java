package studentpackage.student_portal_management19.Repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentpackage.student_portal_management19.Entity.StudentEntity;

import java.util.Optional;

@Repository//=>sql create write interface =>error
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    //select *from Studententity where reg=? And password=?
    Optional<StudentEntity> findByRegAndPassword(Long reg,String password);
}
