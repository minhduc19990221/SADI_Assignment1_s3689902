package student.enroll.management;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {


    @Test
    void addStudent() throws ParseException {
        Course c = new Course("1", "SADI", 12);
        String date = "21/02/1999";
        Student s = new Student("1", "HUng", date);
        assertTrue(c.addStudent(s));
    }

    @Test
    void printStudents() {
    }

    @Test
    void getCourseId() {
    }

    @Test
    void setCourseId() {
    }

    @Test
    void getCourseName() {
    }

    @Test
    void setCourseName() {
    }

    @Test
    void getCredits() {
    }

    @Test
    void setCredits() {
    }

    @Test
    void removeStudent() {
    }

    @Test
    void printOneStudent() {
    }

    @Test
    void printAllStudent() {
    }

    @Test
    void getStudentList() {
    }

    @Test
    void setStudentList() {
    }
}