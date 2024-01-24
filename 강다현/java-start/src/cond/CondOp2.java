package cond;
//삼항연산자 사용
/*
특정 조건에 따라 결과가 나오기 때문에 조건 연산자라고도 한다.
참과 거진에 따라 특정 값을 구하는 삼항 연산자를 사용하면 if문보다 간결한 코드를 작성할 수 잇다.
 */
public class CondOp2 {
    public static void main(String[] args) {
        int age = 19;
        String status = (age>=18) ? "성인" : "미성년자";
        System.out.println("age"+ age+ "status = " + status);

    }
}
