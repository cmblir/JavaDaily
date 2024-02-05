package hello.jdbc.repository;

import com.zaxxer.hikari.HikariDataSource;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.sql.SQLException;
import java.util.NoSuchElementException;

import static hello.jdbc.connection.ConnectionConst.*;

@Slf4j
public class MemberRepositoryV1Test {
    MemberRepositoryV1 repository;
    //테스트가 실행되기 이전에 한번 실행되는 것
    @BeforeEach
    void beforeEach() throws Exception {
        //기본 DriverManager - 항상 새로운 커넥션 획득
        //DriverManagerDataSource dataSource =
        //                                new DriverManagerDataSource(URL, USERNAME, PASSWORD);

        //커넥션 풀링 : HikariProzyConnection -> JdbcDataSource();
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setJdbcUrl(USERNAME);
        dataSource.setJdbcUrl(PASSWORD);

        repository = new MemberRepositoryV1(dataSource);
    }
    @Test
    void crud() throws SQLException, InterruptedException {
        log.info("start");
        //save
        Member member = new Member("memberV0", 10000);
        repository.save(member);
        //findById
        Member memberById = repository.findById(member.getMemberId());
        Assertions.assertThat(memberById).isNotNull();
        //update: money: 10000 -> 20000
        repository.update(member.getMemberId(), 20000);
        Member updatedMember = repository.findById(member.getMemberId());
        Assertions.assertThat(updatedMember.getMoney()).isEqualTo(20000);
        //delete
        repository.delete(member.getMemberId());
        Assertions.assertThatThrownBy(() -> repository.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
    }

}
