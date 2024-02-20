package scanner.ex;

import java.util.Scanner;

public class MultiplicationEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구구단의 단 수를 입력하세요 : ");
        int n = scanner.nextInt();
        for (int i = 1; i <= 9 ; i++) {
            System.out.println(n + " x " + i + " = " + n * i);
        }
    }
}
