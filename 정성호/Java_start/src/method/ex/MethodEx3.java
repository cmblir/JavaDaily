package method.ex;

import java.util.Scanner;

public class MethodEx3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("은행 앱을 사용합니다. 사용하실 메뉴를 선택하세요. ");
        int balance = 0;

        while (true) {
            System.out.println("1. 잔액 조회, 2. 입금, 3. 출금, 4. 종료");

            int number = scanner.nextInt();


            switch (number) {
                case 1:
                    System.out.println(balance);
                    break;
                case 2:
                    System.out.print("입금할 금액을 입력하세요. : ");
                    int depositAmount = scanner.nextInt();
                    balance = deposit(balance, depositAmount);
                    break;
                case 3:
                    System.out.print("출금할 금액을 입력하세요. : ");
                    int withdrawAmount = scanner.nextInt();
                    if (balance < withdrawAmount) {
                        System.out.println(withdrawAmount + "원을 출금하려 했으나, 잔액이 부족합니다.");
                        break;
                    } else {
                        balance = withdraw(balance, withdrawAmount);
                        break;
                    }
                case 4:
                    System.out.println("앱을 종료합니다.");
                    return;
            }
        }
    }
    public static int deposit(int balance, int money) {
        System.out.println(money + "원을 입금하였습니다. 현재 잔액 : " + (balance + money));
        return balance + money;
    }

    public static int withdraw(int balance, int money) {
        System.out.println(money + "원을 출금하였습니다. 현재 잔액 : " + (balance - money));
        return balance - money;
    }
}
