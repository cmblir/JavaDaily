package hello.jpashop.domain.repository.order.query;

import java.time.LocalDateTime;
import java.util.List;

import hello.jpashop.domain.Address;
import hello.jpashop.domain.order.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderFlatDto {

	private Long orderId;

	private String name;

	private LocalDateTime orderDate;

	private OrderStatus orderStatus;

	private Address address;


	private String itemName;
	private int orderPrice;
	private int count;
}
