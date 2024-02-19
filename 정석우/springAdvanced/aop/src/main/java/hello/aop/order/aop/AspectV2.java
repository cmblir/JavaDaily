package hello.aop.order.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
public class AspectV2 {
	
	//hello.app.order 패키지 및 하위 패키지
	@Pointcut("execution(* hello.aop.order..*(..))")
	private void allOrder() {}	//포인트컷 시그니처

	@Around("allOrder()")
	public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable{
		log.info("[log] {}", joinPoint.getSignature());
		return joinPoint.proceed();
	}
	
}
