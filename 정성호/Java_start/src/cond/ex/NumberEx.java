package cond.ex;

import java.util.Scanner;

public class NumberEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberA = scanner.nextInt();
        int numberB = scanner.nextInt();
        String result = (numberA > numberB) ? "더 큰 숫자는 " + numberA + "입니다." : "더 큰 숫자는 " + numberB + "입니다.";
        System.out.println(result);
    }

}
