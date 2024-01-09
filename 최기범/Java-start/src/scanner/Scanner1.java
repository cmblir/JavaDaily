package src.scanner;

import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("문자열을 입력하세요 : ");
        String str = scn.nextLine();
        System.out.println("입력한 문자열 : " + str);

        System.out.print("정수를 입력하세요 : ");
        int intValue = scn.nextInt();
        System.out.println("입력한 정수 : " + intValue);

        System.out.print("실수를 입력하세요 : ");
        double doubleValue = scn.nextDouble();
        System.out.println("입력한 실수 : " + doubleValue);
    }
}
