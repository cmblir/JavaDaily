package hello.jpashop.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.jpashop.domain.delivery.Delivery;
import hello.jpashop.domain.item.Item;
import hello.jpashop.domain.member.Member;
import hello.jpashop.domain.order.Order;
import hello.jpashop.domain.order.OrderItem;
import hello.jpashop.domain.order.OrderSearch;
import hello.jpashop.domain.repository.ItemRepository;
import hello.jpashop.domain.repository.MemberRepository;
import hello.jpashop.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

	private final OrderRepository orderRepository;
	private final MemberRepository memberRepository;
	private final ItemRepository itmeRepository;
	/*
	 * 주문
	 */
	@Transactional
	public Long order(Long memberId, Long itemId, int count) {
		
		//엔티티 조회
		Member member = memberRepository.findOne(memberId);
		Item item = this.itmeRepository.findOne(itemId);
		
		//배송정보 조회
		Delivery delivery = new Delivery();
		delivery.setAddress(member.getAddress());
		
		//주문상품 생성
		OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

		//주문 생성
		Order order = Order.createOrder(member, delivery, orderItem);
		
		orderRepository.save(order);
		return order.getId();
	}
	/*
	 * 주문 취소
	 */
	@Transactional
	public void cancelOrder(Long orderId) {
		//주문 엔티티 조회
		Order order = this.orderRepository.findOne(orderId);
		
		//주문 취소
		order.cancel();
	}
	
	public List<Order> findOrders(OrderSearch orderSearch){
		return orderRepository.findAllByCriteria(orderSearch);
	}
}
