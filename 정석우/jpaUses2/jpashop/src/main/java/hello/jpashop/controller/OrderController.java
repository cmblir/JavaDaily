package hello.jpashop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hello.jpashop.domain.item.Item;
import hello.jpashop.domain.member.Member;
import hello.jpashop.domain.order.Order;
import hello.jpashop.domain.order.OrderSearch;
import hello.jpashop.domain.service.ItemService;
import hello.jpashop.domain.service.MemberService;
import hello.jpashop.domain.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;
	private final MemberService memberService;
	private final ItemService itemService;

	@GetMapping("/order")
	public String createForm(Model model) {
		List<Member> members = memberService.findMembers();
		List<Item> items = itemService.findItems();

		model.addAttribute("members", members);
		model.addAttribute("items", items);

		return "order/orderForm";
	}

	@PostMapping("/order")
	public String order(@RequestParam("memberId") Long memberId, @RequestParam("itemId") Long itemId,
			@RequestParam("count") int count) {
		orderService.order(memberId, itemId, count);
		
		return "redirect:/orders";
	}
	
	@GetMapping("/orders")
	public String orderList(@ModelAttribute("orderSearch")OrderSearch orderSearch, Model model) {
		List<Order> orders = orderService.findOrders(orderSearch);
		model.addAttribute("orders",orders);
		
		//@ModelAttribute 이 어노테이션으로 인해 생락 가능
		//model.addAttribute("orderSearch", orderSearch);
		
		return "order/orderList";
	}
	
	@PostMapping("/orders/{orderId}/cancel")
	public String orderCancel(@PathVariable("orderId") Long orderId) {
		orderService.cancelOrder(orderId);
		
		return "redirect:/orders";
	}
}
