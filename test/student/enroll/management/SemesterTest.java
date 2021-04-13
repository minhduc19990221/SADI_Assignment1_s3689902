package student.enroll.management;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SemesterTest {
    public static Semester semester = new Semester("2021A");
    @BeforeClass


    @Test
    void getSemesterName() {
        assertEquals("2021A", semester.getSemesterName());
    }

    @Test
    void setSemesterName(String s) {
        semester.setSemesterName("2021B");
        assertEquals("2021B", semester.getSemesterName());
    }

    @Test
    void getCourseObject() {

    }

    @Test
    void getStudentObject() {
    }

    @Test
    void printAllCourse_Semester() {

    }

    @Test
    void getCourseArrayList() {
        assertArrayEquals(null, semester.getCourseArrayList().toArray(new Course[0]));
    }

    @Test
    void setCourseArrayList() {
    }

    @Test
    void getStudentArrayList() {
    }

    @Test
    void setStudentArrayList() {
    }
}