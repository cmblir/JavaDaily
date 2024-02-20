package method;

public class MethodCasting2 {
    public static void main(String[] args) {
        int number = 100;
        printNumber(number);
    }
    //double에 int 넣는 것은 가능 ( 큰 값에 작은 값을 넣기 떄문 )
    private static void printNumber(double number) {
        System.out.println("number = " + number);
    }
}
