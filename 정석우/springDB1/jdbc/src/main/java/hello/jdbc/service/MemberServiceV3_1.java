package hello.jdbc.service;

import java.sql.SQLException;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV3;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * 트랜잭션 - 트랜잭션 매니저
 */
@Slf4j
@RequiredArgsConstructor
public class MemberServiceV3_1 {

	//private final DataSource dataSource;
	private final PlatformTransactionManager transactionManager;
	private final MemberRepositoryV3 memberRepository;
	
	public void accountTransfer(String fromId, String toId, int money) throws SQLException {
		//트랜잭션 시작
		TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			bizLogic(fromId,toId,money);
			this.transactionManager.commit(status);
			
		} catch(Exception e) {
			this.transactionManager.rollback(status);
			throw new IllegalStateException(e);
		} 
	}
	
	private void bizLogic(String fromId, String toId, int money) throws SQLException {
		//비즈니스 로직 수행
		Member fromMember = memberRepository.findById(fromId);
		Member toMember= memberRepository.findById(toId);
		
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
