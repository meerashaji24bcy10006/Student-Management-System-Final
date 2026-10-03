import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = FileManager.loadStudents();
        StudentManager studentManager = new StudentManager(students);

        ArrayList<Result> results = FileManager.loadResults();
        ResultManager resultManager = new ResultManager(results);

        while (true) {

            System.out.println();
            System.out.println("=================================");
            System.out.println("      STUDENT MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Add Result");
            System.out.println("7. View Result");
            System.out.println("8. Generate Student Report");
            System.out.println("9. Exit");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 9.");
                scanner.nextLine();
                continue;
            }

            if (choice == 1) {

                System.out.print("Enter Student ID: ");

                int id;

                try {
                    id = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Student ID. Please enter a number.");
                    scanner.nextLine();
                    continue;
                }

                if (!Validation.isValidStudentId(id)) {
                    System.out.println("Invalid Student ID.");
                    continue;
                }

                scanner.nextLine();

                System.out.print("Enter Name: ");
                String name = scanner.nextLine();

                if (!Validation.isValidName(name)) {
                    System.out.println("Name cannot be empty.");
                    continue;
                }

                System.out.print("Enter Course: ");
                String course = scanner.nextLine();

                if (!Validation.isValidCourse(course)) {
                    System.out.println("Course cannot be empty.");
                    continue;
                }

                System.out.print("Enter Age: ");

                int age;

                try {
                    age = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid age. Please enter a number.");
                    scanner.nextLine();
                    continue;
                }

                if (!Validation.isValidAge(age)) {
                    System.out.println("Invalid age. Enter age between 1 and 100.");
                    continue;
                }

                Student student = new Student(id, name, course, age);

                if (!studentManager.addStudent(student)) {
                    System.out.println("Student ID already exists.");
                    continue;
                }

                FileManager.saveStudent(student);

                System.out.println("Student added successfully!");

            } else if (choice == 2) {

                System.out.println();
                System.out.println("---------- STUDENT LIST ----------");

                if (students.isEmpty()) {

                    System.out.println("No students found.");

                } else {

                    for (Student student : students) {
                        student.displayStudent();
                        System.out.println("---------------------------------");
                    }
                }

            } else if (choice == 3) {

                System.out.print("Enter Student ID to search: ");

                int searchId;

                try {
                    searchId = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Student ID. Please enter a number.");
                    scanner.nextLine();
                    continue;
                }

                Student student = studentManager.searchStudent(searchId);

                if (student != null) {

                    System.out.println();
                    System.out.println("Student Found:");
                    student.displayStudent();

                } else {

                    System.out.println("Student not found.");
                }

            } else if (choice == 4) {

                System.out.print("Enter Student ID to update: ");

                int updateId;

                try {
                    updateId = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Student ID. Please enter a number.");
                    scanner.nextLine();
                    continue;
                }

                Student student = studentManager.searchStudent(updateId);

                if (student != null) {

                    scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = scanner.nextLine();

                    System.out.print("Enter New Age: ");

                    int newAge;

                    try {
                        newAge = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid age. Please enter a number.");
                        scanner.nextLine();
                        continue;
                    }

                    if (!Validation.isValidName(newName)
                            || !Validation.isValidCourse(newCourse)
                            || !Validation.isValidAge(newAge)) {

                        System.out.println("Invalid student details.");
                        continue;
                    }

                    student.updateStudent(newName, newCourse, newAge);

                    FileManager.saveAllStudents(students);

                    System.out.println("Student updated successfully!");

                } else {

                    System.out.println("Student not found.");
                }

            } else if (choice == 5) {

                System.out.print("Enter Student ID to delete: ");

                int deleteId;

                try {
                    deleteId = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Student ID. Please enter a number.");
                    scanner.nextLine();
                    continue;
                }

                boolean deleted = studentManager.deleteStudent(deleteId);

                if (deleted) {

                    FileManager.saveAllStudents(students);

                    System.out.println("Student deleted successfully!");

                } else {

                    System.out.println("Student not found.");
                }

            } else if (choice == 6) {

                System.out.print("Enter Student ID: ");

                int studentId;

                try {
                    studentId = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Student ID. Please enter a number.");
                    scanner.nextLine();
                    continue;
                }

                System.out.print("Enter Java Marks: ");
                int javaMarks = scanner.nextInt();

                System.out.print("Enter DBMS Marks: ");
                int dbmsMarks = scanner.nextInt();

                System.out.print("Enter OS Marks: ");
                int osMarks = scanner.nextInt();

                if (!Validation.isValidMarks(javaMarks)
                        || !Validation.isValidMarks(dbmsMarks)
                        || !Validation.isValidMarks(osMarks)) {

                    System.out.println("Invalid marks. Marks must be between 0 and 100.");
                    continue;
                }

                Result result = new Result(
                        studentId,
                        javaMarks,
                        dbmsMarks,
                        osMarks
                );

                resultManager.addResult(result);

                System.out.println("Result added successfully!");

            } else if (choice == 7) {

                System.out.print("Enter Student ID to view result: ");

                int studentId;

                try {
                    studentId = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Student ID. Please enter a number.");
                    scanner.nextLine();
                    continue;
                }

                Result result = resultManager.searchResult(studentId);

                if (result != null) {

                    System.out.println();
                    System.out.println("---------- STUDENT RESULT ----------");

                    result.displayResult();

                } else {

                    System.out.println("Result not found.");
                }

            } else if (choice == 8) {

                System.out.print("Enter Student ID to generate report: ");

                int studentId;

                try {
                    studentId = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Student ID. Please enter a number.");
                    scanner.nextLine();
                    continue;
                }

                Student student = studentManager.searchStudent(studentId);
                Result result = resultManager.searchResult(studentId);

                if (student != null) {

                    ReportGenerator.generateReport(student, result);

                } else {

                    System.out.println("Student not found.");
                }

            } else if (choice == 9) {

                System.out.println("Thank you for using Student Management System.");
                break;

            } else {

                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}