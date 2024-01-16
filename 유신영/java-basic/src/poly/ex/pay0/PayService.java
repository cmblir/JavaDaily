package poly.ex.pay0;

public class PayService {
    public void processPay(String option, int amount) {
        System.out.println("결제를 시작합니다 : option = " + option + ", amount = " + amount);
        Payment payment = Process.findPay(option);
        boolean result = payment.pay(amount);

        if (result) {
            System.out.println("결제가 성공했습니다.");
        } else {
            System.out.println("결제가 실패했습니다.");
        }
    }

    public void processPay(String option) {
        if (option.equals("exit")) {
            System.out.println("프로그램을 종료합니다.");
        }
    }
}
