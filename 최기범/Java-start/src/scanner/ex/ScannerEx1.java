package src.scanner.ex;

import java.util.Scanner;

public class ScannerEx1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("당신의 이름을 입력하세요 : ");
        String name = scn.nextLine();

        System.out.print("당신의 나이를 입력하세요 : ");
        int age = scn.nextInt();

        System.out.println("당신의 이름은 " + name + "이고, 나이는 " + age + "살입니다.");
    }
}
