package src.scanner.ex;

import java.util.Scanner;

public class ScannerEx5 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("첫 번째 숫자를 입력하세요 : ");
        int num1 = scn.nextInt();

        System.out.print("두 번쨰 숫자를 입력하세요 : ");
        int num2 = scn.nextInt();

        if (num1 > num2) {
            int tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        System.out.print("두 숫자 사이의 모든 정수 : ");
        for (int i = num1; i <= num2; i++) {
            System.out.print(i);
            if(i != num2){
                System.out.print(",");
            }
        }

    }
}
