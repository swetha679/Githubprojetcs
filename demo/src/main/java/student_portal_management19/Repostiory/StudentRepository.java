package demo.src.main.java.student_portal_management19.Repostiory;


import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
   
    Optional<StudentEntity> findByRegAndPassword(Long reg,String password);
}
