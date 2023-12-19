package operator;

public class OperatorAdd2 {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;

        b = ++a;
        System.out.println(a + b);
        // a + 1 = 2 -> b + a = 2 -> b + a = 4 (전위 증감 연산자)

        a = 1;
        b = 0;
        b = a++;
        System.out.println(a + b);
        // b + a = 1 -> a + 1 = 2 -> b + a = 3 (후위 증감 연산자)
    }
}
