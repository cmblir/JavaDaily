package spring.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletoneBean.class);
        SingletoneBean single1 = ac.getBean(SingletoneBean.class);
        SingletoneBean single2 = ac.getBean(SingletoneBean.class);
        System.out.println(single1);
        System.out.println(single2);
        Assertions.assertThat(single1).isSameAs(single2);
        ac.close();
    }

    @Scope("singleton")
    static class SingletoneBean{
        @PostConstruct
        public void init(){
            System.out.println("singletonBean.init");

        }

        @PreDestroy
        public void destroy(){
            System.out.println("singletonBean.destroy");
        }
    }
}
