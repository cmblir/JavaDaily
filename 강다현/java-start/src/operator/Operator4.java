package operator;

public class Operator4 {
    public static void main(String[] args) {
        int sum3 = 2*2+3*3; //(2*2) + (3*3)
        int sum4 = (2*2)+(3*3); //더 복잡할 경우, 명시적으로 괄호를 적어주는 것이 더 알아보기 쉽다.
        //명확하고 단순한 것이 더 유지보수 하기 좋다.
        System.out.println("sum3 = " + sum3);
        System.out.println("sum4 = " + sum4);

        /*
        연산자 우선순위?
        괄호() 가 우선순위가 가장 높고, 대입 연산자(=)가 우선순위가 가장 낮다.

        1. 상식 건에서 우선순위를 사용하자
        2. 애매하면 괄호()를 사용하자


         */
    }
}
