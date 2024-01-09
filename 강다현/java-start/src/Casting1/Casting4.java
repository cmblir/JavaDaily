package Casting1;

public class Casting4 {
    /*

    자바에서 계산은 다음 2가지를 기억하자.

    1. 같은 타입끼리의 계산은 같은 타입의 결과를 낸다.
    -> int + int 는 int를 , double + double은 double의 결과가 나온다.


    2. 서로 다른 타입의 계산은 큰 범위로 자동 형변환이 일어난다.
    -> int + long은 long + long으로 자동 형변환이 일어난다.
    -> int + double은 double + double로 자동 형변환이 일어난다.

    좋은 프로그램은 무한한 자유가 있는 프로그램이 아니라 적절한 제약이 있는 프로그램이다.


     */
    public static void main(String[] args) {
        int div1 = 3 / 2; //int - int 여서 int가 나옴
        System.out.println("div1 = " + div1); //1

        double div2 = 3 / 2;
        //double div2 = 1;
        //doueble div2 = (double)1;
        System.out.println("div2 = " + div2); //1.0


        double div3 = 3.0 / 2; //double - int 여서 double로 형변환 발생한다.
        System.out.println("div3 = " + div3); //1.5


        double div4 = (double) 3 / 2; //명시적 형변환 사용. double - int 여서 double로 형변환 발생한다.
        System.out.println("div4 = " + div4); //1.5


        int a = 3;
        int b = 2;
        double result = (double) a / b; // a를 double 형으로 캐스팅
        System.out.println("result = " + result); //1.5
    }
}