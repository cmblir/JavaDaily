package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


class StatefulServiceTest {
    @Test
    void statefulServiceSinglrton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : 사용자A 10000원 주문
        int userPrice1 = statefulService1.order("userA", 10000);
        //ThreadA : 사용자A 20000원 주문 10000 ->20000
        int userPrice2 = statefulService1.order("userB", 20000);

        //ThreadA :사용자A 주문 금액 조회
//        int price = statefulService1.getPrice();
        //ThreadA : 사용자A는 10000원을 기대했지만, 기대와 다르게 20000원 출력
        System.out.println("userPrice1 = " + userPrice1);
        System.out.println("userPrice2 = " + userPrice2);

        Assertions.assertThat(userPrice1).isEqualTo(10000);




    }
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}