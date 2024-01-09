package variable;
public class Var6 {
    public static void main(String[] args) {
        /*
        variable a might not have been initialized
        변수가 초기화 되지 않았을때 발생하는 컴파일 오류
        why?  컴퓨터에서 메모리는 여러 시스템이 함께 사용하는 공간이다 . 따라서 어떠한 값들이
        계속 저장된다. 변수를 선언하면 메모리상의 어떤 공간을 차지하고 사용한다. 그런데 그 공간에 기존에 어떤 값들이
        존재하고 있었는지 아무도 모른다. 초기화를 하지 않으면 이상한 값이 출력될 수도 있다는 의미인데, 이를 예방하기 위해 자바는 변수를 초기화하도록
        강제한다.
         */
        int a;
        //System.out.println(a); //주석을 풀면 컴파일 에러 발생
    }
}