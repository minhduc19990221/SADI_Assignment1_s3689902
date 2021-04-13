package student.enroll.management;

import java.util.ArrayList;
import java.util.Date;

public class Student {
    private String StudentId;
    private String StudentName;
    private String birthDate;
    private ArrayList<Course> coursesListPersonal = new ArrayList<Course>();

    public Student(String studentId, String studentName, String birthDate) {
        this.StudentId = studentId;
        this.StudentName = studentName;
        this.birthDate = birthDate;
        coursesListPersonal = new ArrayList<Course>();
    }
    public boolean addCourse(Course course){
        if (course==null || coursesListPersonal.contains(course)){
            System.out.println("Student already in this. Attempt failed!");
            return false;
        }
        coursesListPersonal.add(course);
        return true;
    }
    public boolean removeCourse(Course course){
        if (course==null || coursesListPersonal.contains(course)){
            System.out.println("Attempt to drop a course. Success!");
            coursesListPersonal.remove(course);
            return true;
        }
        System.out.println("Attempt to drop a course. Failed. Student doesn't enroll in this course. ");
        return false;
    }
    public void printAllCourse() {
        for(Course c : coursesListPersonal){
                System.out.println("Here is the list of enrolled course of the student in this semester... ");
                System.out.println("Name: "+c.getCourseName());
                System.out.println("Course ID: " + c.getCourseId());
                System.out.println("Credits: " + c.getCourseId());
        }

    }

    public ArrayList<Course> getCoursesListPersonal() {
        return coursesListPersonal;
    }

    public void setCoursesListPersonal(ArrayList<Course> coursesListPersonal) {
        this.coursesListPersonal = coursesListPersonal;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
