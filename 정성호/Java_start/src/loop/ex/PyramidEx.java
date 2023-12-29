package loop.ex;

import java.util.Scanner;

public class PyramidEx {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // int rows = scanner.nextInt();
        int rows = 5;

        for (int i = 1; i <= rows; i++) {
            for (int j  = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
