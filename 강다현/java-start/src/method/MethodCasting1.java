package method;

public class MethodCasting1 {
    public static void main(String[] args) {
        double number = 1.5;
        printNumber((int)number); //그대로 넣으면 컴파일 오료 ( double을 int에 넣기 때문이다. )
    }
    public static void printNumber(int n){
        System.out.println("n = " + n);
    }
}
