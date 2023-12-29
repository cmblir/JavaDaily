package scanner;

import java.util.Scanner;

public class ScannerWhile2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("첫 번째 숫자와 두 번째 숫자 모두 8이면 프로그램을 종료합니다.");

        while (true) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            if (num1 == num2 && num1 == 8) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            System.out.println("두 수가 8이 아니므로 계속합니다.");
        }
    }
}
