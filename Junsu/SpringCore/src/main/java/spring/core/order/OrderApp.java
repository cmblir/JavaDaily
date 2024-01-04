package spring.core.order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.AppConfig;
import spring.core.member.entity.Grade;
import spring.core.member.entity.Member;
import spring.core.member.service.MemberService;
import spring.core.order.entity.Order;
import spring.core.order.service.OrderService;


public class OrderApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();

        ApplicationContext appc = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = appc.getBean("memberService", MemberService.class);
        OrderService orderService = appc.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }
}
