package com.crispin.springtransaction.propagation;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class BasicTransactionTest {

    @Autowired
    PlatformTransactionManager transactionManager;

    @TestConfiguration
    static class Config {

        @Bean
        public PlatformTransactionManager transactionManager(DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }
    }

    @Test
    void commit() {
        log.info("트랜잭션 시작");
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionAttribute());

        log.info("트랜잭션 커밋 시작");
        transactionManager.commit(status);
        log.info("트랜잭션 커밋 완료");
    }

    @Test
    void rollback() {
        log.info("트랜잭션 시작");
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionAttribute());

        log.info("트랜잭션 롤백 시작");
        transactionManager.rollback(status);
        log.info("트랜잭션 롤백 완료");
    }

    @Test
    void doubleCommit() {
        log.info("트랜잭션1 시작");
        TransactionStatus tx1 = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션1 커밋");
        transactionManager.commit(tx1);

        log.info("트랜잭션2 시작");
        TransactionStatus tx2 = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션2 커밋");
        transactionManager.commit(tx2);
    }

    @Test
    void doubleCommitRollback() {
        log.info("트랜잭션1 시작");
        TransactionStatus tx1 = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션1 커밋");
        transactionManager.commit(tx1);

        log.info("트랜잭션2 시작");
        TransactionStatus tx2 = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션2 롤백");
        transactionManager.rollback(tx2);
    }

    @Test
    void innerCommit() {
        log.info("외부 트랜잭션 시작");
        TransactionStatus outer = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outer.isNewTransaction()={}", outer.isNewTransaction());

        log.info("내부 트랜잭션 시작");
        TransactionStatus inner = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("inner.isNewTransaction()={}", inner.isNewTransaction());
        log.info("내부 트랜잭션 커밋");
        transactionManager.commit(inner);

        log.info("외부 트랜잭션 커밋");
        transactionManager.commit(outer);
    }

    @Test
    void outerRollback() {
        log.info("외부 트랜잭션 시작");
        TransactionStatus outer = transactionManager.getTransaction(new DefaultTransactionAttribute());

        log.info("내부 트랜잭션 시작");
        TransactionStatus inner = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("내부 트랜잭션 커밋");
        transactionManager.commit(inner);

        log.info("외부 트랜잭션 롤백");
        transactionManager.rollback(outer);
    }

    @Test
    void innerRollback() {
        log.info("외부 트랜잭션 시작");
        TransactionStatus outer = transactionManager.getTransaction(new DefaultTransactionAttribute());

        log.info("내부 트랜잭션 시작");
        TransactionStatus inner = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("내부 트랜잭션 롤백");
        transactionManager.rollback(inner);

        log.info("외부 트랜잭션 커밋");

        Assertions.assertThatThrownBy(
                () -> transactionManager.commit(outer)
        ).isInstanceOf(UnexpectedRollbackException.class);
    }

    @Test
    void innerRollBackRequiresNew() {
        log.info("외부 트랜잭션 시작");
        TransactionStatus outer = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outer.isNewTransaction()={}", outer.isNewTransaction());

        log.info("내부 트랜잭션 시작");
        DefaultTransactionAttribute definition = new DefaultTransactionAttribute();
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus inner = transactionManager.getTransaction(definition);
        log.info("inner.isNewTransaction()={}", inner.isNewTransaction());

        log.info("내부 트랜잭션 롤백");
        transactionManager.rollback(inner);
        log.info("외부 트랜잭션 커밋");
        transactionManager.commit(outer);

    }
}
