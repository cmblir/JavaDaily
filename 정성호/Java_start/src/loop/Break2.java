package loop;

public class Break2 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        for (; ;) {
            // 초기식과 조건문, 증감식을 공백으로 남겨둘 경우 무한루프 생성
            sum += i;
            if (sum > 10) {
                System.out.println("i = " + i + ", sum = " + sum);
                break;
            }
            i++;
        }
        while (true) {
            sum += i;
            if (sum > 20) {
                System.out.println("i = " + i + ", sum = " + sum);
                break;
            }
            i++;
        }
    }
}
