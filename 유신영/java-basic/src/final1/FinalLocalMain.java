package final1;

public class FinalLocalMain {
    public static void main(String[] args) {
        final int data1;
        // final이 붙으면 변경이 불가능함 ~> 최초 1회 할당
        data1 = 10;

        final int data2 = 10;

        method(10);
    }

    static void method(final int parameter) {

    }
}

