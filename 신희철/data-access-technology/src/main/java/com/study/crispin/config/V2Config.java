package com.study.crispin.config;

import com.study.crispin.repository.ItemRepository;
import com.study.crispin.repository.jpa.JPAItemRepositoryV2;
import com.study.crispin.repository.jpa.JPAItemRepositoryV3;
import com.study.crispin.repository.jpa.SpringDataJPAItemRepository;
import com.study.crispin.repository.v2.ItemQueryRepositoryV2;
import com.study.crispin.repository.v2.ItemRepositoryV2;
import com.study.crispin.service.ItemService;
import com.study.crispin.service.ItemServiceV1;
import com.study.crispin.service.ItemServiceV2;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class V2Config {

    private final EntityManager entityManager;
    private final ItemRepositoryV2 itemRepositoryV2;
    private final SpringDataJPAItemRepository springDataJPAItemRepository;

    public V2Config(EntityManager entityManager,
                    ItemRepositoryV2 itemRepositoryV2,
                    SpringDataJPAItemRepository springDataJPAItemRepository) {
        this.entityManager = entityManager;
        this.itemRepositoryV2 = itemRepositoryV2;
        this.springDataJPAItemRepository = springDataJPAItemRepository;
    }

    @Bean
    public ItemService itemService() {
        return new ItemServiceV2(itemRepositoryV2, itemQueryRepositoryV2());
    }

    @Bean
    public ItemQueryRepositoryV2 itemQueryRepositoryV2() {
        return new ItemQueryRepositoryV2(entityManager);
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JPAItemRepositoryV3(springDataJPAItemRepository, entityManager);
    }
}
