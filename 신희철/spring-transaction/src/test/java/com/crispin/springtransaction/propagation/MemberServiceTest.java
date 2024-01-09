package com.crispin.springtransaction.propagation;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    LogRepository logRepository;

    /**
     * memberService    @Transaction: OFF
     * memberRepository @Transaction: ON
     * logRepository    @Transaction: ON
     */
    @Test
    void outerTransactionOffSuccess() {
        // given
        String username = "outerTransactionOffSuccess";

        // when
        memberService.joinV1(username);

        // then
        Assertions.assertThat(memberRepository.find(username).isPresent()).isTrue();
        Assertions.assertThat(logRepository.find(username).isPresent()).isTrue();
    }

    /**
     * memberService    @Transaction: OFF
     * memberRepository @Transaction: ON
     * logRepository    @Transaction: ON Exception
     */
    @Test
    void outerTransactionOffFail() {
        // given
        String username = "로그예외_outerTransactionOffFail";

        // when
        Assertions.assertThatThrownBy(() ->memberService.joinV1(username))
                .isInstanceOf(RuntimeException.class);

        // then
        Assertions.assertThat(memberRepository.find(username)).isPresent();
        Assertions.assertThat(logRepository.find(username)).isEmpty();
    }
}