import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager(ArrayList<Student> students) {
        this.students = students;
    }

    public boolean addStudent(Student student) {

        for (Student existingStudent : students) {
            if (existingStudent.getStudentId() == student.getStudentId()) {
                return false;
            }
        }

        students.add(student);
        return true;
    }

    public Student searchStudent(int studentId) {

        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }

        return null;
    }

    public boolean deleteStudent(int studentId) {

        Student student = searchStudent(studentId);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}