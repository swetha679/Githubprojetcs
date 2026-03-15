package demo.src.main.java.student_portal_management19.Controller;

import java.util.List;

import demo.src.main.java.student_portal_management19.DTO.MarkDto;
import demo.src.main.java.student_portal_management19.Entity.MarkEntity;
import demo.src.main.java.student_portal_management19.Service.MarkService;

@CrossOrigin(origins = "")
@RestController
public class MarkController {
    @Autowired
    private MarkService calltheservice;

@PostMapping("/addmark")
    public MarkEntity Addmark(@RequestMapping(value = "") MarkDto markDto){
       return calltheservice.Addmarklogic(markDto);
    }

    @GetMapping("/display/{reg}")
    public List<MarkDto> DisplayMark(@PathVariable(name = "reg") String reg){
    return calltheservice.Displaylogic(reg);
    }
}
