package array.ex;

import java.util.Scanner;

public class ArrayEx9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. 상품 등록 | 2. 상품 목록 | 3. 종료");

        String[] productNames = new String[10];
        int[] productPrices = new int[10];
        int productCount = 0;

        for (int i = 0; i <= 10; i++) {
            System.out.print("메뉴를 선택하세요 : ");
            int number = scanner.nextInt();

            if (i == 10) {
                System.out.println("더 이상 상품을 등록할 수 없습니다.");
                break;
            }

            switch (number) {
                case 1:
                    System.out.print("상품 이름을 입력하세요 : ");
                    scanner.nextLine(); // 바로 입력받으면 입력 버퍼 이슈가 발생해서 다음줄까지 바로 출력됨
                    // 그러므로 개행 문자가 즉시 읽혀버려 새로운 입력 기회가 사라짐.
                    productNames[i] = scanner.nextLine();

                    System.out.print("상품 가격을 입력하세요 : ");
                    productPrices[i] = scanner.nextInt();
                    scanner.nextLine();

                    productCount += 1;
                    break;
                case 2:
                    if (productCount < 1) {
                        System.out.println("등록된 상품이 없습니다.");
                        break;
                    }
                    for (int j = 0; j < productCount; j++) {
                        System.out.println(productNames[j] + " : " + productPrices[j] + "원");
                    }
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    break;
            }
            break;
        }
    }
}
