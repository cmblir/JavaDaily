package com.crispin.springtransaction.apply;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@SpringBootTest
class InternalCallV2Test {

    @Autowired
    CallService callService;

    @Test
    void printProxy() {
        log.info("callService class={}", callService.getClass());
    }

    @Test
    void externalCallV2() {
        callService.external();
    }

    @TestConfiguration
    static class InternalCallV1TestConfig {

        @Bean
        InternalService internalService() {
            return new InternalService();
        }

        @Bean
        CallService callService() {
            return new CallService(internalService());
        }
    }

    static class CallService {

        private final InternalService internalService;

        public CallService(InternalService internalService) {
            this.internalService = internalService;
        }

        public void external() {
            log.info("call external");
            printTransactionInfo();
            internalService.internal();
        }

        private void printTransactionInfo() {
            boolean transactionActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("transaction active={}", transactionActive);
        }
    }

    static class InternalService {

        @Transactional
        public void internal() {
            log.info("call internal");
            printTransactionInfo();
        }

        private void printTransactionInfo() {
            boolean transactionActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("transaction active={}", transactionActive);
        }
    }
}
