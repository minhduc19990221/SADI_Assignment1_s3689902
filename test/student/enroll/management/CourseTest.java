package student.enroll.management;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {


    @Test
    void addStudent() throws ParseException {
        Course c = new Course("1", "SADI", 12);
        Student s = new Student("1", "Duc", "21/02/1999");
        assertTrue(c.addStudent(s));
    }

    @Test
    void getCourseId() {
        Course c = new Course("1", "SADI", 12);
        assertEquals(12,c.getCredits());
    }

    @Test
    void setCourseId() {
        Course c = new Course("1", "SADI", 12);
        c.setCourseId("2");
        assertEquals("2",c.getCourseId());
    }

    @Test
    void getCourseName() {
        Course c = new Course("1", "SADI", 12);
        assertEquals("SADI",c.getCourseName());
    }

    @Test
    void setCourseName() {
        Course c = new Course("1", "SADI", 12);
        c.setCourseName("Test");
        assertEquals("Test",c.getCourseName());
    }

    @Test
    void getCredits() {
        Course c = new Course("1", "SADI", 12);
        assertEquals(12,c.getCredits());
    }

    @Test
    void setCredits() {
        Course c = new Course("1", "SADI", 12);
        c.setCredits(14);
        assertEquals(14,c.getCredits());
    }

    @Test
    boolean removeStudent(Student s) {
        Course c = new Course("1", "SADI", 12);
        String date = "21/02/1999";
        Student s_remove = new Student("1", "HUng", date);
        c.addStudent(s_remove);
        assertTrue(removeStudent(s_remove));
        return true;
    }


    @Test
    void printAllStudent() {
        Course c = new Course("1", "SADI", 12);
        assertEquals("",c.printAllStudent());
    }

    @Test
    void getStudentList() {
        Course c = new Course("1", "SADI", 12);
        String[] test = new String[0];
        assertArrayEquals(test,c.getStudentList().toArray(new Student[0]));
    }

   }