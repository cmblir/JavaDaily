package ref;

public class InitMain {
    public static void main(String[] args) {
        InitData data = new InitData();
        System.out.println(data.value1);
        // 초기화만 해서 값이 0이 나옴.
        System.out.println(data.value2);
    }
}
