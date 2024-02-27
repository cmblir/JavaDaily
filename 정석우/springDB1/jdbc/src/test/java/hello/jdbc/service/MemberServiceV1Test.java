package hello.jdbc.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV1;
import static hello.jdbc.connection.ConnectionConst.*;

import java.sql.SQLException;

/*
 * 기본 동작, 트랜잭션이 없어서 문제 발생
 * 
 */
public class MemberServiceV1Test {

	public static final String MEMBER_A = "memberA";
	public static final String MEMBER_B = "memberB";
	public static final String MEMBER_EX = "ex";

	private MemberRepositoryV1 memberRepository;
	private MemberServiceV1 memberService;

	@BeforeEach
	void before() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
		memberRepository = new MemberRepositoryV1(dataSource);
		memberService = new MemberServiceV1(memberRepository);
	}
	
	@AfterEach
	void after() throws SQLException{
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

		Assertions.assertThat(findMemberA.getMoney()).isEqualTo(8000);
		Assertions.assertThat(findMemberB.getMoney()).isEqualTo(10000);
	}
}
