package student.enroll.management;

import java.io.*;
import java.util.ArrayList;

public class SemesterEnrollment {
    private String semesterName;
    private ArrayList<Course> courseArrayList;
    private ArrayList<Student> studentArrayList;

    public SemesterEnrollment(String semesterName) {
        this.semesterName = semesterName;
        courseArrayList = new ArrayList<Course>();
        studentArrayList = new ArrayList<Student>();
    }


    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }
    public Course getCourseObject(String id){
        Course course = null;
        for(Course c : courseArrayList){
            if(c.getCourseId().equals(id)){
                course.setCourseId(c.getCourseId());
                course.setCourseName(c.getCourseName());
                course.setCredits(c.getCredits());
            }
            else{ return null; }
        }
        return course;
    }
    public Student getStudentObject(String id){
        Student student = null;
        for(Student s : studentArrayList){
            if(s.getStudentId().equals(id)){
                student.setBirthDate(s.getBirthDate());
                student.setStudentId(s.getStudentId());
                student.setStudentName(s.getStudentName());
            }
            else{ return null; }
        }
        return student;
    }
    public void printAllCourse_Semester(){
        for(Course c : courseArrayList){
            System.out.println("Name: " + c.getCourseName());
            System.out.println("Course ID: " + c.getCourseId());
            System.out.println("Credits: " + c.getCredits());
            System.out.println("---------------");
        }
    }

    public ArrayList<Course> getCourseArrayList() {
        return courseArrayList;
    }

    public void setCourseArrayList(ArrayList<Course> courseArrayList) {
        this.courseArrayList = courseArrayList;
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }
}
