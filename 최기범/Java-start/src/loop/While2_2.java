package loop;
public class While2_2 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        sum = sum + i; //sum(0) + i(1) -> sum(1)
        System.out.println("i=" + i + " sum=" + sum);
        i++; //i=2
        sum = sum + i; //sum(1) + i(2) -> sum(3)
        System.out.println("i=" + i + " sum=" + sum);
        i++; //i=3
        sum = sum + i; //sum(3) + i(3) -> sum(6)
        System.out.println("i=" + i + " sum=" + sum);
    }
}