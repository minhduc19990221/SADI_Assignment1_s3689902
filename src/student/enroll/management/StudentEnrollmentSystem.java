package student.enroll.management;

import java.util.ArrayList;

class StudentEnrollmentSystem implements StudentEnrollmentManager {

    private ArrayList<Student> studentList;
    private ArrayList<Course> courseList;
    private ArrayList<SemesterEnrollment> semesterLists;
    public StudentEnrollmentSystem() {
        studentList = new ArrayList<Student>();
        courseList = new ArrayList<Course>();
        semesterLists = new ArrayList<SemesterEnrollment>();
    }

    public ArrayList<Student> displayStudentList () {

        return studentList;
    }
    public ArrayList<Course> displayCourseList () {

        return courseList;
    }

    public ArrayList<SemesterEnrollment> displaySemesterList () {

        return semesterLists;
    }

    @Override
    public Student getStudentObject(String id){
        Student student = null;
        for(Student s : studentList){
            if(s.getStudentId().equals(id)){student = s;}
            else{ return null; }
        }
        return student;
    }
    @Override
    public Course getCourseObject(String id){
        Course course = null;
        for(Course c : courseList){
            if(c.getCourseId().equals(id)){course = c;}
            else{ return null; }
        }
        return course;
    }
    @Override
    public SemesterEnrollment getSemesterObject(String name){
        SemesterEnrollment semester = null;
        for(SemesterEnrollment s : semesterLists){
            if(s.getSemesterName().equals(name)){semester = s;}
            else{return null;}
        }
        return semester;
    }
    @Override
    public void modifySemester(SemesterEnrollment semester, SemesterEnrollment semesterToUpdate){semesterLists.set(semesterLists.indexOf(semesterToUpdate), semester);}
    public void getSemester(String name){
        for(SemesterEnrollment s : semesterLists){
            if(s.getSemesterName().equals(name)){
                System.out.println("Here is the info of the required semester: ");
                System.out.println("Name: "+s.getSemesterName());

            }
        }
    }
    @Override
    public void getStudent(String id) {
        for(Student s : studentList){
            if(s.getStudentId().equals(id)){
                System.out.println("Here is the info of the required student: ");
                System.out.println("Name: "+s.getStudentName());
                System.out.println("Student ID: " + s.getStudentId());
                System.out.println("DOB: " + s.getBirthDate());
            }
            else{
                System.out.println("Student not found!");
            }
        }

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
    public Student checkStudentAvailablity(String studentID) {
        for (Student s:studentList){
            if (s.getStudentId().equals(studentID)){
                return s;
            }
        }
        return null;
    }
    @Override
    public void printStudents() {
        System.out.println("Here is the list of current students");
        for(Student s : studentList){
            System.out.println(s.getStudentName() + ", with ID: " + s.getStudentId() + " born in " + s.getBirthDate());
        }
        System.out.println("------------");
    }



    @Override
    public void addCourse(Course c) {
        courseList.add(c);
    }

    @Override
    public void removeCourse(Course c) {
        courseList.remove(c);
    }

    @Override
    public void modifyCourse(Course c, Course courseUpdate) {
        courseList.set(courseList.indexOf(courseUpdate), c);
    }

    @Override
    public void printCourse() {
        System.out.println("Here is the list of current courses.");
        for(Course c : courseList){
            System.out.println("Name: " + c.getCourseName() + " ID: " +c.getCourseId() + " requires credits: " + c.getCredits());
        }
        System.out.println("------------");
    }


    @Override
    public void getCourse(String id) {
        for(Course c : courseList){
            if(c.getCourseId().equals(id)){
                System.out.println("Here is the information of the course: ");
                System.out.println("Name: "+c.getCourseName());
                System.out.println("ID: "+c.getCourseId());
                System.out.println("Required: "+c.getCredits());
            }
            else{
                System.out.println("Course not found!");
            }
        }
    }
    @Override
    public void modifyStudent(Student s, Student studentUpdate) {
        studentList.set(studentList.indexOf(studentUpdate),s);
    }

}
