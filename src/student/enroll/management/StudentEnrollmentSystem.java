package student.enroll.management;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class StudentEnrollmentSystem implements StudentEnrollmentManager {

    private ArrayList<Student> studentList;
    private ArrayList<Course> courseList;
    private ArrayList<Semester> semesterLists;
    public StudentEnrollmentSystem() {
        studentList = new ArrayList<Student>();
        courseList = new ArrayList<Course>();
        semesterLists = new ArrayList<Semester>();
    }


    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }


    public void setSemesterLists(ArrayList<Semester> semesterLists) {
        this.semesterLists = semesterLists;
    }

    public ArrayList<Student> displayStudentList () {

        return studentList;
    }

    public ArrayList<Course> displayCourseList () {

        return courseList;
    }

    public ArrayList<Semester> displaySemesterList () {

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
    public Semester getSemesterObject(String name){
        Semester semester = null;
        for(Semester s : semesterLists){
            if(s.getSemesterName().equals(name)){semester = s;}
            else{return null;}
        }
        return semester;
    }
    @Override
    public void modifySemester(Semester semester, Semester semesterToUpdate){semesterLists.set(semesterLists.indexOf(semesterToUpdate), semester);}
    public void getSemester(String name){
        for(Semester s : semesterLists){
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
    // ------------------------------------------------------------------
    // CSV Functions session
    public ArrayList<Student> readStudentFromCSV (String filename) throws IOException, ParseException {
        ArrayList<Student> students =new ArrayList<>();
        Path pathToFile = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
        String line = br.readLine();
        while (line != null){
            String[] attributes = line.split(",");
            Student student = createStudent_ForCSV(attributes);
            students.add(student);
            line = br.readLine();
        }
        return students;
    }
    public ArrayList<Course> readCourseFromCSV (String filename) throws IOException, ParseException {
        ArrayList<Course> courses =new ArrayList<>();
        Path pathToFile = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
        String line = br.readLine();
        while (line != null){
            String[] attributes = line.split(",");
            Course course = createCourse_ForCSV(attributes);
            courses.add(course);
            line = br.readLine();
        }
        return courses;
    }
    public ArrayList<Semester> readSemesterFromCSV (String filename) throws IOException, ParseException {
        ArrayList<Semester> semesters =new ArrayList<>();
        Path pathToFile = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
        String line = br.readLine();
        while (line != null){
            String[] attributes = line.split(",");
            Semester semester = createSemester_ForCSV(attributes);
            semesters.add(semester);
            line = br.readLine();
        }
        return semesters;
    }
    public Student createStudent_ForCSV(String[] metadata) throws ParseException {
        String name = metadata[0];
        String studentId = metadata[1];
        String dateAdjust = metadata[2];
        // create and return of this metadata
        return new Student(name, studentId, dateAdjust);
    }
    public Course createCourse_ForCSV(String[] metadata) throws ParseException {
        String courseName = metadata[0];
        String courseID = metadata[1];
        int credit = Integer.parseInt(metadata[2]);
        // create and return of this metadata
        return new Course(courseName, courseID, credit);
    }
    public Semester createSemester_ForCSV(String[] metadata) throws ParseException {
        String semesterName = metadata[0];
        // create and return of this metadata
        return new Semester(semesterName);
    }
    private static final String CSV_SEPARATOR = ",";
    static void writeToCSV_Student(ArrayList<Student> studentsList)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter("students.csv", true));
            for (Student student : studentsList)
            {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(student.getStudentId());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(student.getStudentName().trim().length() == 0? "" : student.getStudentName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(student.getBirthDate());
                oneLine.append(CSV_SEPARATOR);
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {e.printStackTrace();}
    }

    static void writeToCSV_Course(ArrayList<Course> coursesList)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter("courses.csv", true));
            for (Course course : coursesList)
            {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(course.getCourseId());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(course.getCourseName().trim().length() == 0? "" : course.getCourseName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(course.getCredits());
                oneLine.append(CSV_SEPARATOR);
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e){e.printStackTrace();}
    }
    static void writeToCSV_Semester(ArrayList<Semester> semesterEnrollmentsList)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter("semesters.csv", true));
            for (Semester semester : semesterEnrollmentsList)
            {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(semester.getSemesterName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(semester.getCourseArrayList());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(semester.getStudentArrayList());
                oneLine.append(CSV_SEPARATOR);
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {e.printStackTrace();}
    }

}
