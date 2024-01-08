package method;

import java.util.Scanner;

public class MethodReturn2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputAge = scanner.nextInt();
        checkAge(inputAge);
    }

    public static void checkAge(int number) {
        if (number >= 18) {
            System.out.println(number + "살, 입장하세요.");
            return;

        } else if (number < 18) {
            System.out.println(number + "살, 미성년자는 입장이 불가합니다.");
        }
    }
}
