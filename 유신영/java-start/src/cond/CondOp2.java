package cond;

public class CondOp2 {
    public static void main(String[] args) {
        int age = 18;
        String status = (age >= 18) ? "성인" : "미성년자";
        // age 18보다 많을 경우 성인, 아닐경우 미성년자
        // 삼항 연산자 또는 조건 연산자인 ? true 출력값 : false 출력값
        System.out.println(status);
        boolean truePerson = status == "성인" ? false : true;
        System.out.println(truePerson);
    }
}
