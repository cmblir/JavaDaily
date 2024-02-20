package construct;

public class MethodInitMain1 {
    public static void main(String[] args) {
        MemberInit member1 = new MemberInit();
        member1.name = "user1";
        member1.age = 15;
        member1.grade = 90;

        MemberInit member2 = new MemberInit();
        member2.name = "user2";
        member2.age = 17;
        member2.grade = 80;

        MemberInit[] members = {member1, member2};

        System.out.println(member1);
        System.out.println(member2);

        for (MemberInit s : members) {
            System.out.println(s.name + s.age + s.grade);
        }
    }
    static void initMember(MemberInit member, String name, int age, int grade) {
        member.name = name;
        member.age = age;
        member.grade = grade;
    }
}
