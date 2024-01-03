package access.b;

import access.a.PublicClass;
public class PublicClassOuterMain {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();

        // Outer의 경우 다른 패키지 접근이 불가능하다.
    }
}
