package casting;

public class Casting4 {
    public static void main(String[] args) {
        // 값을 계산하는 과정에서 다른 두 값이 만나면 더 큰 숫자형으로 변환된다.
        // int + double = double
        // 이를 묵시적 형변환 또는 자동 형변환이라함.
        int div1 = 3 / 2;
        System.out.println(div1);

        double div2 = 3 / 2;
        System.out.println(div2);

        double div3 = 3.0 / 2;
        System.out.println(div3);

        double div4 = (double) 3 / 2;
        System.out.println(div4);

        int a = 3;
        int b = 2;
        double result = (double) a / b;
        System.out.println(result);
    }
}
