package scanner;

import java.util.Scanner;

public class ScannerWhile3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;

        while (true) {
            System.out.print("정수를 입력하세요. 8을 입력하면 종료.");
            int number = input.nextInt();

            if (number == 8) {
                break;
            }
        }

    }
}
