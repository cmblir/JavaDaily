package com.example.Practice.Member;

public class MemberTest {

    public static void main(String[] args) {
        Member member = new Member();

        MemoryMemberRepository repository = new MemoryMemberRepository();
        repository.clearStore();

        member.setId(1L);
        member.setName("test");

        Long result = member.getId();

        System.out.println(result);

    }
}
