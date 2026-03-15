package demo.src.main.java.student_portal_management19.Controller;

import javax.smartcardio.ResponseAPDU;

import demo.src.main.java.student_portal_management19.DTO.StudentDto;
import demo.src.main.java.student_portal_management19.Entity.StudentEntity;
import demo.src.main.java.student_portal_management19.Service.StudentService;

@CrossOrigin(origins = "")
@RestController//=>align
public class StudentController {
    private static final String ResponseEntity = null;
    @Autowired
    private StudentService callthemethod;

    @PostMapping("/Register")
    public StudentEntity RegisterApi(@RequestMapping(value = "") StudentDto calltheinput){
        return callthemethod.Studentregisterlogic(calltheinput);
    }
    @PostMapping("/Login")
    public ResponseAPDU<String> LoginApi(@RequestMapping(value = "") StudentDto calltheinput){
        System.out.println(callthemethod.Studentloginlogic(calltheinput.getReg(),calltheinput.getPassword()));
        if(callthemethod.Studentloginlogic(calltheinput.getReg(),calltheinput.getPassword())){
            return ResponseEntity.ok("Login successfull");
        }else{
            return ResponseEntity.ok("incorrect reg no and password");
        }
    }

}
