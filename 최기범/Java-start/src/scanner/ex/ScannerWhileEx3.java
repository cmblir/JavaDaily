package src.scanner.ex;

import java.util.Scanner;

public class ScannerWhileEx3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int sum = 0;
        int count = 0;
        int input = 0;

        System.out.println("숫자를 입력하세요. 입력을 중단하려면 -1을 입력하세요 : ");

        while (true) {
            input = scn.nextInt();
            if (input == -1) {
                break;
            }
            sum += input;
            count++;

        }
        double average = (double) sum / count;
        System.out.println("입력한 숫자들의 합계 : " + sum);
        System.out.println("입렫한 숫자들의 평균 : " + average);
    }
}
