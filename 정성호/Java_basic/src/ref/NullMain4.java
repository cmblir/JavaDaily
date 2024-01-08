package ref;

public class NullMain4 {
    public static void main(String[] args) {
        BigData bigData = new BigData();
        // bigData 변수에 BigData() 클래스 참조
        bigData.data = new Data();
        // 참조된 BigData에서 data에 있는 Data 클래스 참조
        System.out.println(bigData.count);
        System.out.println(bigData.data);
        System.out.println(bigData.data.value);
    }
}
