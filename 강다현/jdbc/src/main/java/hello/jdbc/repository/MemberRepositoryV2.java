package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.support.JdbcUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.NoSuchElementException;

/**
 * JDBC -DataSource 사용, JdbcUtils 사용
 */
@Slf4j
public class MemberRepositoryV2 {

    private final DataSource dataSource;
    public MemberRepositoryV2(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Member save(Member member) throws SQLException{
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
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null); //외부 리소스를 꼭 닫아줘야 한다.
        }
    }
    public Member findById(String memberId) throws SQLException {
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
            log.error("db error");
            throw e;
        }finally {
            close(con, pstmt, rs);
        }
    }

    //계좌 이체 서비스 로직에서 호출하는 메서드1
    public Member findById(Connection con, String memberId) throws SQLException{
        String sql = "select * from member where member_id = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Member member = new Member();
                member.setMemberId(rs.getString("member_id"));
                member.setMoney(Integer.parseInt(rs.getString("money")));
                return member;
            }else{
                throw new NoSuchElementException("member not found memberId=" + memberId);
            }
        }catch(SQLException e){
            log.error("db error", e);
            throw e;
        }finally {
            /**
             * connection은 여기서 닫지 않는다.
             * 커넥션 유지가 필요한 메서드 이기 때문이다. 이후 서비스 로직이 끝날 때 트랜젝션을 종료하고 닫아야 한다.
             */
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(pstmt);

        }

    }

    public void update(String memberId, int money) throws SQLException {
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
            log.error("db error", e);
            throw e;
        }finally {
            close(con, pstmt, null);
        }
    }

    //계좌 이체 서비스 로직에서 호출하는 메서드2
    public void update(Connection con, String memberId, int money) throws SQLException {
        String sql = "update member set money=? where member_id=?";
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, money);
            pstmt.setString(2, memberId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        }finally {
            //connection은 여기서 닫지 않는다.
            JdbcUtils.closeStatement(pstmt);
        }
    }

    public void delete(String memberId) throws SQLException {
        String sql = "delete from member where member_id=?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try{
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);
            pstmt.executeUpdate();
        }catch(SQLException e){
            log.error("db error", e);
            throw e;
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
        JdbcUtils.closeConnection(con);

    }
    private Connection getConnection() throws SQLException{
        Connection con = dataSource.getConnection();
        log.info("get connection={}, class={}", con, con.getClass());
        return con;
    }

}
