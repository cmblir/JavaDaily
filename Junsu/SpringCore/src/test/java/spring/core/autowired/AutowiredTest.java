package spring.core.autowired;

import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.member.entity.Member;

import java.util.*;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);


    }

    static class TestBean {
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println(noBean1);

        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println(noBean2);

        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println(noBean3);

        }
    }
}
