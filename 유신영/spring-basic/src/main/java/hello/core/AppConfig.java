package hello.core;

import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;

public class AppConfig {

    // 추상화에 의존하게 할 수 있음

    public MemberService memberService() {
        // 생성자를 통해서 주입(연결)
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
