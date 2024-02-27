package hello.jdbc.service;

import java.sql.SQLException;

import org.springframework.transaction.annotation.Transactional;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepository;
import hello.jdbc.repository.MemberRepositoryV3;
import lombok.extern.slf4j.Slf4j;

/*
 * 예외 누수 문제 해결
 * SQLException 제거
 * 
 * MemberRepository 인터페이스에 의존
 */
@Slf4j
public class MemberServiceV4 {

	private final MemberRepository memberRepository;

	public MemberServiceV4(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Transactional
	public void accountTransfer(String fromId, String toId, int money)  {
		// 트랜잭션 시작
		bizLogic(fromId, toId, money);
	}

	private void bizLogic(String fromId, String toId, int money)  {
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
