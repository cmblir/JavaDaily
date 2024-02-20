package class1.ex;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductOrderMain1 {
    public static void main(String[] args) {

        ProductOrder tofu = new ProductOrder();
        ProductOrder kimchi = new ProductOrder();
        ProductOrder coke = new ProductOrder();

        tofu.productName = "두부";
        kimchi.productName = "김치";
        coke.productName = "콜라";

        tofu.price = 2000;
        kimchi.price = 5000;
        coke.price = 1500;

        tofu.quantity = 2;
        kimchi.quantity = 1;
        coke.quantity = 2;

        ProductOrder[] productOrders = {tofu, kimchi, coke};
        int totalAmount = 0;

        for (ProductOrder p : productOrders) {
            totalAmount += p.price * p.quantity;
            System.out.println("상품명: " + p.productName + ", 가격: " + p.price + ", 수량: " + p.quantity);
        }

        System.out.println("전체 금액 : " + totalAmount);

        /*
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Integer> prices = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        while (true) {
            System.out.println("종료를 원할 경우 1을 입력하세요. 아닐 경우 2를 입력하세요. ");
            int number = scanner.nextInt();
            if (number == 1) {
                System.out.println("종료합니다.");
                break;
            }

            System.out.print("상품명을 입력하세요. : ");
            scanner.nextLine();
            productNames.add(scanner.nextLine());

            System.out.print("상품가격을 입력하세요. : ");
            prices.add(scanner.nextInt());
            scanner.nextLine();

            System.out.print("상품수량을 입력하세요. : ");
            quantities.add(scanner.nextInt());
            scanner.nextLine();
        }

        for (int i = 0; i < productNames.size(); i++) {
            ProductOrder po = new ProductOrder();
            po.productName = productNames.get(i);
            po.price = prices.get(i);
            po.quantity = quantities.get(i);
            System.out.println("상품명: " + po.productName + ", 가격: " + po.price + ", 수량: " + po.quantity);
        }
         */
    }
}
