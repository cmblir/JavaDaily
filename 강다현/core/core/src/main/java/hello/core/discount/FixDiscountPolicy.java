package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FixDiscountPolicy implements DiscountPolicy{
    int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGraed() == Grade.VIP){
            return discountFixAmount;
        }
        return 0;
    }
}
