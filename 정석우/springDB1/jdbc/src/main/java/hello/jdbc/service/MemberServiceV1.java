package hello.jdbc.service;

import java.sql.SQLException;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV1;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberServiceV1 {

	
	private final MemberRepositoryV1 memberRepository;
	
	public void accountTransfer(String fromId, String toId, int money) throws SQLException {
		Member fromMember = memberRepository.findById(fromId);
		Member toMember= this.memberRepository.findById(toId);
		
		this.memberRepository.update(fromId, fromMember.getMoney()-money);
		validation(toMember);
		this.memberRepository.update(toId, toMember.getMoney() + money);
	}

	private void validation(Member member) {
		if(member.getMemberId().equals("ex")) {
			throw new IllegalStateException("이체중 예외 발생");
		}
	}
}
