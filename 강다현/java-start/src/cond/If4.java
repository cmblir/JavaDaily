package cond;

/*
조건이 서로 영샹을 주지 않고 각각 수행해야 하는 경우에는 else if문을 사용하면 안되고,
대신에 여러 if문을 분리해서 사용해야 한다. 여러 독립적인 조건을 검사해야 하는 경우가
그런 상황의 대표적인 예시이다.
 */

public class If4 {
    public static void main(String[] args) {
        int age = 14;
        if(age <= 7) {
            System.out.println("미취학");
        } else if(age <= 13) { //앞의 조건 체크하고, 넘어옴 ( 즉, 앞의 조건도 포함 )
            System.out.println("초등학생");
        } else if( age <= 16) {
            System.out.println("중학생");
        } else if(age <= 19) {
            System.out.println("고등학생");
        } else {
            System.out.println("성인");
        }
    }
}
