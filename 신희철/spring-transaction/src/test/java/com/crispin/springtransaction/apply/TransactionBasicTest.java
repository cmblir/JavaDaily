package com.crispin.springtransaction.apply;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@SpringBootTest
class TransactionBasicTest {

    @Autowired
    BasicService basicService;

    @Test
    void proxyCheck() {
        log.info("apply class={}", basicService.getClass());
        Assertions.assertThat(AopUtils.isAopProxy(basicService))
                .isTrue();
    }

    @Test
    void transactionTest() {
        basicService.transaction();
        basicService.nonTransaction();
    }

    @TestConfiguration
    static class TransactionApplyBasicConfig {
        @Bean
        BasicService basicService() {
            return new BasicService();
        }
    }

    @Slf4j
    static class BasicService {

        @Transactional
        public void transaction() {
            log.info("call transaction");
            boolean transactionActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("transaction={}", transactionActive);
        }

        public void nonTransaction() {
            log.info("call non transaction");
            boolean transactionActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("transaction={}", transactionActive);
        }
    }
}
