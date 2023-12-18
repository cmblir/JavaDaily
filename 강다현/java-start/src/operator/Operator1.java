package operator;

public class Operator1 {
    public static void main(String[] args) {
        //변수 초기화
        int a=5;
        int b=2;
        //덧셈
        int sum = a+b;
        System.out.println("sum = " + sum); //출력 a+b =7
        //뺄셈
        int diff = a-b;
        System.out.println("diff = " + diff);
        //곱셈
        int multi = a*b;
        System.out.println("multi = " + multi);
        //나눗셈
        int div = a/b;//결과는 2.5인데, int 형 이므로 소숫점 날라감
        System.out.println("div = " + div);
        //나머지
        int mod = a%b; //  5/2 = 2. 5%2 = 1
        System.out.println("mod = " + mod);

        //int z = 10/0; //ArithmeticException 예외발생


    }
}
