package student.enroll.management;

import java.util.ArrayList;

public class SemesterEnrollment {
    private String semesterName;
    private ArrayList<Course> courseArrayList;
    private ArrayList<Student> studentArrayList;

    public SemesterEnrollment(String semesterName) {
        this.semesterName = semesterName;
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
            if(c.getCourseId().equals(id)){course = c;}
            else{ return null; }
        }
        return course;
    }
    public Student getStudentObject(String id){
        Student student = null;
        for(Student s : studentArrayList){
            if(s.getStudentId().equals(id)){student = s;}
            else{ return null; }
        }
        return student;
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
