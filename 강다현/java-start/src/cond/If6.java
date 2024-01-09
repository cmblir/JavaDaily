package cond;



public class If6 {
    public static void main(String[] args) {
        int price = 10000;// 아이템 가격
        int age = 10;//나이
        int discount = 0;

        //중복 조건이기 때문에 하나만 만족하면 끝나게 된다.
        if (price >= 10000) {
            discount = discount + 1000;
            System.out.println("10000원 이상 구매, 1000원 할인");
        } else if (age <= 10) {
            discount = discount + 1000;
            System.out.println("어린이 1000원 할인");
        } else {
            System.out.println("할인 없음");
        }
        System.out.println("총 할인 금액: " + discount + "원");

        if(true) System.out.println("내용이 한줄일 경우, 중괄호 생략 가능");
        /*
        가독성 : 중괄호를 사용하면 코드를 더 읽기 쉽다.
        우지 보수 : 중괄호 사용하면 나중에 코드를 수정할 때 오류 덜 발생 가능.
         */
    }
}