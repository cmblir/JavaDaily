package hello.jdbc.repository;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.jdbc.domain.Member;

public class MemberRepositoryTest {

	MemberRepositoryV0 repository = new MemberRepositoryV0();
	
	@Test
	void crud() throws SQLException {
		
		//save
		Member member = new Member("memberV4",10000);
		repository.save(member);
		
		//findByid
		Member findMember = repository.findById(member.getMemberId());
		Assertions.assertThat(member).isEqualTo(findMember);
		
		//update : money 10000 -> 20000
		repository.update(member.getMemberId(), 20000);
		Member updatedMember = repository.findById(member.getMemberId());
		Assertions.assertThat(updatedMember.getMoney()).isEqualTo(20000);
		
		//delete
		repository.delete(member.getMemberId());
		Assertions.assertThatThrownBy(() -> repository.findById(member.getMemberId()))
		.isInstanceOf(NoSuchElementException.class);
	}
}
