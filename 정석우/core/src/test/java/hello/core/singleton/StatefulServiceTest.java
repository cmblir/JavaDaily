package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import hello.core.AppConfig;

public class StatefulServiceTest {

	
	@Test
	void statefulServiceSingleton() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class); 
		
		StatefulService statefulService1 = ac.getBean(StatefulService.class);
		StatefulService statefulService2 = ac.getBean(StatefulService.class);
		
		int price1 = statefulService1.order("userA", 10000);
		int price2 = statefulService2.order("userB", 20000);
		
		System.out.println("price1 = " + price1);
		
	}
	
	static class TestConfig{
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}


}
