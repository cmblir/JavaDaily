package loop.ex;

public class OppEvenEx {
    public static void main(String[] args) {
        for (int num = 2, count = 1; count <= 10; num += 2, count++) {
            count++;
            System.out.println(num);
        }
        int num = 2;
        int count = 1;
        while (count <= 10) {
            System.out.println(num);
            num = num + 2;
            count++;
        }
    }
}
