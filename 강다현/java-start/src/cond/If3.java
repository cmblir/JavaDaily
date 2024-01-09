package cond;

/*
이 코드의 단접
불필요한 조건 검사, 코드 효율성,( 조건을 중복 체크함 ) -> else if를 사용하면 불필요한 조건 검사를 피하고
코드의 효율성을 향상시킬 수 있다.
 */


public class If3 {
    public static void main(String[] args) {
        int age = 14;
        if(age <= 7) { //~7: 미취학
            System.out.println("미취학");
        }
        if(age >= 8 && age <= 13) { //8~13: 초등학생
            System.out.println("초등학생");
        }
        if(age >= 14 && age <= 16) { //14~16: 중학생
            System.out.println("중학생");
        }
        if(age >= 17 && age <= 19) { //17~19: 고등학생
            System.out.println("고등학생");
        }
        if(age >= 20) { //20~: 성인
            System.out.println("성인");
        }
    }
}
