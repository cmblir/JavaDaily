package array.ex;

import java.util.Scanner;

public class ArrayEx5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력 받을 숫자의 개수를 입력하세요: ");
        int num = scanner.nextInt();
        int[] numbers = new int[num];
        int sum =0;
        double average;

        System.out.println(num + "개의 정수를 입력하세요");
        for(int i=0;i<numbers.length;i++){
            numbers[i] = scanner.nextInt();
            sum +=numbers[i];
        }

        average = (double)sum /5;
        System.out.println("sum = " + sum);
        System.out.println("average = " + average);
    }
}
