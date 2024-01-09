package com.study.crispin.config;

import com.study.crispin.repository.ItemRepository;
import com.study.crispin.repository.jpa.JPAItemRepositoryV3;
import com.study.crispin.repository.jpa.SpringDataJPAItemRepository;
import com.study.crispin.service.ItemService;
import com.study.crispin.service.ItemServiceV1;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuerydslConfig {

    private final SpringDataJPAItemRepository repository;
    private final EntityManager entityManager;

    public QuerydslConfig(SpringDataJPAItemRepository repository, EntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JPAItemRepositoryV3(repository, entityManager);
    }
}
