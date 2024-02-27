package hello.jpashop.api;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.jpashop.domain.Address;
import hello.jpashop.domain.order.Order;
import hello.jpashop.domain.order.OrderItem;
import hello.jpashop.domain.order.OrderSearch;
import hello.jpashop.domain.order.OrderStatus;
import hello.jpashop.domain.repository.OrderRepository;
import hello.jpashop.domain.repository.order.query.OrderFlatDto;
import hello.jpashop.domain.repository.order.query.OrderItemQueryDto;
import hello.jpashop.domain.repository.order.query.OrderQueryDto;
import hello.jpashop.domain.repository.order.query.OrderQueryRepository;
import hello.jpashop.domain.service.MemberService;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderApiController {

	private final OrderRepository orderRepository;
	private final OrderQueryRepository orderQueryRepository;

	@GetMapping("/api/v1/orders")
	public List<Order> ordersV1() {
		List<Order> all = orderRepository.findAllByCriteria(new OrderSearch());

		for (Order order : all) {
			order.getMember().getName();
			order.getDelivery().getAddress();
			List<OrderItem> orderItems = order.getOrderItems();
			orderItems.stream().forEach(o -> o.getItem().getName());
		}
		return all;
	}

	@GetMapping("/api/v2/orders")
	public List<OrderDto> ordersV2() {
		List<Order> orders = orderRepository.findAllByCriteria(new OrderSearch());
		List<OrderDto> collect = orders.stream().map(o -> new OrderDto(o)).collect(toList());

		return collect;

	}
	
	@GetMapping("/api/v3/orders")
	public List<OrderDto> ordersV3() {
		List<Order> orders = orderRepository.findAllWithItem();
		List<OrderDto> collect = orders.stream().map(o -> new OrderDto(o)).collect(toList());

		return collect;
	}
	
	@GetMapping("/api/v3.1/orders")
	public List<OrderDto> ordersV3_page(@RequestParam(value = "offset", defaultValue = "0") int offset, @RequestParam(value = "limit", defaultValue = "100") int limit) {
		List<Order> orders = orderRepository.findAllWithMemberDelivery(offset,limit);
		
		List<OrderDto> collect = orders.stream().map(o -> new OrderDto(o)).collect(toList());

		return collect;
	}
	
	@GetMapping("/api/v4/orders")
	public List<OrderQueryDto> ordersV4(){
		return this.orderQueryRepository.findOrderQueryDtos();
	}
	
	@GetMapping("/api/v5/orders")
	public List<OrderQueryDto> ordersV5(){
		return this.orderQueryRepository.findAllByDto_optimization();
	}
	
	@GetMapping("/api/v6/orders")
	public List<OrderQueryDto> ordersV6(){
		List<OrderFlatDto> flats = this.orderQueryRepository.findAllByDto_flat();
		
		return flats.stream()
				 .collect(groupingBy(o -> new OrderQueryDto(o.getOrderId(), 
				o.getName(), o.getOrderDate(), o.getOrderStatus(), o.getAddress()),
				 mapping(o -> new OrderItemQueryDto(o.getOrderId(), 
				o.getItemName(), o.getOrderPrice(), o.getCount()), toList())
				 )).entrySet().stream()
				 .map(e -> new OrderQueryDto(e.getKey().getOrderId(), 
				e.getKey().getName(), e.getKey().getOrderDate(), e.getKey().getOrderStatus(), 
				e.getKey().getAddress(), e.getValue()))
				 .collect(toList());
	}

	@Getter
	static class OrderDto {
		private Long orderId;
		private String name;
		private LocalDateTime orderDate;
		private OrderStatus orderStatus;
		private Address address;
		private List<OrderItemDto> orderItems;

		public OrderDto(Order order) {
			orderId = order.getId();
			name = order.getMember().getName();
			orderDate = order.getOrderDate();
			orderStatus = order.getStatus();
			address = order.getDelivery().getAddress();
			//order.getOrderItems().stream().forEach(o -> o.getItem().getName());
			orderItems = order.getOrderItems().stream().map(orderItem -> new OrderItemDto(orderItem)).collect(toList());
		}
	}
	
	@Getter
	static class OrderItemDto{

		private String itemName;
		private int orderPrice;
		private int count;
		
		public OrderItemDto(OrderItem orderItem) {
			itemName = orderItem.getItem().getName();
			orderPrice = orderItem.getOrderPrice();
			count = orderItem.getCount();
		}
		
	}

}
