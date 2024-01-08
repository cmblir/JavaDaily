package ref;

public class Method2 {
    public static void main(String[] args) {
        // public은 접근 지정자이다.
        Student student1 = createStudent("학생1", 15, 90);
        Student student2 = createStudent("학생2", 16, 80);

        printStudent(student1);
        printStudent(student2);
    }

    static Student createStudent(String name, int age, int grade) {
        // Student 클래스를 반환타입으로 지정한다.
        Student student = new Student();
        student.name = name;
        student.age = age;
        student.grade = grade;
        return student;
    }
    static void printStudent(Student student) {
        // void는 메소드 반환 타입을 지정하는 키워드이다.
        System.out.println(student.name + student.age + student.grade);
    }
}
