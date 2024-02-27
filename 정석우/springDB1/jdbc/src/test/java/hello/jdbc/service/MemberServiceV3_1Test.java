package hello.jdbc.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV3;
import static hello.jdbc.connection.ConnectionConst.*;

import java.sql.SQLException;

/*
 * 트랜잭션 - 커넥션 파라미터 전달 방식 동기화
 * 
 */
public class MemberServiceV3_1Test {

	public static final String MEMBER_A = "memberA";
	public static final String MEMBER_B = "memberB";
	public static final String MEMBER_EX = "ex";

	private MemberRepositoryV3 memberRepository;
	private MemberServiceV3_1 memberService;

	@BeforeEach
	void before() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
		memberRepository = new MemberRepositoryV3(dataSource);
		
		PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
		
		memberService = new MemberServiceV3_1(transactionManager, memberRepository);
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

		Assertions.assertThat(findMemberA.getMoney()).isEqualTo(10000);
		Assertions.assertThat(findMemberB.getMoney()).isEqualTo(10000);
	}
}
