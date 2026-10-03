import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String STUDENT_FILE = "students.txt";
    private static final String RESULT_FILE = "results.txt";

    public static void saveStudent(Student student) {

        try (FileWriter writer = new FileWriter(STUDENT_FILE, true)) {

            writer.write(
                student.getStudentId() + "," +
                student.getName() + "," +
                student.getCourse() + "," +
                student.getAge() + "\n"
            );

        } catch (IOException e) {
            System.out.println("Error saving student data.");
        }
    }

    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        File file = new File(STUDENT_FILE);

        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(STUDENT_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 4) {

                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String course = data[2];
                    int age = Integer.parseInt(data[3]);

                    students.add(new Student(id, name, course, age));
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading student data.");
        }

        return students;
    }

    public static void saveAllStudents(ArrayList<Student> students) {

        try (FileWriter writer = new FileWriter(STUDENT_FILE)) {

            for (Student student : students) {

                writer.write(
                    student.getStudentId() + "," +
                    student.getName() + "," +
                    student.getCourse() + "," +
                    student.getAge() + "\n"
                );
            }

        } catch (IOException e) {
            System.out.println("Error updating student data.");
        }
    }

    public static void saveResult(Result result) {

        try (FileWriter writer = new FileWriter(RESULT_FILE, true)) {

            writer.write(
                result.getStudentId() + "," +
                result.getJavaMarks() + "," +
                result.getDbmsMarks() + "," +
                result.getOsMarks() + "\n"
            );

        } catch (IOException e) {
            System.out.println("Error saving result data.");
        }
    }

    public static ArrayList<Result> loadResults() {

        ArrayList<Result> results = new ArrayList<>();

        File file = new File(RESULT_FILE);

        if (!file.exists()) {
            return results;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(RESULT_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 4) {

                    int studentId = Integer.parseInt(data[0]);
                    int javaMarks = Integer.parseInt(data[1]);
                    int dbmsMarks = Integer.parseInt(data[2]);
                    int osMarks = Integer.parseInt(data[3]);

                    results.add(
                        new Result(
                            studentId,
                            javaMarks,
                            dbmsMarks,
                            osMarks
                        )
                    );
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading result data.");
        }

        return results;
    }
}
