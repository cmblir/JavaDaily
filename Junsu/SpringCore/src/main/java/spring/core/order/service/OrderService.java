package spring.core.order.service;

import spring.core.order.entity.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);


}
