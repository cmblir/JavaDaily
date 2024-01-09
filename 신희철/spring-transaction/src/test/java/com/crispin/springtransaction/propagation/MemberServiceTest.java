package com.crispin.springtransaction.propagation;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.UnexpectedRollbackException;

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

    /**
     * memberService    @Transaction: ON
     * memberRepository @Transaction: OFF
     * logRepository    @Transaction: OFF
     */
    @Test
    void singleTransaction() {
        // given
        String username = "singleTransaction";

        // when
        memberService.joinV1(username);

        // then
        Assertions.assertThat(memberRepository.find(username)).isPresent();
        Assertions.assertThat(logRepository.find(username)).isPresent();
    }

    /**
     * memberService    @Transaction: ON
     * memberRepository @Transaction: ON
     * logRepository    @Transaction: ON
     */
    @Test
    void outerTransactionOnSuccess() {
        // given
        String username = "outerTransactionOnSuccess";

        // when
        memberService.joinV1(username);

        // then
        Assertions.assertThat(memberRepository.find(username)).isPresent();
        Assertions.assertThat(logRepository.find(username)).isPresent();
    }

    /**
     * memberService    @Transaction: ON
     * memberRepository @Transaction: ON
     * logRepository    @Transaction: ON Exception
     */
    @Test
    void outerTransactionOffFail2() {
        // given
        String username = "로그예외_outerTransactionOffFail2";

        // when
        Assertions.assertThatThrownBy(() ->memberService.joinV1(username))
                .isInstanceOf(RuntimeException.class);

        // then
        Assertions.assertThat(memberRepository.find(username)).isEmpty();
        Assertions.assertThat(logRepository.find(username)).isEmpty();
    }

    /**
     * memberService    @Transaction: ON
     * memberRepository @Transaction: ON
     * logRepository    @Transaction: ON Exception
     */
    @Test
    void recoverExceptionFail() {
        // given
        String username = "로그예외_recoverExceptionFail";

        // when
        Assertions.assertThatThrownBy(() ->memberService.joinV2(username))
                .isInstanceOf(UnexpectedRollbackException.class);

        // then
        Assertions.assertThat(memberRepository.find(username)).isEmpty();
        Assertions.assertThat(logRepository.find(username)).isEmpty();
    }

    /**
     * memberService    @Transaction: ON
     * memberRepository @Transaction: ON
     * logRepository    @Transaction: ON(REQUIRES_NEW) Exception
     */
    @Test
    void recoverExceptionSuccess() {
        // given
        String username = "로그예외_recoverExceptionSuccess";

        // when
        memberService.joinV2(username);

        // then
        Assertions.assertThat(memberRepository.find(username)).isPresent();
        Assertions.assertThat(logRepository.find(username)).isEmpty();
    }
}
