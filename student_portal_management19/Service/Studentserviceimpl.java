package studentpackage.student_portal_management19.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import studentpackage.student_portal_management19.DTO.StudentDto;
import studentpackage.student_portal_management19.Entity.StudentEntity;
import studentpackage.student_portal_management19.Repostiory.StudentRepository;

import java.util.Optional;

@Service//=>data management
public class Studentserviceimpl implements StudentService{
    @Autowired// obj
    private StudentRepository callthequery;

    @Override//=> hidden
    public StudentEntity Studentregisterlogic(StudentDto front){
        StudentEntity storedata=new StudentEntity(front.getReg(),
                front.getName(),
                front.getPassword(),
                front.getYear(),
                front.getClg());
        return callthequery.save(storedata);

    }

    @Override
    public boolean  Studentloginlogic(Long reg,String password){
        Optional<StudentEntity> check =callthequery.findByRegAndPassword(reg, password);
        return check.isPresent();//true

    }

}
