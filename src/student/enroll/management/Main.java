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
                System.out.print("Choice:");
                choice = Integer.parseInt(br.readLine());
                switch (choice){
                    case 1:
                        System.out.println("\nEnter Student ID");
                        String studentId = input.nextLine();
                        System.out.println("\nEnter Student name");
                        String name = input.nextLine();
                        System.out.println("\nEnter Student birthDate (dd/MM/yyyy)");
                        String date = input.nextLine();
                        Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                        Student student = new Student(studentId, name, birthDate);
                        ses.addStudent(student);
                        System.out.println("Student: " + student.getStudentName() + " has successfully created");
                        break;
                    case 2:
                        System.out.println("Enter CourseID: ");
                        String courseID = input.nextLine();
                        System.out.println("Enter Course name: ");
                        String courseName = input.nextLine();
                        System.out.println("Enter required credits: ");
                        int credits = input.nextInt();
                        Course course = new Course(courseID,courseName,credits);
                        System.out.println("Course: " + course.getCourseName() +"has successfully created");
                        ses.addCourse(course);
                        break;

                    default:
                        System.out.println("Choice not found! ");
                        System.out.println("\nDo it again? y/n");
                        String choice1 = input.nextLine().toLowerCase();
                        exit = choice1.charAt(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
