package com.example.Practice.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        // givem
        Member member = new Member();
        member.setName("spring");

        // when
        repository.save(member);

        // then
        Member result = repository.findById(member.getId()).get();

        Assertions.assertThat(result).isEqualTo(member);
    }

    @Test
    void findById() {
        // given
        Member member = new Member();
        member.setId(1L);

        // when
        repository.save(member);

        // then
        Member result = repository.findById(member.getId()).get();

        Assertions.assertThat(result).isEqualTo(member);
    }

    @Test
    void findByName() {
        // given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // when

        Member result = repository.findByName(member1.getName()).get();

        // then
        Assertions.assertThat(result).isEqualTo(member1);

    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // where
        List<Member> result = repository.findAll();

        // then
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}