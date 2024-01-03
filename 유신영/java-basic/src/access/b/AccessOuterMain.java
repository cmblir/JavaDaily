package access.b;

import access.a.AccessData;
public class AccessOuterMain {
    public static void main(String[] args) {
        AccessData accessData = new AccessData();
        accessData.publicField = 1;
        accessData.publicMethod();

        // public을 제외한 default, private는 다른 패키지 이므로 접근 불가
        accessData.innerAccess();
    }
}
