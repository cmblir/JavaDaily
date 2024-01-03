package static1;

import static2.DecoData;

public class DataCountMain3 {
    public static void main(String[] args) {
        Data3 data1 = new Data3("A");
        System.out.println("A count = " + Data3.count);

        Data3 data2 = new Data3("B");
        System.out.println("A count = " + Data3.count);

        Data3 data3 = new Data3("C");
        System.out.println("A count = " + Data3.count);

        Data3 data4 = new Data3("D");
        System.out.println(data4.count);

        System.out.println(data3.count);
        // 정적 변수에 접근하기 때문에 결과값이 같음

        DecoData decoData3 = new DecoData();
        decoData3.staticCall();

        DecoData.staticCall();
    }
}
