package array.ex;

public class ArrayEx1 {
    public static void main(String[] args) {
        int[] students = new int[5];
        int total = 0;

        for (int i = 90, count = 0; count < students.length; count++, i -= 10) {
            students[count] = i;
            total += students[count];
        }

        double average = (double) total / students.length;
        System.out.println("점수 총합 : " + total);
        System.out.println("점수 평균 : " + average);
    }

}
