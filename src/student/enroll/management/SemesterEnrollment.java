package student.enroll.management;

import java.util.ArrayList;

public class SemesterEnrollment {
    private String semesterName;
    private String studentID;
    private Course course;
    private Student student;

    public SemesterEnrollment(String semesterName, Student student, Course course) {
        this.semesterName = semesterName;
        this.student = student;
        this.course = course;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
