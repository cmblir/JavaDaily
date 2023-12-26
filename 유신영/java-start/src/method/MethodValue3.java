package method;

public class MethodValue3 {
    public static void main(String[] args) {
        int num1 = 5;
        num1 = changeNumber(num1);
        System.out.println(num1);
    }

    public static int changeNumber(int number) {
        number *= 2;
        return number;
    }
}
