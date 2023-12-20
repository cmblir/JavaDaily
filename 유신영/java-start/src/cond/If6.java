package cond;

public class If6 {
    public static void main(String[] args) {
        int price = 10000;
        int age = 10;
        int discount = 0;

        if (price >= 10000) {
            discount += 1000;
        } else if (age <= 10) {
            discount += 1000;
        } else {
            System.out.println("할인 없음");
        }
        System.out.println(discount);
    }
}
