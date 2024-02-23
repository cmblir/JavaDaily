package hello.jpashop.domain.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.jpashop.domain.item.Item;
import hello.jpashop.domain.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

	private final ItemRepository itemRepository;
	
	@Transactional
	public void saveItem(Item item) {
		this.itemRepository.save(item);
	}
	
	public List<Item> findItems(){
		return this.itemRepository.findAll();
	}
	
	public Item findOne(Long itemId) {
		return this.itemRepository.findOne(itemId);
	}
}
