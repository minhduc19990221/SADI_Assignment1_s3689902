package student.enroll.management;

public interface StudentEnrollmentManager {
    public Student getStudent(int s);
    public void addStudent(Student s);
    public void removeStudent(Student s);
    public void modifyStudent(Student s, int index);
    public void printStudents();
    public Student checkStudentAvailablity(String studentID);
    public void addCourse(Course c);
    public void removeCourse(Course c);
    public void modifyCourse(Course c, int index);
    public void printCourse();
    public Course getCourse(int s);


}
