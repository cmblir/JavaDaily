package hello.proxy.cglib.code;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor{

	private final Object target;
	
	public TimeMethodInterceptor(Object target) {
		this.target = target;
	}



	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		log.info("TimeProxy 실행");
		long start = System.currentTimeMillis();
		
		Object result = proxy.invoke(target, args);
		
		long finish = System.currentTimeMillis();
		long resultTime = finish - start;
		
		log.info("TimeProxy 종료 resultTime = {}", resultTime);
		return result;
	}

}
