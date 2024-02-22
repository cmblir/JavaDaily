package hello.aop.pointcut;

import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import hello.aop.member.annotation.MemberServiceImpl;

public class ExecutionTest {
	
	AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
	Method helloMethod;
	
	
	@BeforeEach
	public void init() throws NoSuchMethodException, SecurityException {
		helloMethod = MemberServiceImpl.class.getMethod("hello", String.class);
	}

}
