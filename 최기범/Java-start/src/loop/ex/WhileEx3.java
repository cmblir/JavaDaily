package src.loop.ex;

public class WhileEx3 {
    public static void main(String[] args) {
        int max = 100;

        int sum = 0;
        int i = 1;
        while (i <= 100) {
            sum += i;
            i += 1;
        }
        System.out.println(sum);

    }
}
