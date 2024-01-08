package ref;

public class MethodChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        changeReference(dataA);
        System.out.println(dataA.value);
    }

    static void changeReference(Data dataX) {
        dataX.value = 20;
        // 메서드를 호출할 때 변수의 참조값에 의해서 값이 변경된다.
        // 즉슨, 기본형은 호출자의 변수 값에 영향을 주지 않고 참조형은 호출자의 객체도 변경이 가능하다.
    }
}
