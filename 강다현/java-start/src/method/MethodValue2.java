package method;

public class MethodValue2 {
    //자바는 항상 값을 복사해서 사용
    public static void main(String[] args) {
        int num1 = 5;
        System.out.println("1. changeNumber 호출 전, num1: " + num1);//5
        num1 = changeNumber(num1);
        System.out.println("4. changeNumber 호출 후, num1: " + num1);//5
    }
    public static int changeNumber(int number) {
        System.out.println("2. changeNumber 변경 전, num2: " + number);//5
        number = number * 2;
        System.out.println("3. changeNumber 변경 후, num2: " + number);//10
        return number;
    }
}
