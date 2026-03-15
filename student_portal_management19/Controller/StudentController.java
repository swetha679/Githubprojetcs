package studentpackage.student_portal_management19.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import studentpackage.student_portal_management19.DTO.StudentDto;
import studentpackage.student_portal_management19.Entity.StudentEntity;
import studentpackage.student_portal_management19.Service.StudentService;
@CrossOrigin
@RestController//=>align
public class StudentController {
    @Autowired
    private StudentService callthemethod;

    @PostMapping("/Register")
    public StudentEntity RegisterApi(@RequestBody StudentDto calltheinput){
        return callthemethod.Studentregisterlogic(calltheinput);
    }
    @PostMapping("/Login")
    public ResponseEntity<String> LoginApi(@RequestBody StudentDto calltheinput){
        System.out.println(callthemethod.Studentloginlogic(calltheinput.getReg(),calltheinput.getPassword()));
        if(callthemethod.Studentloginlogic(calltheinput.getReg(),calltheinput.getPassword())){
            return ResponseEntity.ok("Login successfull");
        }else{
            return ResponseEntity.ok("incorrect reg no and password");
        }
    }

}
