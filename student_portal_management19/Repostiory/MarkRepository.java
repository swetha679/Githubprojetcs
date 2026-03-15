package studentpackage.student_portal_management19.Repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentpackage.student_portal_management19.Entity.MarkEntity;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<MarkEntity,Long> {
    List<MarkEntity>  findByReg(String reg);
}
