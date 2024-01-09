package loop;
/*
for문은 초기화 , 조건 검사, 반복 후 작업 등이 규칙적으로 한줄에 모두 들어 있어
코드를 이해하기 더 쉽다. 반복을 위해 값이 증가하는 카운터 변수를 다른 부분과 명확하게
구분할 수 있다.
 */
public class For2 {
    public static void main(String[] args) {
        int sum =0;
        int endNum = 3;

        for(int i=1;i<=endNum;i++){
            sum += i;
            System.out.println("i="+i+"sum="+sum);
        }
    }
}
