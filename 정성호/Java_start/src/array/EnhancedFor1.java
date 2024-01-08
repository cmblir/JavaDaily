package array;

public class EnhancedFor1 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};

        for (int i = 0; i < numbers.length; ++i) {
            int number = numbers[i];
            System.out.println(number);
        }

        for (int number : numbers) {
            // for-each 문 numbers 배열에 있는 만큼 자동으로 number 정수에 할당
            System.out.println(number);
        }

        for (int i = 0; i < numbers.length; ++i) {
            System.out.println(numbers[i]);
        }
    }
}
