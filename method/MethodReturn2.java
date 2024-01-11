package src.method;

public class MethodReturn2 {
    public static void main(String[] args) {
        checkAge(18);
    }

    public static void checkAge(int age) {
        if (age < 18) {
            System.out.println(age + "살은 미성년자라 입장이 불가합니다");
        } else {
            System.out.println("성인 : " + age);
        }
    }

}
