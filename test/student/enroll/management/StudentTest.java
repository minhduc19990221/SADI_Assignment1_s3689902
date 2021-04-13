package student.enroll.management;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void addCourse() {
        Student s = new Student("1", "Duc", "21/02/1999");
        Course c_test = new Course("1", "SADI", 12);
        assertTrue(s.addCourse(c_test));
    }

    @Test
    void removeCourse() {
        Student s = new Student("1", "Duc", "21/02/1999");
        Course c_test = new Course("1", "SADI", 12);
        s.addCourse(c_test);
        assertTrue(s.removeCourse(c_test));
    }

    @Test
    void getStudentId() {
        Student s = new Student("1", "Duc", "21/02/1999");
        assertEquals("1",s.getStudentId());
    }

    @Test
    void setStudentId() {
        Student s = new Student("1", "Duc", "21/02/1999");
        s.setStudentId("2");
        assertEquals("2",s.getStudentId());
    }

    @Test
    void getStudentName() {
        Student s = new Student("1", "Duc", "21/02/1999");
        assertEquals("Duc",s.getStudentName());
    }

    @Test
    void setStudentName() {
        Student s = new Student("1", "Duc", "21/02/1999");
        s.setStudentName("Minh Duc");
        assertEquals("Minh Duc",s.getStudentName());
    }

    @Test
    void getBirthDate() {
        Student s = new Student("1", "Duc", "21/02/1999");
        assertEquals("21/02/1999",s.getBirthDate());
    }

    @Test
    void setBirthDate() {
        Student s = new Student("1", "Duc", "21/02/1999");
        s.setBirthDate("22/02/1999");
        assertEquals("22/02/1999",s.getBirthDate());
    }
}