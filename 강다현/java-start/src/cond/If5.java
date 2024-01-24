package cond;

/*
조건이 서로 영샹을 주지 않고 각각 수행해야 하는 경우에는 else if문을 사용하면 안되고,
대신에 여러 if문을 분리해서 사용해야 한다. 여러 독립적인 조건을 검사해야 하는 경우가
그런 상황의 대표적인 예시이다. 
 */

public class If5 {
    public static void main(String[] args) {
        int age = 10;
        int price = 10000;
        int discount =0;

        if(price >=10000){
            discount = discount+1000;
            System.out.println("10000원 이상 구매, 1000원 할인");
        }

        if(age<=10){
            discount = discount+1000;
            System.out.println("어린이 1000원 할인");

        }
        System.out.println("총 할인 금액 : "+discount+"원");
    }
}
