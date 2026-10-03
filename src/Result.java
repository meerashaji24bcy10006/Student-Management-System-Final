public class Result {

    private int studentId;
    private int javaMarks;
    private int dbmsMarks;
    private int osMarks;

    public Result(int studentId, int javaMarks, int dbmsMarks, int osMarks) {
        this.studentId = studentId;
        this.javaMarks = javaMarks;
        this.dbmsMarks = dbmsMarks;
        this.osMarks = osMarks;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getJavaMarks() {
        return javaMarks;
    }

    public int getDbmsMarks() {
        return dbmsMarks;
    }

    public int getOsMarks() {
        return osMarks;
    }

    public int calculateTotal() {
        return javaMarks + dbmsMarks + osMarks;
    }

    public double calculateAverage() {
        return calculateTotal() / 3.0;
    }

    public String calculateGrade() {

        double average = calculateAverage();

        if (average >= 90) {
            return "A+";
        } else if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public void displayResult() {

        System.out.println("Student ID : " + studentId);
        System.out.println("Java Marks : " + javaMarks);
        System.out.println("DBMS Marks : " + dbmsMarks);
        System.out.println("OS Marks   : " + osMarks);
        System.out.println("Total      : " + calculateTotal());
        System.out.println("Average    : " + calculateAverage());
        System.out.println("Grade      : " + calculateGrade());
    }
}