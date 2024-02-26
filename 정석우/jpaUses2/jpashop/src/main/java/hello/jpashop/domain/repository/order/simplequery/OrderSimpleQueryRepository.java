package hello.jpashop.domain.repository.order.simplequery;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
//화면 이랑 fit 하게 맞는 repository (화면 전용)
public class OrderSimpleQueryRepository {
	
	
	private final EntityManager em;

	
	public List<OrderSimpleQueryDto> findOrderDtos() {
		 return em.createQuery(
		 "select new hello.jpashop.domain.repository.order.simplequery.OrderSimpleQueryDto(o.id, m.name, o.orderDate, o.status, d.address)" +
		 " from Order o" +
		" join o.member m" +
		" join o.delivery d", OrderSimpleQueryDto.class)
		 .getResultList();
		 }

}
