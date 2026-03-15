package demo.src.main.java.student_portal_management19.DTO;

public class StudentDto {


    private Long reg;
    private String name;
    private String password;
    private int year;
    private String clg;
public StudentDto(){

}

    public StudentDto(Long reg, String name, String password, int year, String clg) {
        this.reg = reg;
        this.name = name;
        this.password = password;
        this.year = year;
        this.clg = clg;
    }

    public Long getReg() {
        return reg;
    }

    public void setReg(Long reg) {
        this.reg = reg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getClg() {
        return clg;
    }

    public void setClg(String clg) {
        this.clg = clg;
    }
}
