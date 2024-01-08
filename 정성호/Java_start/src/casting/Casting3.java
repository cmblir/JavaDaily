package casting;

public class Casting3 {
    public static void main(String[] args) {
        long maxIntValue = 2147483647;
        long maxIntOver = 2147483648L;
        int intValue = 0;

        intValue = (int) maxIntValue;
        System.out.println(intValue);

        intValue = (int) maxIntOver;
        // 오버플로우 발생 int 범위를 초과하므로 범위를 다시 돌아서 -부터 출력이 된다.
        System.out.println(intValue);
    }
}
