package src.array.ex;

import java.util.Scanner;

public class ArrayEx8 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("학생수를 입력하세요 : ");
        int studentNum = scn.nextInt();
        int[][] students = new int[studentNum][3];
        String[] subjects = {"국어", "영어", "수학"};

        for (int i = 0; i < studentNum; i++) {
            System.out.println((i+1) + "번 학생의 성적을 입력하세요");
            for(int j = 0; j < subjects.length; j++){
                System.out.print(subjects[j] + "점수 : ");
                int score = scn.nextInt();
                students[i][j] = score;
            }
        }

        for (int i = 0; i < studentNum; i++) {
            int sumVal = 0;
            for(int j = 0; j < subjects.length; j++){
                sumVal += students[i][j];
            }
            double average = (double) sumVal / subjects.length;

            System.out.println((i+1) +"번 학생의 총점 : " + sumVal + ",평균 : " + average);

        }
    }
}