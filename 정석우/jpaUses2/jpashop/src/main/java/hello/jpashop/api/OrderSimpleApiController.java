package hello.jpashop.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.jpashop.domain.order.Order;
import hello.jpashop.domain.order.OrderSearch;
import hello.jpashop.domain.repository.OrderRepository;
import hello.jpashop.domain.repository.order.simplequery.OrderSimpleQueryDto;
import hello.jpashop.domain.repository.order.simplequery.OrderSimpleQueryRepository;
import lombok.RequiredArgsConstructor;

/*
 * XToOne
 * Order
 * Order -> Member 
 * Order -> Delivery
 */

@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {

	private final OrderRepository orderRepository;
	private final OrderSimpleQueryRepository orderSimpleQueryRepository;

	@GetMapping("/api/v1/simple-orders")
	public List<Order> ordersV1() {
		List<Order> all = orderRepository.findAllByCriteria(new OrderSearch());

		for (Order order : all) {
			order.getMember().getName(); // Lazy 강제 초기화
			order.getDelivery().getAddress(); // Lazy 강제 초기화
		}
		return all;
	}

	@GetMapping("/api/v2/simple-orders")
	public List<OrderSimpleQueryDto> ordersV2() {
		//N + 1 문제 발생 (LAZY로 인해)
		//그렇다고 Eager 사용하는 순간 양방향 매핑으로 인해 예측불가능한 쿼리가 어마무시하게 날라간다.
		//결국, Lazy를 사용하되, N+1 문제를 해결해야 한다.
		List<Order> orders = orderRepository.findAllByCriteria(new OrderSearch());
		
		List<OrderSimpleQueryDto> result = orders.stream().map(o -> new OrderSimpleQueryDto(o))
				.collect(Collectors.toList());
		
		return result;
	}
	
	@GetMapping("/api/v3/simple-orders")
	public List<OrderSimpleQueryDto> ordersV3() {
		List<Order> orders = this.orderRepository.findAllWithMemberDelivery();
		
		List<OrderSimpleQueryDto> result = orders.stream().map(o -> new OrderSimpleQueryDto(o))
				.collect(Collectors.toList());
		
		return result;
	}
	
	@GetMapping("/api/v4/simple-orders")
	public List<OrderSimpleQueryDto> ordersV4() {
		//v3보다 성능은 조금 좋지만 딱 dto에 핏하게 맞게 오기때문에 너무 딱딱하다.
		//심지어 요즘 성능이 너무 좋아 v3랑 별 차이 없다.
		//fetch join을 사용해서 entity를 가지고와 새로운 객체에 주입하는 것을 선호한다. (v3선호)
		return orderSimpleQueryRepository.findOrderDtos();
	}
	
}
