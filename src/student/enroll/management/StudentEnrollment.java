package student.enroll.management;

import java.util.ArrayList;

public class StudentEnrollment {
    private String semester;
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Course> courseList = new ArrayList<Course>();
    public StudentEnrollment() {
        studentList = new ArrayList<Student>();
        courseList = new ArrayList<Course>();
    }
    public void enrollStudent(Student s){
        studentList.add(s);
    }
    public void expellStudent(Student s){
        studentList.remove(s);
    }
    public void modifyStudent(Student s, int index){
        studentList.set(index,s);
    }
}
