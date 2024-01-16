package poly.ex.pay0;

import java.util.Scanner;

public class PayMain0 {
    public static void main(String[] args) {
        PayService payService = new PayService();

        //kakao 결제
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("결제 수단을 입력하세요:");
            String payOption = scanner.next();

            if (payOption.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                scanner.nextLine();
                System.out.print("결제 금액을 입력하세요:");
                int amount = scanner.nextInt();
                payService.processPay(payOption, amount);
            }
        }

    }
}