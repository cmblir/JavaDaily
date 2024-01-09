package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;

public class ConfigurationSingletonTest {

	
	@Test
	void configurationTest() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); 
		
		MemberServiceImpl memberService = ac.getBean("memberService",MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);	
		
		MemberRepository memberRepository = ac.getBean("memberRepository",MemberRepository.class);
		MemberRepository memberRepository1 = memberService.getMemberRepository();
		MemberRepository memberRepository2 = orderService.getMemberRepository();

		System.out.println(memberRepository);
		System.out.println(memberRepository1);
		System.out.println(memberRepository2);
		
		Assertions.assertThat(memberRepository).isSameAs(memberRepository1);
		Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);
	}
	
	@Test
	void configurationDeep() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); 
		AppConfig bean = ac.getBean(AppConfig.class);
		
		System.out.println("bean = " + bean.getClass());
	}
}
