package hello.jpashop.service;

import javax.persistence.EntityManager;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import hello.jpashop.domain.Address;
import hello.jpashop.domain.exception.NotEnoughStockException;
import hello.jpashop.domain.item.Book;
import hello.jpashop.domain.item.Item;
import hello.jpashop.domain.member.Member;
import hello.jpashop.domain.order.Order;
import hello.jpashop.domain.order.OrderStatus;
import hello.jpashop.domain.repository.ItemRepository;
import hello.jpashop.domain.repository.MemberRepository;
import hello.jpashop.domain.repository.OrderRepository;
import hello.jpashop.domain.service.OrderService;

@SpringBootTest
@Transactional
public class OrderServiceTest {

	@Autowired
	OrderService orderService;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	EntityManager em;

	@Test
	void 상품주문() {
		Member member = createMember();
		Item book = createBook("jpa강의", 10000, 10);

		int orderCount = 2;

		Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

		Order getOrder = orderRepository.findOne(orderId);
		Assertions.assertThat(OrderStatus.ORDER).isEqualTo(getOrder.getStatus());
		Assertions.assertThat(1).isEqualTo(getOrder.getOrderItems().size());
		Assertions.assertThat(10000 * orderCount).isEqualTo(getOrder.getTotalPrice());
		Assertions.assertThat(8).isEqualTo(book.getStockQuantity());
	}

	@Test
	void 주문취소() {
		Member member = createMember();
		Item book = createBook("jpa강의", 10000, 10);
		
		int orderCount = 2;

		Long orderId = orderService.order(member.getId(), book.getId(), orderCount);
		orderService.cancelOrder(orderId);
		
		Order getOrder = orderRepository.findOne(orderId);
		Assertions.assertThat(getOrder.getStatus()).isEqualTo(OrderStatus.CANCEL);
		Assertions.assertThat(10).isEqualTo(book.getStockQuantity());
	}

	@Test
	void 상품주문_재고수량초과() {
		Member member = createMember();
		Item book = createBook("jpa강의", 10000, 10);

		int orderCount = 11;
		Assertions.assertThatThrownBy(() -> orderService.order(member.getId(), book.getId(), orderCount))
				.isInstanceOf(NotEnoughStockException.class);

	}

	private Member createMember() {
		Member member = new Member();
		member.setName("회원1");
		member.setAddress(new Address("서울", "강가", "1231-111"));
		em.persist(member);
		return member;
	}

	private Item createBook(String name, int price, int stockQunatity) {
		Item book = new Book();
		book.setName(name);
		book.setPrice(price);
		book.setStockQuantity(stockQunatity);
		em.persist(book);
		return book;
	}

}
