package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV3;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 트랜젝션 - 트랜잭션 매니저
 */

@Slf4j
@RequiredArgsConstructor
public class MemberServiceV3_1 {

    //    private final DataSource dataSource;
    private final PlatformTransactionManager transactionManager;
    private final MemberRepositoryV3 memberRepository;

    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
//        Connection con = dataSource.getConnection();

        //트랜잭션 시작
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
//            con.setAutoCommit(false); //트랜젝션 시작
//            bizLogic(con, fromId, toId, money);  //비지니스 로직
//            con.commit(); //성공 시 로직
            bizLogic(fromId, toId, money);
            transactionManager.commit(status);

        } catch (Exception e) {
//            con.rollback();
//            throw new IllegalStateException(e);

            transactionManager.rollback(status);
            throw new IllegalStateException(e);

        }
    }
    private void validation(Member toMember) {
        if (toMember.getMemberId().equals("ex")) {
            throw new IllegalStateException("이체중 예외 발생");
        }
    }

    //    private void bizLogic(Connection con, String fromId, String toId, int money) throws SQLException {
//        Member fromMember = memberRepository.findById(con,fromId);
//        Member toMember = memberRepository.findById(con,toId);
//
//        memberRepository.update(con, fromId,fromMember.getMoney() - money);
//        validation(toMember);
//        memberRepository.update(con, toId, toMember.getMoney() + money);
//
//    }
    private void bizLogic(String fromId, String toId, int money) throws SQLException {
        Member fromMember = memberRepository.findById(fromId);
        Member toMember = memberRepository.findById(toId);
        memberRepository.update(fromId,fromMember.getMoney() - money);
        validation(toMember);
        memberRepository.update(toId, toMember.getMoney() + money);

    }

    private void release(Connection con) {
        if (con != null) {
            try {
                con.setAutoCommit(true);
                con.close();
            } catch (Exception e) {
                log.info("error", e);
            }

        }
    }
}
