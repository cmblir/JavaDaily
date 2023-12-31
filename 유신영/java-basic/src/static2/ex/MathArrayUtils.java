package static2.ex;

public class MathArrayUtils {

    private MathArrayUtils() {
        // private 인스턴스 생성을 막는다.
    }

    public static int sum(int[] array) {
        int sumNum = 0;
        for (int i = 0; i < array.length; i++) {
            sumNum += array[i];
        }
        return sumNum;
    }

    public static double average(int[] array) {
        return (double) sum(array) / array.length;
    }

    public static int min(int[] array) {
        int minNum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (minNum > array[i]) {
                minNum = array[i];
            }
        }
        return minNum;
    }

    public static int max(int[] array) {
        int maxNum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (maxNum < array[i]) {
                maxNum = array[i];
            }
        }
        return maxNum;
    }
}
