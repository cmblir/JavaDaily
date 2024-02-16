package hello.proxy.postprocessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanPostProcessTest {

	@Test
	void basicConfig() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanPostProcessorConfig.class);

		// beanA 이름으로 B객체가 빈으로 등록된다
		B b = ac.getBean("beanA", B.class);
		b.helloB();

		// B는 빈으로 등록되지 않는다.
		Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean(A.class));
	}

	@Configuration
	static class BeanPostProcessorConfig {
		@Bean(name = "beanA")
		public A a() {
			return new A();
		}
		
		@Bean
		public AToBProcessor helloPostProcessor() {
			return new AToBProcessor();
		}
	}

	static class A {
		public void helloA() {
			log.info("hello A");
		}
	}

	static class B {
		public void helloB() {
			log.info("hello B");
		}
	}

	static class AToBProcessor implements BeanPostProcessor {

		@Override
		public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
			log.info("beanName={} bean={}",beanName, bean);
			
			if(bean instanceof A) {
				return new B();
			}
			return bean;
		}
	}
}
