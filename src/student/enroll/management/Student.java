package student.enroll.management;

import java.util.ArrayList;
import java.util.Date;

public class Student {
    private String StudentId;
    private String StudentName;
    private Date birthDate;
    private ArrayList<Course> coursesList = new ArrayList<Course>();

    public Student(String studentId, String studentName, Date birthDate) {
        this.StudentId = studentId;
        this.StudentName = studentName;
        this.birthDate = birthDate;
        this.coursesList = new ArrayList<Course>();
    }
    public boolean addCourse(Course course){
        if (course==null || coursesList.contains(course)){
            System.out.println("Student already in this. Attempt failed!");
            return false;
        }
        coursesList.add(course);
        return true;
    }
    public boolean removeCourse(Course course){
        if (course==null || coursesList.contains(course)){
            System.out.println("Attempt to drop a course. Success!");
            coursesList.remove(course);
            return true;
        }
        System.out.println("Attempt to drop a course. Failed. Student doesn't enroll in this course. ");
        return false;
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
