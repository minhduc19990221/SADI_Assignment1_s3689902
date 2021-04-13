package student.enroll.management;

public interface StudentEnrollmentManager {
    public void getStudent(String id);
    public Student getStudentObject(String id);
    public void addStudent(Student s);
    public void removeStudent(Student s);
    public void modifyStudent(Student s, Student studentUpdate);
    public void printStudents();
    public Student checkStudentAvailablity(String studentID);
    public void addCourse(Course c);
    public void removeCourse(Course c);
    public void modifyCourse(Course c, Course courseUpdate);
    public void printCourse();
    public void getCourse(String id);
    public Course getCourseObject(String id);
    public void modifySemester(Semester semester, Semester semesterToUpdate);
    public Semester getSemesterObject(String name);


}
