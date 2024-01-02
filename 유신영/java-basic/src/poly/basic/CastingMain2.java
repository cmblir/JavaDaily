package poly.basic;

public class CastingMain2 {
    public static void main(String[] args) {
        Parent poly = new Child();

        ((Child) poly).childMethod();
        // 일시적 다운캐스팅 - 해당 메서드를 호출하는 순간만 다운캐스팅
    }
}
