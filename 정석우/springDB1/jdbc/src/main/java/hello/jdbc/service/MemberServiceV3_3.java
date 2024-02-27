package hello.jdbc.service;

import java.sql.SQLException;

import org.springframework.transaction.annotation.Transactional;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV3;
import lombok.extern.slf4j.Slf4j;

/*
 * 트랜잭션 - @Transactional AOP
 */
@Slf4j
public class MemberServiceV3_3 {

	private final MemberRepositoryV3 memberRepository;

	public MemberServiceV3_3(MemberRepositoryV3 memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Transactional
	public void accountTransfer(String fromId, String toId, int money) throws SQLException {
		// 트랜잭션 시작
		bizLogic(fromId, toId, money);
	}

	private void bizLogic(String fromId, String toId, int money) throws SQLException {
		// 비즈니스 로직 수행
		Member fromMember = memberRepository.findById(fromId);
		Member toMember = memberRepository.findById(toId);

		this.memberRepository.update(fromId, fromMember.getMoney() - money);
		validation(toMember);
		this.memberRepository.update(toId, toMember.getMoney() + money);
	}

	private void validation(Member member) {
		if (member.getMemberId().equals("ex")) {
			throw new IllegalStateException("이체중 예외 발생");
		}
	}
}
