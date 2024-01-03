package ref;

public class VarChange1 {
    public static void main(String[] args) {
        int a = 10;
        int b = a;
        System.out.println(a);
        System.out.println(b);

        a = 20;
        System.out.println(a);
        System.out.println(b);

        b = 30;
        System.out.println(a);
        System.out.println(b);
    }
}
