package scanner.ex;

import java.util.Scanner;

public class BetweenEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("첫 번째 숫자를 입력하세요 : ");
        int num1 = scanner.nextInt();
        System.out.println("두 번째 숫자를 입력하세요 : ");
        int num2 = scanner.nextInt();
        System.out.print("두 숫자 사이의 모든 정수 : ");
        int temp;
        if (num1 > num2) {
            temp = num2;
            num2 = num1;
            num1 = temp;
        }
        for (int i = num1; i < num2; i++) {
            System.out.print(i + ", ");
        }
        System.out.print(num2);
    }
}
