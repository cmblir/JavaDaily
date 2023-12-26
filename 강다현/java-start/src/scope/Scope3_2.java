package scope;

public class Scope3_2 {
    public static void main(String[] args) {
        //3_1 코드와 다르게 temp의 스코프를 줄임
        int m = 10;
        if (m > 0) {
            int temp = m * 2;
            System.out.println("temp = " + temp);
        }
        System.out.println("m = " + m);
    }
}