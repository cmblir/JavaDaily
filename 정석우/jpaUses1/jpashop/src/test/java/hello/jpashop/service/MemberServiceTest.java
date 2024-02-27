package hello.jpashop.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.NoSuchMessageException;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import hello.jpashop.domain.member.Member;
import hello.jpashop.domain.repository.MemberRepository;
import hello.jpashop.domain.service.MemberService;

@SpringBootTest
@Transactional
public class MemberServiceTest {

	@Autowired
	MemberService memberService;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	void 회원가입() {
		Member member = new Member();
		member.setName("kim");
		
		Long id = memberService.join(member);
		
		Member findMember = memberService.findOne(id);
		
		Assertions.assertThat(member).isEqualTo(findMember);
	}
	
	@Test
	void 중복_회원_예외() {
		Member member1 = new Member();
		member1.setName("kim");

		Member member2 = new Member();
		member2.setName("kim");
		
		memberService.join(member1);
		
		 Assertions.assertThatThrownBy(() -> memberService.join(member2))
         .isInstanceOf(IllegalStateException.class);
	}
}
