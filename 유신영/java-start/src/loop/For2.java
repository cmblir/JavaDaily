package loop;

public class For2 {
    public static void main(String[] args) {
        int sum = 0;
        int endNum = 3;

        for (int i = 1; i <= endNum; i++) {
            sum += i;
            // 순서 초기식 -> 조건문 -> 반복문 내 코드 실행 -> 증감식
            System.out.println("i = " + i + ", sum = " + sum);
        }
    }
}
