package hello.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.support.JdbcUtils;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV1;
import hello.jdbc.repository.MemberRepositoryV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * 트랜잭션 - 파라미터 연동, 풀을 고려한 연동
 */
@Slf4j
@RequiredArgsConstructor
public class MemberServiceV2 {

	private final DataSource dataSource;
	private final MemberRepositoryV2 memberRepository;
	
	public void accountTransfer(String fromId, String toId, int money) throws SQLException {
		Connection con = dataSource.getConnection();
		
		try {
			con.setAutoCommit(false);
			bizLogic(con,fromId,toId,money);
			
			con.commit();
		} catch(Exception e) {
			con.rollback();
			throw new IllegalStateException(e);
		} finally {
			release(con);
		}
	}
	
	private void bizLogic(Connection con, String fromId, String toId, int money) throws SQLException {
		//비즈니스 로직 수행
		Member fromMember = memberRepository.findById(con, fromId);
		Member toMember= memberRepository.findById(con,toId);
		
		this.memberRepository.update(con,fromId, fromMember.getMoney()-money);
		validation(toMember);
		this.memberRepository.update(con,toId, toMember.getMoney() + money);
	}
	
	private void validation(Member member) {
		if(member.getMemberId().equals("ex")) {
			throw new IllegalStateException("이체중 예외 발생");
		}
	}
	
	private void release(Connection con) {
		if(con != null) {
			try {
				con.setAutoCommit(true);	//커넥션 풀 고려
				con.close();
			}catch (Exception e) {
				log.info("error",e);
			}
		}
	}


}
