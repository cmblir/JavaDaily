package array.ex;

import java.util.Scanner;

public class ArrayEx5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력받을 숫자의 개수를 입력하세요 : ");
        int length = scanner.nextInt();
        int sum = 0;
        System.out.println(length + "개의 정수를 입력하세요 : ");
        for (int i = 0; i < length; i++) {
            sum += scanner.nextInt();
        }
        double average = (double) sum / length;
        System.out.println("입력한 정수의 합계 : " + sum);
        System.out.println("입력한 정수의 평균 : " + average);
    }
}
