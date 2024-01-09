package com.study.crispin.config;

import com.study.crispin.repository.ItemRepository;
import com.study.crispin.repository.jpa.JPAItemRepository;
import com.study.crispin.service.ItemService;
import com.study.crispin.service.ItemServiceV1;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JPAConfig {

    private final EntityManager entityManager;

    public JPAConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JPAItemRepository(entityManager);
    }
}
