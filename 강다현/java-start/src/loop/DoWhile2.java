package loop;
/*
dowhile은 최초 한번은 실행한다.
코드 블록을 실행 후에 조건식을 검증
조건과 상관 없이 한번은 꼭 실행되야 하는 경우 사용
 */
public class DoWhile2 {
    public static void main(String[] args) {
        int i=10;
        do{
            System.out.println("현재 숫자는 : "+i);
            i++;
        }while(i<3);
    }
}
