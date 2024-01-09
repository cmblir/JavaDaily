package com.study.crispin.config;

import com.study.crispin.repository.ItemRepository;
import com.study.crispin.repository.memory.MemoryItemRepository;
import com.study.crispin.service.ItemService;
import com.study.crispin.service.ItemServiceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryConfig {

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new MemoryItemRepository();
    }

}
