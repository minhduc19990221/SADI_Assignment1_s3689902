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
        studentList = new ArrayList<Student>();
    }

    public boolean addStudent(Student student){
        if (student==null || studentList.contains(student)){
            System.out.println("Student already in this. Attempt failed!");
            return false;
        }
        studentList.add(student);
        return true;
    }
    public boolean removeStudent(Student student){
        if (student==null || studentList.contains(student)){
            System.out.println("Attempt to remove a student...");
            studentList.remove(student);
            System.out.println("Success!");
            return true;
        }
        System.out.println("Can't find the student! Error");
        return false;
    }

    public String printAllStudent() {
        for(Student s : studentList){
                System.out.println("Here is the info of the required student... ");
                System.out.println("Name: "+s.getStudentName());
                System.out.println("Student ID: " + s.getStudentId());
                System.out.println("DOB: " + s.getBirthDate());
            }
        return "";
    }


    public ArrayList<Student> getStudentList() {
        return studentList;
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
