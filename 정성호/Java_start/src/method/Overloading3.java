package method;

public class Overloading3 {
    public static void main(String[] args) {
        myMethod(1.2, 1.2);
        myMethod(1, 2);
    }

    public static void myMethod(int a, int b) {
        System.out.println("int");
    }
    public static void myMethod(double a, double b) {
        System.out.println("double");
    }


}
