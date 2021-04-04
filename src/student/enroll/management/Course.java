package student.enroll.management;

import java.util.ArrayList;

public class Course {
    private String courseId;
    private String courseName;
    private int credits;
    private ArrayList<Student> studentList;

    public Course(String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.studentList = studentList;
    }

    public boolean addStudent(Student student){
        if (student==null || studentList.contains(student)){
            System.out.println("Student already in this. Attempt failed!");
            return false;
        }
        studentList.add(student);
        return true;
    }


    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
