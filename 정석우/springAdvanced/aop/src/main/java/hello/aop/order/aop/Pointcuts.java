package hello.aop.order.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

	// hello.app.order 패키지 및 하위 패키지
	@Pointcut("execution(* hello.aop.order..*(..))")
	public void allOrder() {
	} // 포인트컷 시그니처

	// 클래스 이름 패턴이 *Service
	@Pointcut("execution(* *..*Service.*(..))")
	public void allService() {
	} 

	// 클래스 이름 패턴이 *Service
	@Pointcut("allOrder() && allService()")
	public void orderAndService() {
	}

}
