package demo.src.main.java.student_portal_management19.Service;


public interface StudentService {
    public StudentEntity Studentregisterlogic(StudentDto front);
    public boolean Studentloginlogic(Long reg,String password);
}
