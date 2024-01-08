package spring.core.order.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.core.discount.service.FixDiscountPolicy;
import spring.core.member.entity.Grade;
import spring.core.member.entity.Member;
import spring.core.member.repository.MemoryMemberRepository;
import spring.core.order.entity.Order;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

}