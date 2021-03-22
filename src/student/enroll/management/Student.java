package student.enroll.management;

import java.util.Date;

public class Student {
    private String StudentId;
    private String StudentName;
    private Date birthDate;

    public Student(String studentId, String studentName, Date birthDate) {
        StudentId = studentId;
        StudentName = studentName;
        this.birthDate = birthDate;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
