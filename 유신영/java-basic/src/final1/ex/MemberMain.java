package final1.ex;

public class MemberMain {
    public static void main(String[] args) {
        Member member = new Member("myId", "kim");
        member.print();
        member.changeData("myId2", "seo");
        // id는 final로 1회만 되고, 이후 변경이 안되서 myId이다.
        member.print();
    }
}
