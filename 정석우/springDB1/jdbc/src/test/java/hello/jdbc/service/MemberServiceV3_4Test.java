package hello.jdbc.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV3;
import lombok.extern.slf4j.Slf4j;

import static hello.jdbc.connection.ConnectionConst.*;

import java.sql.SQLException;

import javax.sql.DataSource;

/*
 * 트랜잭션 - DataSource, transactionManager 자동 등록
 * 
 */
@Slf4j
@SpringBootTest
public class MemberServiceV3_4Test {

	public static final String MEMBER_A = "memberA";
	public static final String MEMBER_B = "memberB";
	public static final String MEMBER_EX = "ex";

	@Autowired
	private MemberRepositoryV3 memberRepository;
	@Autowired
	private MemberServiceV3_3 memberService;

	@TestConfiguration
	static class TestConfig {

		@Autowired
		private DataSource dataSource;
		
		@Bean
		MemberRepositoryV3 memberRepositoryV3() {
			return new MemberRepositoryV3(dataSource);
		}

		@Bean
		MemberServiceV3_3 memberServiceV3_3() {
			return new MemberServiceV3_3(memberRepositoryV3());
		}
	}

	@AfterEach
	void after() throws SQLException {
		memberRepository.delete(MEMBER_A);
		memberRepository.delete(MEMBER_B);
		memberRepository.delete(MEMBER_EX);
	}

	@Test
	@DisplayName("정상 이체")
	void accountTransfer() throws SQLException {
		Member memberA = new Member(MEMBER_A, 10000);
		Member memberB = new Member(MEMBER_B, 10000);
		this.memberRepository.save(memberA);
		this.memberRepository.save(memberB);

		memberService.accountTransfer(memberA.getMemberId(), memberB.getMemberId(), 2000);

		Member findMemberA = memberRepository.findById(memberA.getMemberId());
		Member findMemberB = memberRepository.findById(memberB.getMemberId());

		Assertions.assertThat(findMemberA.getMoney()).isEqualTo(8000);
		Assertions.assertThat(findMemberB.getMoney()).isEqualTo(12000);
	}

	@Test
	void AopCheck() {
		log.info("memberService class = {}", memberService.getClass());
		log.info("memberRepository class = {}", memberRepository.getClass());
		Assertions.assertThat(AopUtils.isAopProxy(memberService)).isTrue();
		Assertions.assertThat(AopUtils.isAopProxy(memberRepository)).isFalse();
	}

	@Test
	@DisplayName("이체 중 예외 발생")
	void accountTransferEx() throws SQLException {
		Member memberA = new Member(MEMBER_A, 10000);
		Member memberB = new Member(MEMBER_EX, 10000);
		this.memberRepository.save(memberA);
		this.memberRepository.save(memberB);

		Assertions
				.assertThatThrownBy(
						() -> memberService.accountTransfer(memberA.getMemberId(), memberB.getMemberId(), 2000))
				.isInstanceOf(IllegalStateException.class);

		Member findMemberA = memberRepository.findById(memberA.getMemberId());
		Member findMemberB = memberRepository.findById(memberB.getMemberId());

		Assertions.assertThat(findMemberA.getMoney()).isEqualTo(10000);
		Assertions.assertThat(findMemberB.getMoney()).isEqualTo(10000);
	}
}
