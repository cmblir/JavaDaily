package com.study.crispin.service;

import com.study.crispin.repository.ItemUpdateDto;
import com.study.crispin.domain.Item;
import com.study.crispin.repository.ItemSearchCond;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item save(Item item);

    void update(Long itemId, ItemUpdateDto updateParam);

    Optional<Item> findById(Long id);

    List<Item> findItems(ItemSearchCond itemSearch);
}
