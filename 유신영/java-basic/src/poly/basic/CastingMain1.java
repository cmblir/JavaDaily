package poly.basic;

public class CastingMain1 {
    public static void main(String[] args) {
        Parent poly = new Child();

        Child child = (Child) poly;
        // 다운캐스팅 (부모 타입 -> 자식 타입)
        child.childMethod();
    }
}
