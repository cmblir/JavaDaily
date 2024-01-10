package spring.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototypeBean1");
        PrototypeBean pro1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean pro2 = ac.getBean(PrototypeBean.class);
        System.out.println(pro1);
        System.out.println(pro2);
        Assertions.assertThat(pro1).isNotSameAs(pro2);


        pro1.destroy();
        pro2.destroy();

        ac.close();

    }

    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init(){
            System.out.println("proto.init");

        }

        @PreDestroy
        public void destroy(){
            System.out.println("proto.destroy");
        }
    }
}
