package student.enroll.management;
import java.io.*;
import java.text.ParseException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        System.out.println("""
                Welcome to Student System Management
                -------------------------
                Please proceed to the menu for further actions""");
        StudentEnrollmentSystem ses = new StudentEnrollmentSystem();
        char exit = 'y';
        Scanner input = new Scanner(System.in);
        while(exit!='n'){
            try {
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                int choice;
                System.out.println("\nMenu");
                System.out.println("[1] Student");
                System.out.println("[2] Course");
                System.out.println("[3] Enroll");
                System.out.print("Choice: ");
                choice = Integer.parseInt(br.readLine());
                switch (choice){
                    case 1:
                        int studentChoice;
                        System.out.println("[1] Create Student");
                        System.out.println("[2] Delete Student");
                        System.out.println("[3] Modify Student");
                        System.out.println("[4] View Student Info");
                        System.out.println("[5] View Student List");
                        System.out.print("Choice: ");
                        studentChoice = input.nextInt();
                        switch (studentChoice){
                            case 1:
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
                                System.out.println("Student: " + student.getStudentName() + " has successfully created");
                                System.out.println("At index of: " + ses.displayStudentList().indexOf(student));
                                break;
                            case 2:
                                System.out.println("\nAttempt to remove a student.");
                                System.out.println("\nEnter Student ID: ");
                                String studentRemove = input.nextLine();
                                System.out.println("Attempt to remove the following student: ");
                                ses.getStudent(studentRemove);
                                System.out.println("Deleting....");
                                ses.displayStudentList().remove(ses.getStudentObject(studentRemove));
                                System.out.println("Success!");
                                break;
                            case 3:
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
                                ses.modifyStudent(studentAdjust,studentUpdate);
                                break;
                            case 4:
                                Scanner nameSearch = new Scanner(System.in);
                                String view;
                                System.out.println("Enter the Student ID to view: ");
                                view = nameSearch.nextLine();
                                ses.getStudent(view);
                                break;
                            case 5:
                                System.out.println("Here is the list of available students: ");
                                ses.printStudents();
                                break;
                            default:
                                // Remodify this, change studentchoice to int
                                System.out.println("Choice not found! ");
                                System.out.println("\nDo it again? 1 2 3 4");
                                int choice2 = input.nextInt();
                                studentChoice = choice2;
                                break; }
                    break;
                    case 2:
                        int courseChoice;
                        System.out.println("[1] Create Course");
                        System.out.println("[2] Delete Course");
                        System.out.println("[3] Modify Course");
                        System.out.println("[4] View Course Info");
                        System.out.println("[5] View Course List");
                        System.out.print("Choice: ");
                        courseChoice = input.nextInt();
                        switch (courseChoice){
                            case 1:
                                System.out.print("\nEnter Course ID: ");
                                String courseId = input.next();
                                System.out.print("\nEnter Course name: ");
                                Scanner nameInput = new Scanner(System.in);
                                String CourseName = nameInput.nextLine();
                                System.out.print("\nEnter credits: ");
                                int credits = input.nextInt();
                                Course course = new Course(courseId, CourseName, credits);
                                ses.addCourse(course);
                                System.out.println("Student: " + course.getCourseName() + " has successfully created");
                                System.out.println("At index of: " + ses.displayCourseList().indexOf(course));
                                break;
                            case 2:
                                System.out.println("\nAttempt to remove a course.");
                                System.out.println("\nEnter Course ID: ");
                                String courseRemove = input.nextLine();
                                System.out.println("Attempt to remove the following course: ");
                                ses.getCourse(courseRemove);
                                System.out.println("Deleting...");
                                ses.displayCourseList().remove(ses.getCourseObject(courseRemove));
                                System.out.println("Success!");
                                break;
                            case 3:
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
                            case 4:
                                Scanner idSearch = new Scanner(System.in);
                                String view;
                                System.out.println("Enter the Course ID to view: ");
                                view = idSearch.nextLine();
                                ses.getCourse(view);
                                break;
                            case 5:
                                System.out.println("Here is the list of available courses: ");
                                ses.printCourse();
                                break;
                            default:
                                System.out.println("Choice not found! ");
                                System.out.println("\nDo it again? 1 2 3 4");
                                int choice2 = input.nextInt();
                                courseChoice = choice2;
                                break; }
                    break;
                    case 3:
                        int enrollChoice;
                        System.out.println("[1] Enroll to a Semester");
                        System.out.println("[2] Delete Semester");
                        System.out.println("[3] Update Semester");
                        System.out.println("[4] View Semester Info");
                        System.out.println("[5] View Semester List");
                        System.out.print("Choice: ");
                        enrollChoice = input.nextInt();
                        switch (enrollChoice){
                            case 1:
                                String studentInput;
                                String courseInput;
                                String semesterName;
                                Course courseEnroll;
                                Student studentEnroll;
                                System.out.println("Attempt to enroll a student...");
                                System.out.println("Please be noted that student and course must be created in advance.");
                                Scanner enroll = new Scanner(System.in);
                                System.out.println("Please enter the student ID: ");
                                studentInput = enroll.nextLine();
                                studentEnroll = ses.getStudentObject(studentInput);
                                System.out.println("Please enter the course ID: ");
                                courseInput = enroll.nextLine();
                                courseEnroll = ses.getCourseObject(courseInput);
                                System.out.println("Please enter the semester name: ");
                                semesterName = enroll.nextLine();
                                SemesterEnrollment semester = new SemesterEnrollment(semesterName, studentEnroll, courseEnroll);
                                ses.displaySemesterList().add(semester);
                                System.out.println("Success!");
                                break;
                            case 2:
                                System.out.println("Attempt to delete a semester");
                                String semesterNameDelete;
                                SemesterEnrollment semesterEnrollment;
                                Scanner deleteSemesterInput = new Scanner(System.in);
                                System.out.println("Please enter semester name to delete: ");
                                semesterNameDelete = deleteSemesterInput.nextLine();
                                semesterEnrollment = ses.getSemesterObject(semesterNameDelete);
                                ses.displaySemesterList().remove(semesterEnrollment);
                                System.out.println("Success!");
                                break;
                            case 3:
                                String studentInputUpdate;
                                String courseInputUpdate;
                                String semesterNameUpdate;
                                Course courseEnrollUpdate;
                                Student studentEnrollUpdate;
                                SemesterEnrollment semesterEnrollmentUpdate;
                                System.out.println("Attempt to update a semester...");
                                Scanner enrollUpdate = new Scanner(System.in);
                                System.out.println("Please enter the student ID: ");
                                studentInputUpdate = enrollUpdate.nextLine();
                                studentEnrollUpdate = ses.getStudentObject(studentInputUpdate);
                                System.out.println("Please enter the course ID: ");
                                courseInputUpdate = enrollUpdate.nextLine();
                                courseEnrollUpdate = ses.getCourseObject(courseInputUpdate);
                                System.out.println("Please enter the semester name to update: ");
                                semesterNameUpdate = enrollUpdate.nextLine();
                                semesterEnrollmentUpdate = ses.getSemesterObject(semesterNameUpdate);
                                SemesterEnrollment semesterUpdate = new SemesterEnrollment(semesterNameUpdate, studentEnrollUpdate, courseEnrollUpdate);
                                ses.modifySemester(semesterEnrollmentUpdate, semesterUpdate);
                                studentEnrollUpdate.getCoursesListPersonal().add(courseEnrollUpdate);

                                System.out.println("Success!");
                                break;
                            case 4:

                        }
                        break;
                    default:
                        System.out.println("Choice not found! ");
                        System.out.println("\nDo it again? y/n");
                        String choice3 = input.nextLine().toLowerCase();
                        exit = choice3.charAt(0);
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

