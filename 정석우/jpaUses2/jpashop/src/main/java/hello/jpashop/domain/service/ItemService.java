package hello.jpashop.domain.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.jpashop.domain.dto.UpdateItemDto;
import hello.jpashop.domain.item.Book;
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
	
	@Transactional
	public Item updateItem(Long itemId, UpdateItemDto dto) {
		Item findItem = this.itemRepository.findOne(itemId);
		findItem.setPrice(dto.getPrice());
		findItem.setName(dto.getName());
		findItem.setStockQuantity(dto.getStockQuantity());
		
		//영속성 컨텍스트에서 가져온 객체가 수정이 되었으므로 커밋되는 시점에 플러시가 되고 해당 시점에
		//더티체킹이 발생되서 자동으로 객체 값이 변경된다.
		return findItem;
	}
	
	
	public List<Item> findItems(){
		return this.itemRepository.findAll();
	}
	
	public Item findOne(Long itemId) {
		return this.itemRepository.findOne(itemId);
	}
}
