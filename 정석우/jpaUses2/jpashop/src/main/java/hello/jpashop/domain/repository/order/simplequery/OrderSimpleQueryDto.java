package hello.jpashop.domain.repository.order.simplequery;

import java.time.LocalDateTime;

import hello.jpashop.domain.Address;
import hello.jpashop.domain.order.Order;
import hello.jpashop.domain.order.OrderStatus;
import lombok.Data;

@Data
public class OrderSimpleQueryDto {

	private Long orderId;
	private String name;
	private LocalDateTime orderDate;
	private OrderStatus orderStatus;
	private Address address;

	public OrderSimpleQueryDto(Order order) {
		this.orderId = order.getId();
		this.name = order.getMember().getName(); // Lazy 초기화
		this.orderDate = order.getOrderDate();
		this.orderStatus = order.getStatus();
		this.address = order.getDelivery().getAddress(); // Lazy 초기화
	}

	public OrderSimpleQueryDto(Long orderId, String name, LocalDateTime orderDate, OrderStatus orderStatus,
			Address address) {
		this.orderId = orderId;
		this.name = name;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.address = address;
	}
}
