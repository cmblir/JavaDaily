package ref;

public class VarChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        Data dataB = dataA;

        System.out.println(dataA);
        System.out.println(dataB);
        System.out.println(dataA.value);
        System.out.println(dataB.value);

        dataA.value = 20;
        System.out.println(dataA.value);
        System.out.println(dataB.value);
        // 참조값은 클래스 안에서 값이 변경되므로 변경하지 않아도 dataB의 값은 변경되어 있다.
        // dataA.value = 20 -> Data 클래스의 value값 = 20 -> dataB.value 호출 시 참조값 조회 -> 변경된 20값 호출

        dataB.value = 30;
        // A와 마찬가지로 같은 참조값을 쓰므로 변경하면 A도 변경됨
        System.out.println(dataA.value);
        System.out.println(dataB.value);
    }
}
