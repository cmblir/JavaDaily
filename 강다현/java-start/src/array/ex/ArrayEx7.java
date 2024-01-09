package array.ex;

import java.util.Scanner;

public class ArrayEx7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] subjects = {"국어","영어","수학"};
        System.out.println("학생 수를 입력하세요");
        int studentCount = scanner.nextInt();
        int[][] scores = new int[studentCount][3];



        for(int i=0;i<studentCount;i++){
            System.out.println((i+1)+"번 학생의 성적을 입력하세요 : ");
            for(int j=0;j<scores[i].length;j++){
                System.out.println(subjects[j]+"점수 :");
                scores[i][j] = scanner.nextInt();
            }
        }

        for(int i=0;i<scores.length;i++){
            int total = 0;
            for(int j =0;j<scores[i].length;j++){
                total += scores[i][j];
            }
            double average = total /3.0;
            System.out.println((i+1)+"번 학생의 총점 : "+total+", 평균 : "+average);
        }

    }
}
