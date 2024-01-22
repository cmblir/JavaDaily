package com.example.Practice.Service;

import com.example.Practice.Member.Member;
import com.example.Practice.Member.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository repository;

    @BeforeEach
    public void beforeEach() {
        repository = new MemoryMemberRepository();
        memberService = new MemberService();
    }

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void join() throws Exception{
        // given
        Member member = new Member();
        member.setName("spring1");

        // when
        Long result = memberService.join(member);

        // then
        Member findMember = repository.findById(result).get();
        Assertions.assertEquals(member.getName(), findMember.getName());
    }

    @Test
    public void findMembers() throws Exception {
        // given
        Member member1 = new Member();
        Member member2 = new Member();

        member1.setName("spring1");
        member2.setName("spring2");

        member1.setId(1L);
        member2.setId(2L);

        // when
        List<Member> result = memberService.findMembers();

        // then
        List<Member> findMemberAll = repository.findAll();
        Assertions.assertEquals(findMemberAll, result);
    }

    @Test
    public void duplicatedMember() throws Exception{
        // given
        Member member1 = new Member();
        Member member2 = new Member();

        member1.setName("spring");
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 값입니다.");
    }
}