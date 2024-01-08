package loop.ex;

import java.util.Scanner;

public class SumEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= max; sum += i, i++) {
        }
        System.out.println(sum);
        int i = 0;
        int whileSum = 0;
        while (i <= max) {
            whileSum += i;
            i++;
        }
        System.out.println(whileSum);
    }
}
