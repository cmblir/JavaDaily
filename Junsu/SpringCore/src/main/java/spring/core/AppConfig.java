package spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.core.discount.service.DiscountPolicy;
import spring.core.discount.service.FixDiscountPolicy;
import spring.core.discount.service.RateDiscountPolicy;
import spring.core.member.repository.MemberRepository;
import spring.core.member.repository.MemoryMemberRepository;
import spring.core.member.service.MemberService;
import spring.core.member.service.MemberServiceImpl;
import spring.core.order.service.OrderService;
import spring.core.order.service.OrderServiceImpl;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){ // 생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
    


}
