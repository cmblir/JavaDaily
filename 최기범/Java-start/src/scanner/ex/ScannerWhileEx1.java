package src.scanner.ex;

import java.util.Scanner;

public class ScannerWhileEx1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        while(true) {
            System.out.print("이름을 입력하세요(종료를 입력하면 종료) : ");
            String name = scn.nextLine();
            if(name.equals("종료")) {
                break;
            }
            System.out.print("나이를 입력하세요 : ");
            int age = scn.nextInt();
            scn.nextLine();

            System.out.println("입력한 이름 : " + name + ", 나이 : " + age);
        }
    }
}
