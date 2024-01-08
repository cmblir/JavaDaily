package scanner.ex;

import java.util.Scanner;

public class EvenObbEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("하나의 정수를 입력하세요 : ");
        int number = scanner.nextInt();
        System.out.print("입력한 숫자 " + number);
        if (number % 2 == 0) {
            System.out.println("는 짝수입니다.");
            } else {
            System.out.println("는 홀수입니다.");
        }
        }
    }
