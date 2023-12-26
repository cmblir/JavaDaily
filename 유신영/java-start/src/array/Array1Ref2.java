package array;

public class Array1Ref2 {
    public static void main(String[] args) {
        int[] students;
        students = new int[5];

        for (int i = 1; i < students.length; i++) {
            students[i] = i;
            System.out.println(students[i]);
        }
    }
}
