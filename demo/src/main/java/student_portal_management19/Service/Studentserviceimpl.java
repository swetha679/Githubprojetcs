package demo.src.main.java.student_portal_management19.Service;


import java.util.Optional;

@Service
public class Studentserviceimpl implements StudentService{
    @Autowired
    private StudentRepository callthequery;

    @Override
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
        return check.isPresent();

    }

}
