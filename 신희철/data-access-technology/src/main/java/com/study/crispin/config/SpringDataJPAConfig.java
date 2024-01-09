package com.study.crispin.config;

import com.study.crispin.repository.ItemRepository;
import com.study.crispin.repository.jpa.JPAItemRepository;
import com.study.crispin.repository.jpa.JPAItemRepositoryV2;
import com.study.crispin.repository.jpa.SpringDataJPAItemRepository;
import com.study.crispin.service.ItemService;
import com.study.crispin.service.ItemServiceV1;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDataJPAConfig {

    private final SpringDataJPAItemRepository springDataJPAItemRepository;

    public SpringDataJPAConfig(SpringDataJPAItemRepository springDataJPAItemRepository) {
        this.springDataJPAItemRepository = springDataJPAItemRepository;
    }

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JPAItemRepositoryV2(springDataJPAItemRepository);
    }
}
