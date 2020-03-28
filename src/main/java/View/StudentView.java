package View;

import Dao.Model.Student;
import Service.CommonUtilityService;
import Service.CommonUtilityServiceImpl;
import Service.StudentService;
import Service.StudentServiceImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

public class StudentView {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {

        StudentService studentServiceObj = new StudentServiceImpl();
        CommonUtilityService commonUtilityServiceObj = new CommonUtilityServiceImpl();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your choice: \n1. ALl Students\n2. Student By Roll No.\n3. Student By Stream\n4. Insert Student in DB\n5. Update Student in DB");
        int choice = scan.nextInt();
        System.out.println("\n\n");
        if (choice == 1) {

            for (Student student : studentServiceObj.getAllStudents()) {
                System.out.println("Name of the Student: " + student.getName());
                System.out.println("Roll No. of the Student: " + student.getRollNo());
                System.out.println("Stream of the Student: " + student.getStream());
                System.out.println("Yearly fee of the Student: " + student.getYearlyFee());
                System.out.println("Joining Date of the Student: " + student.getDateOfJoining());
                System.out.println("\n\n");
            }
        } else if (choice == 2) {

            System.out.println("Enter Roll No. you want to search for: ");
            long studentRoll = scan.nextLong();
            Student newStudent = studentServiceObj.getStudentsByRoll(studentRoll);
            System.out.println("Name of the Student: " + newStudent.getName());
            System.out.println("Roll No. of the Student: " + newStudent.getRollNo());
            System.out.println("Stream of the Student: " + newStudent.getStream());
            System.out.println("Yearly Fee of the Student: " + newStudent.getYearlyFee());
            System.out.println("Joining Date of the Student: " + newStudent.getDateOfJoining());

        } else if (choice == 3) {

            System.out.println("Enter Stream you want to search for: ");
            String studentStream = scan.next();
            for (Student student : studentServiceObj.getStudentsByStream(studentStream)) {
                System.out.println("Name of the Student: " + student.getName());
                System.out.println("Roll No. of the Student: " + student.getRollNo());
                System.out.println("Stream of the Student: " + student.getStream());
                System.out.println("Yearly Fee of the Student: " + student.getYearlyFee());
                System.out.println("Joining Date of the Student: " + student.getDateOfJoining());
            }
        } else if (choice == 4) {

            try {
                System.out.print("Insert Name of the Student: ");
                String studentName = scan.next();
                System.out.print("Insert Roll No. of the Student: ");
                long studentRoll = scan.nextLong();
                System.out.print("Insert Stream of the Student: ");
                String studentStream = scan.next();
                System.out.print("Insert Yearly Fee of the Student: ");
                BigDecimal studentYearlyFee = scan.nextBigDecimal();
                System.out.print("Insert Joining Date of the Student: ");
                String studentDateOfJoining = scan.next();
                Date studentJoiningDate = commonUtilityServiceObj.parseIntoDate(studentDateOfJoining);

                Student newStudent = new Student(studentName, studentRoll, studentStream, studentYearlyFee, studentJoiningDate);

                int count = studentServiceObj.createOrUpdate(newStudent);
                System.out.println("No. of rows affected: " + count);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (choice == 5) {

            try {
                System.out.print("Insert Name of the Student: ");
                String studentName = scan.next();
                System.out.print("Insert Roll No. of the Student: ");
                long studentRoll = scan.nextLong();
                System.out.print("Insert Stream of the Student: ");
                String studentStream = scan.next();
                System.out.print("Insert Yearly Fee of the Student: ");
                BigDecimal studentYearlyFee = scan.nextBigDecimal();
                System.out.print("Insert Joining Date of the Student: ");
                String studentDateOfJoining = scan.next();
                Date studentJoiningDate = commonUtilityServiceObj.parseIntoDate(studentDateOfJoining);

                Student newStudent = new Student(studentName, studentRoll, studentStream, studentYearlyFee, studentJoiningDate);

                int count = studentServiceObj.createOrUpdate(newStudent);
                System.out.println("No. of rows updated: " + count);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
