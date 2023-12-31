package memory;

public class JavaMemoryMain2 {
    public static void main(String[] args) {
        System.out.println("main start");
        method1();
        System.out.println("main end");
    }

    static void method1() {
        System.out.println("method1 start");
        Data data1 = new Data(10);
        // 힙 영역에 Data 인스턴스 생성 참조값은 data1에 저장
        method2(data1);
        System.out.println("method1 end");
        // method1이 스택에서 날라가면서 같이 참조값이 제거됨
        // 제거된 이후 힙 영역은 참조가 사라지므로 가비지 컬랙션이 참조가 사라진 힙을 메모리에서 제거됨
    }

    static void method2(Data data2) {
//        System.out.println("method2 start");
        System.out.println("data.value = " + data2.getValue());
        System.out.println("method2 end");
    }
}
