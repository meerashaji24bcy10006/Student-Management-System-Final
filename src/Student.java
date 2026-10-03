public class Student extends Person {

    private int studentId;
    private String course;

    public Student(int studentId, String name, String course, int age) {
        super(name, age);
        this.studentId = studentId;
        this.course = course;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getAge() {
        return age;
    }

    public void updateStudent(String name, String course, int age) {
        this.name = name;
        this.course = course;
        this.age = age;
    }

    public void displayStudent() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Course     : " + course);
        System.out.println("Age        : " + age);
    }
}