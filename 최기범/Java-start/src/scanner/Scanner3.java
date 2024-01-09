package src.scanner;

import java.util.Scanner;

public class Scanner3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("첫 번쨰 숫자를 입력하세요 : ");
        int num1 = scn.nextInt();

        System.out.print("두 번째 숫자를 입력하세요 : ");
        int num2 = scn.nextInt();

        if(num1 > num2){
            System.out.println("첫번째 숫자가 더 크다");
        }else if(num1 < num2){
            System.out.println("두번째 숫자가 더 크다");
        }else {
            System.out.println("두 숫자가 같다.");
        }
    }
}
