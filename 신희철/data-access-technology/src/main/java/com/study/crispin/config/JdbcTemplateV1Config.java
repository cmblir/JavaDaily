package com.study.crispin.config;

import com.study.crispin.repository.ItemRepository;
import com.study.crispin.repository.jdbctemplate.JdbcTemplateRepositoryV1;
import com.study.crispin.service.ItemService;
import com.study.crispin.service.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class JdbcTemplateV1Config {

    private final DataSource dataSource;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JdbcTemplateRepositoryV1(dataSource);
    }
}
