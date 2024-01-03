package ref;

public class MethodChange1 {
    public static void main(String[] args) {
        int a = 10;
        System.out.println(a);
        changePrimitive(a);
        System.out.println(a);
    }

    static void changePrimitive(int x) {
        // void는 내부에서만 값을 처리하고, 외부에 영향을 끼치지 않는다.
        // 만약 x 값을 위의 main() 에서 출력하려면 int 로 바꿔줘야한다.
        // static int changePrimitive(int x)
        x = 20;
    }
}
