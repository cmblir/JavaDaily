package scanner.ex;

import java.util.Scanner;

public class MedianEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        while (true) {
            int num = scanner.nextInt();
            if (num == -1) {
                System.out.println("입력한 숫자들의 합계 : " + sum);
                System.out.println("입력한 숫자들의 합계 : " + sum / count);
                break;
            } else {
                count++;
                sum += num;
            }
        }
    }
}
