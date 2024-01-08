package method.ex;

public class MethodEx2 {
    public static void main(String[] args) {
        String message = "Hello, world!" ;
        printMessage(3, message);
        printMessage(5, message);
        printMessage(7, message);
    }
    public static void printMessage(int i, String message) {
        if (i > 0) {
            System.out.println(i + "번째" + message);
            i--;
            printMessage(i, message);
        }
    }
}
