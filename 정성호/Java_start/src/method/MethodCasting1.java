package method;

public class MethodCasting1 {
    public static void main(String[] args) {
        double number = 1.5;
        printNumber((int) number);
        System.out.println(doubleNumber(number));
    }

    public static void printNumber(int number) {
        System.out.println(number);
    }

    public static double doubleNumber(double number) {
        return number;
    }
}
