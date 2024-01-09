package hello.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.*;

public class MemberApp {

	public static void main(String[] args) {
		AppConfig appConfig = new AppConfig();

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); 
		MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);
		
		Member findMember = memberService.findMember(1L);
		
		System.out.println("new Member = " + member.getName());
		System.out.println("find Member = " + findMember.getName());

	}

}
