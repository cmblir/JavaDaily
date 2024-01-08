package spring.core.order.service;

import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.core.discount.service.DiscountPolicy;
import spring.core.member.entity.Member;
import spring.core.member.repository.MemberRepository;
import spring.core.order.entity.Order;


@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{



    private final  MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    
    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }


}
