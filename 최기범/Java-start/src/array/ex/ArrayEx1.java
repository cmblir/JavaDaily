package src.array.ex;

public class ArrayEx1 {
    public static void main(String[] args) {
        int[] students = new int[]{50, 60, 70, 70, 80};
        int total = 0;

        for (int student : students) {
            total += student;
        }

        double average = (double) total / students.length;
        System.out.println("점수 총합 : " + total);
        System.out.println("점수 평균 : " + average);
    }

}
