package method;

import java.util.Scanner;

public class MethodValue1 {
    public static void main(String[] args) {
        int num1 = 12;
        System.out.println(num1);
        int num2 = changeNumber(num1);
        System.out.println(num2);
    }
    
    public static int changeNumber(int number) {
        if (number < 10) {
            return number * 2;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("변경할 숫자를 입력하세요 . : ");
        int changedNumber = scanner.nextInt();
        return changedNumber;
    }
}
