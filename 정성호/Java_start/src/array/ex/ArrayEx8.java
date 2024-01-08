package array.ex;

import java.util.Scanner;

public class ArrayEx8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("학생 수를 입력하세요 : ");
        int totalStudents = scanner.nextInt();

        int[][] students = new int[totalStudents][3];
        String[] subjects = {"국어", "영어", "수학"};

        for (int number = 0; number < students.length; number++) {
            System.out.println((number + 1) + "번 학생의 성적을 입력하세요 : ");

            for (int score = 0; score < students[number].length; score++) {
                System.out.print(subjects[score] + " 점수 : ");
                students[number][score] = scanner.nextInt();
            }
        }

        for (int number = 0; number < students.length; number++) {
            int sum = 0;

            for (int score = 0; score < students[number].length; score++) {
                sum += students[number][score];
            }

            double average = (double) sum / students[number].length;
            System.out.println((number + 1) + "번 학생의 총점 : " + sum + ", 평균 : " + average);
        }
    }
}