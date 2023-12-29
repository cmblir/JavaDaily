package cond;

public class If5 {
    public static void main(String[] args) {
        int item = 10000, age = 10;
        int result = 0;
        int discount = 0;
        if (age <= 10) {
            discount += 1000;
            result = item - discount;
        }
        if (item >= 10000) {
            discount += 1000;
            result = item - discount;
        }

        /*
        if (age <= 10 && item >= 10000) {
            result = item - 2000;
        }
        */
        System.out.println(result);
    }
}
