package ref;

public class NullMain1 {
    public static void main(String[] args) {
        Data data = null;
        System.out.println(data);
        // null 값을 넣으면 참조가 되지 않는다.
        data = new Data();
        System.out.println(data);
        data = null;
        System.out.println(data);
    }
}
