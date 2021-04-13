package student.enroll.management;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SemesterTest {
    public static Semester semester = new Semester("2021A");

    @Test
    void getSemesterName() {
        assertEquals("2021A", semester.getSemesterName());
    }

    @Test
    void setSemesterName() {
        semester.setSemesterName("2021B");
        assertEquals("2021B", semester.getSemesterName());
    }

    @Test
    void getCourseObject() {
        String id = "12";
        Course course = new Course("12", "SADI", 12);;
        Course[] courseArrayList = new Course[0];
        for(Course c : courseArrayList){
            if(c.getCourseId().equals(id)){
                course.setCourseId(c.getCourseId());
                course.setCourseName(c.getCourseName());
                course.setCredits(c.getCredits());
                assertEquals("12",c.getCourseId());
            }
            else{ course = null; }
        }
        assertEquals("12",course.getCourseId());
    }

    @Test
    void getStudentObject() {
        Student student = new Student("11", "Duc", "21/02/1999");;
        Student[] studentArrayList = new Student[0];
        String id = "11";
        for(Student s : studentArrayList){
            if(s.getStudentId().equals(id)){
                student.setBirthDate(s.getBirthDate());
                student.setStudentId(s.getStudentId());
                student.setStudentName(s.getStudentName());
            }
            else{ student= null; }
        }
        assertEquals("11",student.getStudentId());
    }

    @Test
    void printAllCourse_Semester() {
        assertTrue(semester.printAllCourse_Semester());
    }

    }