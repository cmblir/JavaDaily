package com.study.crispin.service;

import com.study.crispin.domain.Item;
import com.study.crispin.repository.ItemSearchCond;
import com.study.crispin.repository.ItemUpdateDto;
import com.study.crispin.repository.v2.ItemQueryRepositoryV2;
import com.study.crispin.repository.v2.ItemRepositoryV2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceV2 implements ItemService{

    private final ItemRepositoryV2 itemRepositoryV2;
    private final ItemQueryRepositoryV2 itemQueryRepositoryV2;

    public ItemServiceV2(ItemRepositoryV2 itemRepositoryV2, ItemQueryRepositoryV2 itemQueryRepositoryV2) {
        this.itemRepositoryV2 = itemRepositoryV2;
        this.itemQueryRepositoryV2 = itemQueryRepositoryV2;
    }

    @Override
    public Item save(Item item) {
        return itemRepositoryV2.save(item);
    }

    @Override
    public void update(Long itemId, ItemUpdateDto updateParam) {
        Item findedItem = itemRepositoryV2.findById(itemId).orElseThrow();
        findedItem.update(updateParam);
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepositoryV2.findById(id);
    }

    @Override
    public List<Item> findItems(ItemSearchCond cond) {
        return itemQueryRepositoryV2.findAll(cond);
    }
}
