package studentpackage.student_portal_management19.Service;

import studentpackage.student_portal_management19.DTO.StudentDto;
import studentpackage.student_portal_management19.Entity.StudentEntity;

public interface StudentService {
    public StudentEntity Studentregisterlogic(StudentDto front);
    public boolean Studentloginlogic(Long reg,String password);
}
