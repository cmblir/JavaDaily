package hello.jpashop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hello.jpashop.domain.item.Book;
import hello.jpashop.domain.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ItemController {

	private final ItemService itemService;

	@GetMapping("/items/new")
	public String createForm(Model model) {
		model.addAttribute("form", new BookForm());

		return "items/createItemForm";
	}

	@PostMapping("/items/new")
	public String create(BookForm form) {
		Book book = new Book();
		book.setName(form.getName());
		book.setPrice(form.getPrice());
		book.setStockQuantity(form.getStockQuantity());
		book.setAuthor(form.getAuthor());
		book.setIsbn(form.getIsbn());

		itemService.saveItem(book);
		return "redirect:/";
	}

	@GetMapping("/items")
	public String List(Model model) {
		model.addAttribute("items", itemService.findItems());

		return "items/itemList";
	}

	@GetMapping("/items/{itemId}/edit")
	public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
		Book item = (Book) itemService.findOne(itemId);

		BookForm form = new BookForm();
		form.setId(item.getId());
		form.setName(item.getName());
		form.setPrice(item.getPrice());
		form.setStockQuantity(item.getStockQuantity());
		form.setIsbn(item.getIsbn());
		form.setAuthor(item.getAuthor());

		model.addAttribute("form", form);
		return "items/updateItemForm";
	}

	@PostMapping("/items/{itemId}/edit")
	public String updateItem(@ModelAttribute("form") BookForm form) {
		Book book = new Book();
		book.setId(form.getId());
		book.setName(form.getName());
		book.setPrice(form.getPrice());
		book.setStockQuantity(form.getStockQuantity());
		book.setAuthor(form.getAuthor());
		book.setIsbn(form.getIsbn());
		
		itemService.saveItem(book);
		
		return "redirect:/items";
	}
}
