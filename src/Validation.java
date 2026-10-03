public class Validation {

    public static boolean isValidAge(int age) {
        return age >= 1 && age <= 100;
    }

    public static boolean isValidMarks(int marks) {
        return marks >= 0 && marks <= 100;
    }

    public static boolean isValidStudentId(int studentId) {
        return studentId > 0;
    }

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidCourse(String course) {
        return course != null && !course.trim().isEmpty();
    }
}
