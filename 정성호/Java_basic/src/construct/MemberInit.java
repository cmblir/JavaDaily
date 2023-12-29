package construct;

public class MemberInit {
    String name; // <- 멤버 변수
    int age;
    int grade;

    // 추가
    void initMember(String name, int age, int grade) {
        this.name = name; // 멤버 변수에 접근하는 방법중 하나로 this 이다.
        // this를 사용하면 인스턴스 자신의 참조값을 가리킨다.
        // 여기서 name = name을 하게 되면, 매개변수이므로 멤버 변수에는 변화를 주지 않는다.
        // 이는 매개변수의 변수명이 멤버 변수랑 같은 경우 사용하고, 아니라면 굳이 안써도 되긴한다.
        this.age = age;
        this.grade = grade;
    }
}
