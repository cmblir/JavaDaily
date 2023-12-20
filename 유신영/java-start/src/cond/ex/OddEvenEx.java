package cond.ex;

import java.util.Scanner;

public class OddEvenEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        String result = x % 2 == 0 ? "짝수" : "홀수";
        System.out.println("x : " + x);
        System.out.println("출력 : x = " + x + ", " + result);
    }
}
