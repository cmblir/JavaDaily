package Casting1;

public class Casting1 {
    /*
    작은 범위에서 큰 범위로는 당연히 값을 넣을 수 있다. (예 : int ->long->double )
    큰 범위에서 작은 범위는 다음과 같은 문제가 발생할 수 있다. ( 소수점 버림, 오버플로우 )
     */
    public static void main(String[] args) {

        int intValue = 10;
        long longValue;
        double doubleValue;
        //작은 범위의 값을 큰 범위에 넣을때 자동적으로 형변환을 해준다. 이를 자동 형변환, 묵시적 형변환이라고 한다.

        longValue = (long)intValue; // int -> long ( 작은 범위의 int를 큰 범위의 long 변수에 넣는 것은 가능하다. )
        System.out.println("longValue = " + longValue); //longValue = 10
        doubleValue = intValue; // int -> double
        System.out.println("doubleValue1 = " + doubleValue); //doubleValue1 =10.0
        doubleValue = 20L; // long -> double
        System.out.println("doubleValue2 = " + doubleValue); //doubleValue2 =20.0
    }
}
