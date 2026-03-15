package studentpackage.student_portal_management19.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import studentpackage.student_portal_management19.DTO.MarkDto;
import studentpackage.student_portal_management19.Entity.MarkEntity;
import studentpackage.student_portal_management19.Service.MarkService;

import java.util.List;

@CrossOrigin
@RestController
public class MarkController {
    @Autowired
    private MarkService calltheservice;

@PostMapping("/addmark")
    public MarkEntity Addmark(@RequestBody MarkDto markDto){
       return calltheservice.Addmarklogic(markDto);
    }

    @GetMapping("/display/{reg}")
    public List<MarkDto> DisplayMark(@PathVariable(name = "reg") String reg){
    return calltheservice.Displaylogic(reg);
    }
}
