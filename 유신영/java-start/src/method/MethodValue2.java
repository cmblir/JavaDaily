package method;

public class MethodValue2 {
    public static void main(String[] args) {
        int number = 5;
        changeNumber(number);
    }
    public static void changeNumber (int number) {
        number = number * 2;
        System.out.println(number);
    }
}
