public class ReportGenerator {

    public static void generateReport(Student student, Result result) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("          STUDENT ACADEMIC REPORT");
        System.out.println("========================================");

        student.displayStudent();

        System.out.println("----------------------------------------");

        if (result != null) {
            result.displayResult();
        } else {
            System.out.println("Result not available.");
        }

        System.out.println("========================================");
    }
}