package student.enroll.management;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    private static final String SAMPLE_CSV ="./dataInput.csv";
    public static void main(String[] args) throws ParseException, IOException {
        System.out.println("""
                Welcome to Student System Management
                -------------------------
                Please proceed to the menu for further actions""");
        // enhance default --------------------------------------------------------------------------------
        StudentEnrollmentSystem ses = new StudentEnrollmentSystem();
        char exit = 'y';
        Scanner input = new Scanner(System.in);
        String fileIn = "dataInput.csv";
        String fileOut = "dataOutput.csv";
        String line = null;
        while(exit!='n'){
            try {
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                int choice;
                System.out.println("\nMenu");
                System.out.println("[1] Student");
                System.out.println("[2] Course");
                System.out.println("[3] Enroll");
                System.out.println("[4] Pre-populate data");
                System.out.print("Choice: ");
                choice = Integer.parseInt(br.readLine());
                switch (choice) {
                    case 1 -> {
                        int studentChoice;
                        System.out.println("[1] Create Student");
                        System.out.println("[2] Delete Student");
                        System.out.println("[3] Modify Student");
                        System.out.println("[4] View Student Info");
                        System.out.println("[5] View Student List");
                        System.out.println("[6] Print all course of a student in a semester");
                        System.out.print("Choice: ");
                        studentChoice = input.nextInt();
                        // if/else to catch error missing!
                        // Remodify this, change studentchoice to int
                        switch (studentChoice) {
                            case 1 -> {
                                System.out.print("\nEnter Student ID: ");
                                String studentId = input.next();
                                System.out.print("\nEnter Student name: ");
                                Scanner nameInput = new Scanner(System.in);
                                String name = nameInput.nextLine();
                                System.out.print("\nEnter Student birthDate (dd/MM/yyyy): ");
                                String date = input.next();
                                Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                                Student student = new Student(studentId, name, birthDate);
                                ses.addStudent(student);
                                writeToCSV_Student(ses.displayStudentList());
                                System.out.println("Student: " + student.getStudentName() + " has successfully created");
                                System.out.println("At index of: " + ses.displayStudentList().indexOf(student));
                            }
                            case 2 -> {
                                System.out.println("\nAttempt to remove a student.");
                                System.out.println("\nEnter Student ID: ");
                                String studentRemove = input.nextLine();
                                System.out.println("Attempt to remove the following student: ");
                                ses.getStudent(studentRemove);
                                System.out.println("Deleting....");
                                ses.displayStudentList().remove(ses.getStudentObject(studentRemove));
                                System.out.println("Success!");
                            }
                            case 3 -> {
                                Student studentUpdate;
                                System.out.println("\n Attempt to edit a student.");
                                System.out.print("\nEnter Student ID to update: ");
                                String studentIdLocator = input.next();
                                studentUpdate = ses.getStudentObject(studentIdLocator);
                                System.out.print("\nEnter new Student ID: ");
                                String studentIdAdjust = input.next();
                                System.out.print("\nEnter new Student name: ");
                                Scanner nameInputAdjust = new Scanner(System.in);
                                String nameAdjust = nameInputAdjust.nextLine();
                                System.out.print("\nEnter new Student birthDate (dd/MM/yyyy): ");
                                String dateAdjust = input.next();
                                Date birthDateAdjust = new SimpleDateFormat("dd/MM/yyyy").parse(dateAdjust);
                                Student studentAdjust = new Student(studentIdAdjust, nameAdjust, birthDateAdjust);
                                ses.modifyStudent(studentAdjust, studentUpdate);
                            }
                            case 4 -> {
                                Scanner nameSearch = new Scanner(System.in);
                                String view;
                                System.out.println("Enter the Student ID to view: ");
                                view = nameSearch.nextLine();
                                ses.getStudent(view);
                            }
                            case 5 -> {
                                System.out.println("Here is the list of available students: ");
                                ses.printStudents();
                            }
                            case 6 ->{
                                System.out.println("Print all enrolled course of a student in a semester...");
                                Scanner printCourseInput = new Scanner(System.in);
                                System.out.println("Please enter the Student ID: ");
                                String studentID_input = printCourseInput.nextLine();
                                System.out.println("Please enter the semester: ");
                                String semesterName_input = printCourseInput.nextLine();
                                System.out.println("Proceed to print...");
                                ses.getSemesterObject(semesterName_input).getStudentObject(studentID_input).printAllCourse();
                            }
                            default -> {
                                System.out.println("Choice not found! ");
                                System.out.println("\nDo it again? 1 2 3 4");
                                studentChoice = input.nextInt();
                            }
                        }
                    }
                    case 2 -> {
                        int courseChoice;
                        System.out.println("[1] Create Course");
                        System.out.println("[2] Delete Course");
                        System.out.println("[3] Modify Course");
                        System.out.println("[4] View Course Info");
                        System.out.println("[5] View Course List");
                        System.out.println("[6] View all students of a course in a semester");
                        System.out.print("Choice: ");
                        courseChoice = input.nextInt();
                        // if/else to catch error missing!
                        switch (courseChoice) {
                            case 1 -> {
                                System.out.print("\nEnter Course ID: ");
                                String courseId = input.next();
                                System.out.print("\nEnter Course name: ");
                                Scanner nameInput = new Scanner(System.in);
                                String CourseName = nameInput.nextLine();
                                System.out.print("\nEnter credits: ");
                                int credits = input.nextInt();
                                Course course = new Course(courseId, CourseName, credits);
                                ses.addCourse(course);
                                writeToCSV_Course(ses.displayCourseList());
                                System.out.println("Course: " + course.getCourseId() + " " + course.getCourseName() + " has successfully created");
                                System.out.println("At index of: " + ses.displayCourseList().indexOf(course));
                                break;
                            }
                            case 2 -> {
                                System.out.println("\nAttempt to remove a course.");
                                System.out.println("\nEnter Course ID: ");
                                String courseRemove = input.nextLine();
                                System.out.println("Attempt to remove the following course: ");
                                ses.getCourse(courseRemove);
                                System.out.println("Deleting...");
                                ses.displayCourseList().remove(ses.getCourseObject(courseRemove));
                                System.out.println("Success!");
                                break;
                            }
                            case 3 -> {
                                Course courseUpdate;
                                System.out.println("\n Attempt to edit a course.");
                                System.out.print("\nEnter Course ID to update: ");
                                String courseIdFound = input.next();
                                courseUpdate = ses.getCourseObject(courseIdFound);
                                System.out.print("\nEnter Course ID: ");
                                String courseIdAdjust = input.next();
                                System.out.print("\nEnter Course name: ");
                                Scanner nameInputAdjust = new Scanner(System.in);
                                String CourseNameAdjust = nameInputAdjust.nextLine();
                                System.out.print("\nEnter credits: ");
                                int creditsAdjust = input.nextInt();
                                Course courseAdjust = new Course(courseIdAdjust, CourseNameAdjust, creditsAdjust);
                                ses.modifyCourse(courseAdjust, courseUpdate);
                                break;
                            }
                            case 4 -> {
                                Scanner idSearch = new Scanner(System.in);
                                String view;
                                System.out.println("Enter the Course ID to view: ");
                                view = idSearch.nextLine();
                                ses.getCourse(view);
                                break;
                            }
                            case 5 -> {
                                System.out.println("Here is the list of available courses: ");
                                ses.printCourse();
                                break;
                            }
                            case 6 -> {
                                try{
                                    System.out.println("Attempt to print all the students in a semester of a course...");
                                    Scanner course_input = new Scanner(System.in);
                                    System.out.println("Please enter course ID: ");
                                    String courseID_input = course_input.nextLine();
                                    System.out.println("Please enter semester name: ");
                                    String semesterCourse_input = course_input.nextLine();
                                    System.out.println("Proceed to print...");
                                    ses.getSemesterObject(semesterCourse_input).getCourseObject(courseID_input).printAllStudent();
                                    System.out.println("End..");
                                    break;
                                }
                                catch (NullPointerException e){e.printStackTrace();}

                            }
                            default -> {
                                System.out.println("Choice not found! ");
                                System.out.println("\nDo it again? 1 2 3 4");
                                int choice2 = input.nextInt();
                                courseChoice = choice2;
                                break;
                            }
                        }
                    }
                    case 3 -> {
                        int enrollChoice;
                        System.out.println("[1] Enlist a Course to a Semester");
                        System.out.println("[2] Delete Semester");
                        System.out.println("[3] Update Semester Enrollment");
                        System.out.println("[4] Create a Semester");
                        System.out.println("[5] Enroll a Student to a Semester");
                        System.out.print("Choice: ");
                        enrollChoice = input.nextInt();
                        switch (enrollChoice) {
                            case 1 -> {
                                try{
                                    String courseInput;
                                    String semesterName;
                                    Course courseEnroll;
                                    System.out.println("Attempt to enlist a course to a semester...");
                                    System.out.println("Please be noted that course must be created in advance.");
                                    Scanner enlist = new Scanner(System.in);
                                    System.out.println("Please enter the course ID: ");
                                    courseInput = enlist.nextLine();
                                    courseEnroll = ses.getCourseObject(courseInput);
                                    System.out.println("Please enter the semester name: ");
                                    semesterName = enlist.nextLine();
                                    System.out.println("Course already enlisted!");
                                    System.out.println("Adding Course related: ");
                                    ses.getSemesterObject(semesterName).getCourseArrayList().add(courseEnroll);
                                    System.out.println("Success!");
                                    break;

                                }
                                catch (NullPointerException e){e.printStackTrace();}
                                break;
                            }
                            case 2 -> {
                                System.out.println("Attempt to delete a semester");
                                String semesterNameDelete;
                                SemesterEnrollment semesterEnrollment;
                                Scanner deleteSemesterInput = new Scanner(System.in);
                                System.out.println("Please enter semester name to delete: ");
                                semesterNameDelete = deleteSemesterInput.nextLine();
                                semesterEnrollment = ses.getSemesterObject(semesterNameDelete);
                                ses.displaySemesterList().remove(semesterEnrollment);
                                System.out.println("Success!");
                            }
                            case 3 -> {
                                String studentInputUpdate;
                                String courseInputUpdate;
                                String courseNewUpdate;
                                String semesterNameUpdate;
                                Course courseEnrollUpdate;
                                Course courseNewUpdateEnroll;
                                Student studentEnrollUpdate;
                                SemesterEnrollment semesterEnrollmentUpdate;
                                System.out.println("Attempt to update a semester...");
                                Scanner enrollUpdate = new Scanner(System.in);
                                System.out.println("Please enter the semester name to proceed: ");
                                semesterNameUpdate = enrollUpdate.nextLine();
                                semesterEnrollmentUpdate = ses.getSemesterObject(semesterNameUpdate);
                                System.out.println("Please enter the student ID: ");
                                studentInputUpdate = enrollUpdate.nextLine();
                                studentEnrollUpdate = ses.getStudentObject(studentInputUpdate);
                                System.out.println("Please enter the old course ID: ");
                                courseInputUpdate = enrollUpdate.nextLine();
                                courseEnrollUpdate = ses.getCourseObject(courseInputUpdate);
                                System.out.println("Please enter the new course ID: ");
                                courseNewUpdate = enrollUpdate.nextLine();
                                courseNewUpdateEnroll = ses.getCourseObject(courseNewUpdate);
                                if (semesterEnrollmentUpdate.getCourseObject(courseInputUpdate).getStudentList().contains(studentEnrollUpdate)
                                        || semesterEnrollmentUpdate.getStudentObject(studentInputUpdate).getCoursesListPersonal().contains(courseEnrollUpdate)) {
                                    System.out.println("Student found! Attempt to update the enrollment....");
                                    semesterEnrollmentUpdate.getCourseObject(courseInputUpdate).getStudentList().remove(studentEnrollUpdate);
                                    semesterEnrollmentUpdate.getStudentObject(studentInputUpdate).getCoursesListPersonal().remove(courseEnrollUpdate);
                                    System.out.println("Successfully removed the old enrollment...");
                                    semesterEnrollmentUpdate.getStudentObject(studentInputUpdate).getCoursesListPersonal().add(courseNewUpdateEnroll);
                                    semesterEnrollmentUpdate.getCourseObject(courseNewUpdate).getStudentList().add(studentEnrollUpdate);
                                    System.out.println("Successfully updated");
                                    break;
                                } else {
                                    System.out.println("Student not found :(");
                                    break;
                                }
                            }
                            case 4 -> {
                                System.out.println("Attempt to create a semester...");
                                Scanner semesterNameInput = new Scanner(System.in);
                                System.out.println("Please enter a semester name: ");
                                String semesterNameCreate = semesterNameInput.nextLine();
                                SemesterEnrollment semesterCreate = new SemesterEnrollment(semesterNameCreate);
                                if (ses.displaySemesterList().contains(semesterCreate)) {
                                    System.out.println("Error! Semester already created.");
                                    break;
                                } else {
                                    System.out.println("Prompt to create a semester.");
                                    ses.displaySemesterList().add(semesterCreate);
                                    System.out.println("Success!");
                                    break;
                                }
                            }
                            case 5 -> {
                                try{
                                    String studentID_enroll;
                                    String semesterName_enroll;
                                    String courseID_enroll;
                                    SemesterEnrollment semester_enroll;
                                    Student student_enroll;
                                    Course course_enroll;
                                    Scanner enroll = new Scanner(System.in);
                                    System.out.println("Attempt to enroll a student to a course in a semester...");
                                    System.out.println("Please be noted that student, course, and semester must be created in advance");
                                    System.out.println("Please enter Student ID: ");
                                    studentID_enroll = enroll.nextLine();
                                    student_enroll = ses.getStudentObject(studentID_enroll);
                                    System.out.println("Please enter the course ID: ");
                                    courseID_enroll = enroll.nextLine();
                                    course_enroll = ses.getCourseObject(courseID_enroll);
                                    System.out.println("Please enter the semester name: ");
                                    semesterName_enroll = enroll.nextLine();
                                    semester_enroll = ses.getSemesterObject(semesterName_enroll);
                                    System.out.println("Proceed to enroll...");
                                    semester_enroll.getCourseObject(courseID_enroll).getStudentList().add(student_enroll);
                                    semester_enroll.getStudentObject(studentID_enroll).getCoursesListPersonal().add(course_enroll);
                                    writeToCSV_Student(semester_enroll.getCourseObject(courseID_enroll).getStudentList());
                                    writeToCSV_Course(semester_enroll.getStudentObject(studentID_enroll).getCoursesListPersonal());
                                    writeToCSV_Semester(ses.displaySemesterList());
                                    System.out.println("Success!");
                                    break;
                                }
                                catch (NullPointerException e){e.printStackTrace();}

                            }
                            case 6 -> {
                                System.out.println("View all course in a semester... ");
                                Scanner semester_input = new Scanner(System.in);
                                System.out.println("Please enter semester name: ");
                                String semesterName_input = semester_input.nextLine();
                                ses.getSemesterObject(semesterName_input).printAllCourse_Semester();
                                System.out.println("End...");
                            }
                        }
                    }
                    case 4 -> {
                        try {
                            FileReader fileReader = new FileReader(fileIn);
                            BufferedReader bufferedReader = new BufferedReader(fileReader);
                            line = "";
                            while ((line = bufferedReader.readLine()) != null) {
                                String[] temp = line.split(",");
                                int studentID = Integer.parseInt(temp[0]);
                                String firstName = temp[1];
                                String lastName = temp[2];
                                int finalMark = Integer.parseInt(temp[3]);
                                String finalGrade = temp[4];

                            }
                            bufferedReader.close();
                        } catch (FileNotFoundException e) {

                        }
                    }
                    default -> {
                        System.out.println("Choice not found! ");
                        System.out.println("\nDo it again? y/n");
                        String choice3 = input.nextLine().toLowerCase();
                        exit = choice3.charAt(0);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static final String CSV_SEPARATOR = ",";
    private static void writeToCSV_Student(ArrayList<Student> studentsList)
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
        }
        catch (UnsupportedEncodingException e) {e.printStackTrace();}
        catch (FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
    }
    private static void writeToCSV_Course(ArrayList<Course> coursesList)
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
        }
        catch (UnsupportedEncodingException e) {e.printStackTrace();}
        catch (FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
    }
    private static void writeToCSV_Semester(ArrayList<SemesterEnrollment> semesterEnrollmentsList)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter("semesters.csv", true));
            for (SemesterEnrollment semester : semesterEnrollmentsList)
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
        }
        catch (UnsupportedEncodingException e) {e.printStackTrace();}
        catch (FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
    }
}

