package static2;

public class DecoMain2 {
    public static void main(String[] args) {
        String s = "hello java";
        String deco = DecoUtil2.deco(s);
        // 정적 메서드라고 불리는 것으로, 별다른 인스턴스 생성 없이 바로 호출이 가능하다.

        System.out.println("before : " + s);
        System.out.println("after : " + deco);
    }
}
