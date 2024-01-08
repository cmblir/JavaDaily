package method.ex;

public class MethodEx1 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        System.out.println(average(a, b, c));

        int x = 15;
        int y = 25;
        int z = 35;
        System.out.println(average(x, y, z));
    }

    public static int average(int a, int b, int c) {
        return (a + b + c) / 3;
    }
}
