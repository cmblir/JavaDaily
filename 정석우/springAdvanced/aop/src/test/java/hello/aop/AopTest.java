package hello.aop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import hello.aop.order.OrderRepository;
import hello.aop.order.OrderService;
import hello.aop.order.aop.AspectV3;
import hello.aop.order.aop.AspectV4Pointcut;
import hello.aop.order.aop.AspectV5Order;
import hello.aop.order.aop.AspectV6Advice;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
//@Import(AspectV1.class)
//@Import(AspectV2.class)
//@Import(AspectV3.class)
//@Import(AspectV4Pointcut.class)
//@Import({AspectV5Order.logAspect.class, AspectV5Order.transactionAspect.class})
@Import(AspectV6Advice.class)
public class AopTest {

	@Autowired
	OrderService orderService;

	@Autowired
	OrderRepository orderRepository;

	@Test
	void appInfo() {
		log.info("appInfo--------------------------------------");
		log.info("isAopProxy, oderService={}", AopUtils.isAopProxy(orderService));
		log.info("isAopProxy, oderService={}", AopUtils.isAopProxy(orderRepository));
	}

	@Test
	void success() {
		log.info("success--------------------------------------");
		orderService.orderItem("itemA");
	}

	@Test
	void exception() {
		log.info("exception--------------------------------------");
		Assertions.assertThatThrownBy(() -> orderService.orderItem("ex")).isInstanceOf(IllegalStateException.class);
	}

}
