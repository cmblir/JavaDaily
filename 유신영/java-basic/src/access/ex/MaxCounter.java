package access.ex;

public class MaxCounter {
    private int count = 0;
    private int max;

    public MaxCounter(int number) {
        max = number;
    }

    public void increment() {
        if (max > count) {
            count ++;
        } else {
            System.out.println("최대값을 초과할 수 없습니다.");
            return;
        }
    }

    public int getCount() {
        return max;
    }
}
