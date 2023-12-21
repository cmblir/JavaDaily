package loop;

public class Nested1 {
    public static void main(String[] args) {
        for (int i = 0; ;) {
            System.out.println(i);
            i++;
            if (i > 2) {
                break;
            }
            for (int j = 0; j < 3; j = j + i) {
                System.out.println(j);
            }
        }
    }
}
