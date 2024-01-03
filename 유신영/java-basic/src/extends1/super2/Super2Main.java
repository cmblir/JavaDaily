package extends1.super2;

public class Super2Main {
    public static void main(String[] args) {
        // ClassC classC = new ClassC();
        ClassB classB = new ClassB(100);
        /*
        호출은 C -> B -> A
        최상위 부모부터 하나씩 실행하므로 A -> B -> C
         */
    }
}
