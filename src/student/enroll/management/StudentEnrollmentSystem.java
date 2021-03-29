package student.enroll.management;

import java.util.ArrayList;

class StudentEnrollmentSystem implements StudentEnrollmentManager {
    private String semester;
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Course> courseList = new ArrayList<Course>();
    public StudentEnrollmentSystem() {
        studentList = new ArrayList<Student>();
        courseList = new ArrayList<Course>();
    }

    public ArrayList<Student> displayStudentList () {

        return studentList;
    }

    @Override
    public void addStudent(Student s) {
        studentList.add(s);
    }

    @Override
    public void removeStudent(Student s) {
        studentList.remove(s);
    }

    @Override
    public void checkStudentAvailablity(String studentID) {
        for (Student s:studentList){

        }
    }

    @Override
    public void modifyStudent(Student s, int index) {
        studentList.set(index,s);
    }

}
