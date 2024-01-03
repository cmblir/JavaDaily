package static1;

public class Data3 {
    public String name;
    public static int count; // static 으로 정적 변수, 클래스 변수라고 함.

    public Data3(String name) {
        this.name = name;
        count ++;
    }
}
