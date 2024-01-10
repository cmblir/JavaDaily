package src.scanner.ex;

import java.util.Scanner;

public class ScannerWhileEx2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        while(true){
            System.out.print("상품의 가격을 입력하세요(-1을 입력하면 종료) : ");
            int price = scn.nextInt();
            if(price == -1) {
                break;
            }
            System.out.print("구매하려는 수량을 입력하세요 : ");
            int quantity = scn.nextInt();

            int total = price * quantity;

            System.out.println("총 비용 : " + total);

        }

    }
}
