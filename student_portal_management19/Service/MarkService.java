package studentpackage.student_portal_management19.Service;

import studentpackage.student_portal_management19.DTO.MarkDto;
import studentpackage.student_portal_management19.Entity.MarkEntity;

import java.util.List;

public interface MarkService {
    public MarkEntity Addmarklogic(MarkDto markDto);
    public List<MarkDto> Displaylogic(String reg);
}
