package ref;

public class NullMain3 {
    public static void main(String[] args) {
        BigData bigData = new BigData();
        System.out.println(bigData.count);
        System.out.println(bigData.data);

        System.out.println(bigData.data.value);
        // null 값으로 NullPointerException
    }
}
