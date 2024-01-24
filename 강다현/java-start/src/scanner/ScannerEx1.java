package scanner;

import java.util.Scanner;

public class ScannerEx1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("당신의 이름을 입력하세요:");
        String name = scanner.nextLine(); // 이름을 입력받는다.
        System.out.print("당신의 나이를 입력하세요:");
        int age = scanner.nextInt(); // 나이를 입력받는다. 나이는 정수이므로 nextInt()를사용한다.
        System.out.println("당신의 이름은 " + name + "이고, 나이는 " + age + "살입니다.");
    }
}