package construct;

public class ConstructMain1 {
    public static void main(String[] args) {
        MemberConstruct member1 = new MemberConstruct("user1", 15, 90);
        MemberConstruct member2 = new MemberConstruct("user2", 17); // 생성자 오버로딩
        // 생성자는 클래스를 호출 후, 메서드를 한번 더 호출하지는 것을 방지할 수 있다.
        // 추가로 입력값 제한을 줄 수 있으므로 사고를 방지할 수 있다.

        MemberConstruct[] memberConstructs = {member1, member2};

        for (MemberConstruct s : memberConstructs) {
            System.out.println(s.name + s.age + s.grade);
        }

    }
}
