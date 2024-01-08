package scanner;

import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int intValue = scanner.nextInt();
        double doubleValue = scanner.nextDouble();

        System.out.println(str);
        System.out.println(intValue);
        System.out.println(doubleValue);
    }
}
