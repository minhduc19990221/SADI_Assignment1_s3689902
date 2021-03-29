package student.enroll.management;

public interface StudentEnrollmentManager {
    public void addStudent(Student s);
    public void removeStudent(Student s);
    public void modifyStudent(Student s, int index);
    public void checkStudentAvailablity(String studentID);

}
