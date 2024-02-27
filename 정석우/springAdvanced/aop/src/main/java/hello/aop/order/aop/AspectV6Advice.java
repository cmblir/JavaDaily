package hello.aop.order.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
public class AspectV6Advice {
	
	@Around("hello.aop.order.aop.Pointcuts.allOrder()")
	public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable{
		log.info("[log] {}", joinPoint.getSignature());
		return joinPoint.proceed();
	}
	
	/*
	//hello.aop.order 패키지와 하위 패키지 이면서 클래스 이름 패턴이 *Service
	@Around("hello.aop.order.aop.Pointcuts.orderAndService()")
	public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable{
		try {
			//@Before
			//log.info("[트랜잭션 시작] {}", joinPoint.getSignature());
			Object result = joinPoint.proceed();
			//@AfterReturning
			log.info("[트랜잭션 커밋] {}", joinPoint.getSignature());
			
			return result;
		} catch(Exception e) {
			//@AfterThrowing
			log.info("[트랜잭션 롤백] {}", joinPoint.getSignature());
			throw e;
		} finally {
			//@After
			log.info("[리소스 릴리즈] {}", joinPoint.getSignature());
		}
	}
	*/
	
	@Before("hello.aop.order.aop.Pointcuts.orderAndService()")
	public void doBefore(JoinPoint joinPoint) {
		log.info("[before] {}", joinPoint.getSignature());
	}
	
	@AfterReturning(value = "hello.aop.order.aop.Pointcuts.orderAndService()", returning="result")
	public void doReturn(JoinPoint joinPoint,Object result) {
		log.info("[result] {} , result = {}", joinPoint.getSignature(),result);
	}
	
	@AfterThrowing(value = "hello.aop.order.aop.Pointcuts.orderAndService()", throwing="result")
	public void doThrowing(JoinPoint joinPoint,Exception ex) {
		log.info("[ex] {} , message = {}", joinPoint.getSignature(),ex);
	}
	
	@After("hello.aop.order.aop.Pointcuts.orderAndService()")
	public void doAfter(JoinPoint joinPoint) {
		log.info("[after] {}", joinPoint.getSignature());
	}
	
}
