package src.method.ex;

public class MethodExRef2 {
    public static void main(String[] args) {
        printMessage(3,"Hello World");
        printMessage(5,"Hello World");
        printMessage(7,"Hello World");
    }

    public static void printMessage(int num, String message) {
        for (int i = 0; i < num; i++) {
            System.out.println(message);
        }
    }
}

