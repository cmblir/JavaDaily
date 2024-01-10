package src.array;

public class Array1Ref1 {
    public static void main(String[] args) {
        int[] students = new int[5];

        for(int i = 0; i < students.length ; i++) {
            students[i] = 90 - (10 * i);
        }

        for(int i = 0; i < students.length;i++ ){
            System.out.println("학생 " + (i + 1)
                    + "의 점수 : " + students[i]);
        }
    }
}
