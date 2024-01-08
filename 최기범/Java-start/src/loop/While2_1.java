package loop;
public class While2_1 {
    public static void main(String[] args) {
        int sum = 0;
        sum = sum + 1; //sum(0) + 1 -> sum(1)
        System.out.println("i=" + 1 + " sum=" + sum);
        sum = sum + 2; //sum(1) + 2 -> sum(3)
        System.out.println("i=" + 2 + " sum=" + sum);
        sum = sum + 3; //sum(3) + 3 -> sum(6)
        System.out.println("i=" + 3 + " sum=" + sum);
    }
}