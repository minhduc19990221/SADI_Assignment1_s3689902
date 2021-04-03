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
                                System.out.println("\nEnter Student index: ");
                                int studentIndexRemove = input.nextInt();
                                System.out.println("Removing Student: "+ ses.displayStudentList().get(studentIndexRemove));
                                ses.removeStudent(ses.displayStudentList().get(studentIndexRemove));
                                break;
                            case 3:
                                System.out.println("\n Attempt to edit a student.");
                                System.out.print("\nEnter Student ID: ");
                                String studentIdAdjust = input.next();
                                System.out.print("\nEnter Student name: ");
                                Scanner nameInputAdjust = new Scanner(System.in);
                                String nameAdjust = nameInputAdjust.nextLine();
                                System.out.print("\nEnter Student birthDate (dd/MM/yyyy): ");
                                String dateAdjust = input.next();
                                Date birthDateAdjust = new SimpleDateFormat("dd/MM/yyyy").parse(dateAdjust);
                                Student studentAdjust = new Student(studentIdAdjust, nameAdjust, birthDateAdjust);
                                System.out.println("\n Enter the Student Index: ");
                                int studentIndexAdjust = input.nextInt();
                                ses.modifyStudent(studentAdjust,studentIndexAdjust);
                                break;
                            case 4:
                                int view;
                                System.out.println("Enter the Student Index to view: ");
                                view = input.nextInt();
                                System.out.println("Here is the information of the student: ");
                                System.out.println("Name: " +  ses.getStudent(view).getStudentName());
                                System.out.println("Student ID: " +  ses.getStudent(view).getStudentId());
                                System.out.println("Birthdate: " +  ses.getStudent(view).getBirthDate());
                                break;
                            default:
                                // Remodify this, change studentchoice to int
                                System.out.println("Choice not found! ");
                                System.out.println("\nDo it again? y/n");
                                String choice2 = input.nextLine().toLowerCase();
                                studentChoice = choice2.charAt(0);
                                break; }
                    break;
                    case 2:
                        int courseChoice;
                        System.out.println("[1] Create Course");
                        System.out.println("[2] Delete Course");
                        System.out.println("[3] Modify Course");
                        System.out.println("[4] View Course Info");
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
                                System.out.println("\nEnter Course index: ");
                                int courseIndexRemove = input.nextInt();
                                System.out.println("Removing Student: "+ ses.displayStudentList().get(courseIndexRemove));
                                ses.removeCourse(ses.displayCourseList().get(courseIndexRemove));
                                break;
                            case 3:
                                System.out.println("\n Attempt to edit a student.");
                                System.out.print("\nEnter Course ID: ");
                                String courseIdAdjust = input.next();
                                System.out.print("\nEnter Course name: ");
                                Scanner nameInputAdjust = new Scanner(System.in);
                                String CourseNameAdjust = nameInputAdjust.nextLine();
                                System.out.print("\nEnter credits: ");
                                int creditsAdjust = input.nextInt();
                                Course courseAdjust = new Course(courseIdAdjust, CourseNameAdjust, creditsAdjust);
                                System.out.println("\n Enter the Student Index: ");
                                int courseIndexAdjust = input.nextInt();
                                ses.modifyCourse(courseAdjust,courseIndexAdjust);
                                break;
                            case 4:
                                int view;
                                System.out.println("Enter the Course Index to view: ");
                                view = input.nextInt();
                                System.out.println("Here is the information of the course: ");
                                System.out.println("Course Name: " +  ses.getCourse(view).getCourseName());
                                System.out.println("Course ID: " +  ses.getCourse(view).getCourseId());
                                System.out.println("Credits: " +  ses.getCourse(view).getCredits());
                                break;
                            default:
                                // Remodify this, change coursechoice to int
                                System.out.println("Choice not found! ");
                                System.out.println("\nDo it again? y/n");
                                String choice2 = input.nextLine().toLowerCase();
                                courseChoice = choice2.charAt(0);
                                break; }
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
