package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.ex.MyDbException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.NoSuchElementException;

/**
 * 예외 누수 문제 해결
 * 체크 예외를 런타임 예외로 변경
 * Memberrepository 인터페이스 사용
 * throws SQLException 제거
 */

@Slf4j
public class MemberRepositoryV4_1 implements MemberRepository{

    private final DataSource dataSource;
    public MemberRepositoryV4_1(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Member save(Member member) {
        String sql = "insert into member(member_id,money) values(?,?)";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getMemberId()); //파라미터 바인딩
            pstmt.setInt(2, member.getMoney()); //파라미터 바인딩
            pstmt.executeUpdate(); // 실행 쿼리가 실제 데이터 베이스에 실행된다.
            //참고로 숫자를 반환하는데, 영향을 받은 row의 수만큼 숫자로 반환해준다.
            return member;
        } catch (SQLException e) {
            throw new MyDbException(e); //주의 스택 트레이스를 위해 예외 생성자를 통해 기존 예외도 포함해야 한다.
        } finally {
            close(con, pstmt, null); //외부 리소스를 꼭 닫아줘야 한다.
        }
    }
    public Member findById(String memberId)  {
        String sql = "select * from member where member_id=?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);
            rs = pstmt.executeQuery(); //데이터를 조회할때에는 executeQuery를 사용한다. 이는 결과를 ResultSet에 담아 반환한다.
            if (rs.next()) {
                Member member = new Member();
                member.setMemberId(rs.getString("member_id"));
                member.setMoney(rs.getInt("money"));
                return member;
            }else{
                throw new NoSuchElementException("member not found memberId=" + memberId);
            }
        }catch (SQLException e){
            throw new MyDbException(e);
        }finally {
            close(con, pstmt, rs);
        }
    }

    public void update(String memberId, int money)  {
        String sql = "update member set money=? where member_id=?";

        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, money);
            pstmt.setString(2, memberId);
            int resultSize = pstmt.executeUpdate();
            log.info("resultSize={}", resultSize);
        }catch(SQLException e){
            throw new MyDbException(e);
        }finally {
            close(con, pstmt, null);
        }
    }

    public void delete(String memberId)  {
        String sql = "delete from member where member_id=?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try{
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);
            pstmt.executeUpdate();
        }catch(SQLException e){
            throw new MyDbException(e);
        }finally {
            close(con, pstmt, null);
        }

    }

    //리소스 정리 finally에서 해야됨 ( 항상 호출이 보장되도록.. ) 리소스 누수 발생 가능
    //리소스 정리는 항상 역순으로 해주어야 한다. ResultSet은 결과를 조회할떼 사용함
    private void close(Connection con, Statement pstmt, ResultSet rs) {
        //연 것과 반대 순서로 닫아주기
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(pstmt);
        //주의! 트랜잭션 동기화를 사용하려면 DataSourceUtils를 사용해야 한다.
        DataSourceUtils.releaseConnection(con, dataSource);

    }
    private Connection getConnection() {
        //주의! 트랜잭션 동기화를 사용하려명  DataSourceUtils를 사용해야 한다.
        Connection con = DataSourceUtils.getConnection(dataSource);
        log.info("get connection={}, class={}", con, con.getClass());
        return con;
    }

}
