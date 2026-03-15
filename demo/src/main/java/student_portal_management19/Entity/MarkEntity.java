package demo.src.main.java.student_portal_management19.Entity;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "Student-mark")
public class MarkEntity {
    private static final String GenerationType = null;
    @Id
    @Generated(comments = GenerationType.IDENTITY, value = { "" })
    private Long id;
    private String reg;
    private String name;
    private  String subjectname;
    private String subjectcode;
    private String mark;
    private String grade;
    private String result;//=> constructor, get and set, default constructor

    public MarkEntity() {
    }

    public MarkEntity(String reg, String name, String subjectname, String subjectcode, String mark, String grade, String result) {
        this.reg = reg;
        this.name = name;
        this.subjectname = subjectname;
        this.subjectcode = subjectcode;
        this.mark = mark;
        this.grade = grade;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getSubjectcode() {
        return subjectcode;
    }

    public void setSubjectcode(String subjectcode) {
        this.subjectcode = subjectcode;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
