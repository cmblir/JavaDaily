package static2;
import static static2.DecoData.*;
// 정적 메서드를 import를 해서 사용하기
public class DecoDataMain {
    public static void main(String[] args) {
        System.out.println("1. 정적 호출");
        DecoData.staticCall();

        System.out.println("2. 인스턴스 호출");
        DecoData decoData = new DecoData();
        decoData.instanceCall();

        System.out.println("3. 인스턴스 호출2");
        DecoData decoData1 = new DecoData();
        decoData1.instanceCall();

        staticCall();
    }
}
