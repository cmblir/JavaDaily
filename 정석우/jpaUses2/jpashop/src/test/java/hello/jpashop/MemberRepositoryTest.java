package hello.jpashop;

import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import hello.jpashop.domain.member.Member;
import hello.jpashop.domain.repository.MemberRepository;


@SpringBootTest
public class MemberRepositoryTest {

	
	@Autowired
	MemberRepository memberRepository;
	
	
	@Test
	@Transactional
	@Rollback(false)
	void testMember() {
	/*
		Member member = new Member();
		member.setUsername("memberA");
		Long saveId = memberRepository.save(member);
		
		Member findMember = memberRepository.find(saveId);
		
		Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
		Assertions.assertThat(findMember).isEqualTo(member);
	*/
	}
}
