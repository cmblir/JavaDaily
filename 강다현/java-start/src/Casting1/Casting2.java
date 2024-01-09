package Casting1;

public class Casting2 {
    public static void main(String[] args) {
        double doubleValue = 1.5;
        int intValue = 0;
        //intValue = doubleValue; //컴파일 오류 발생( 소수 부분 날라가기 때문 )
        intValue = (int) doubleValue; //형변환 (casting) 개발자가 직접 형변환 코드를 입력한다고 해서 명시적 형변환이하고 한다.
        //doubleValue의 값을 변경하는 것이 아니라, "읽어 들인 값"을 형변환 하는 것이기 때문에 doubleValue의 값은 변경되지 않는다.
        /*
        casting
        "캐스팅"은 영어 단어 "cast"에서 유래되었다. "cast"는 금속이나 다른 물질을 녹여서 특정한 형태나
        모양으로 만드는 과정을 의미한다.
         */
        System.out.println(intValue); //출력:1
        System.out.println((int) 10.5 );
    }

}
