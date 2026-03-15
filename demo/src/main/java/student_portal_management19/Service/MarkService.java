package demo.src.main.java.student_portal_management19.Service;


import java.util.List;

public interface MarkService {
    public MarkEntity Addmarklogic(MarkDto markDto);
    public List<MarkDto> Displaylogic(String reg);
}
