package method;

public class Method1 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int sum1 = add(a, b);
        System.out.println(sum1);


    }
    // add 메서드
    public static int add(int a, int b) {
        System.out.println(a + b);
        int sum = a + b;
        return sum;
    }
}
