package demo.src.main.java.student_portal_management19.Repostiory;


import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<MarkEntity,Long> {
    List<MarkEntity>  findByReg(String reg);
}
