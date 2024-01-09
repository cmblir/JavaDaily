package src.scanner;

import java.util.Scanner;

public class Scanner2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("첫 번쨰 숫자를 입력하세요 : ");
        int num1 = scn.nextInt();

        System.out.print("두 번째 숫자를 입력하세요 : ");
        int num2 = scn.nextInt();
        int sum = num1 + num2;
        System.out.println("두 숫자의 합 : " + sum);
    }
}
