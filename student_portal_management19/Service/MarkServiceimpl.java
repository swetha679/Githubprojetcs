package studentpackage.student_portal_management19.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentpackage.student_portal_management19.DTO.MarkDto;
import studentpackage.student_portal_management19.Entity.MarkEntity;
import studentpackage.student_portal_management19.Repostiory.MarkRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarkServiceimpl implements MarkService{
    @Autowired
    private MarkRepository callthequery;
    //=>store and controller => postman//task 1 and jdbc ==1//1 Monday
    @Override
    public MarkEntity Addmarklogic(MarkDto markDto){
        MarkEntity storethedata= new MarkEntity(markDto.getReg(),
                markDto.getName(), markDto.getSubjectname()
                , markDto.getSubjectcode(),
                markDto.getMark(), markDto.getGrade(),
                markDto.getResult());
        return callthequery.save(storethedata);
    }

    @Override
    public List<MarkDto> Displaylogic(String reg){
        List<MarkEntity> getdata= callthequery.findByReg(reg);//get
        List<MarkDto>   transfer= new ArrayList<>();
        for(MarkEntity getdatas:getdata){
            MarkDto setdata= new MarkDto();//e=>d
            setdata.setReg(getdatas.getReg());
            setdata.setName(getdatas.getName());
            setdata.setSubjectcode(getdatas.getSubjectcode());
            setdata.setSubjectname(getdatas.getSubjectname());
            setdata.setMark(getdatas.getMark());
            setdata.setGrade(getdatas.getGrade());
            setdata.setResult(getdatas.getResult());
            transfer.add(setdata);
        }
        return transfer;
    }
}
