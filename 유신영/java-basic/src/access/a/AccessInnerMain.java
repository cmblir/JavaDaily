package access.a;

public class AccessInnerMain {
    public static void main(String[] args) {
        AccessData accessData = new AccessData();
        accessData.publicField = 1;
        accessData.publicMethod();

        accessData.defaultField = 2;
        accessData.defaultMethod();

        accessData.innerAccess();
    }
}
