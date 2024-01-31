package hello.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;

import hello.jdbc.connection.DBConnectionUtil;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;


/*
 * 트랜잭션 - 트랜잭션 매니저
 * DataSourceUtils.getConnection()
 * DataSourceUtils.releaseConnection()
 */

@Slf4j
public class MemberRepositoryV3 {
	private final DataSource dataSource;
	
	public MemberRepositoryV3(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Member save(Member member) throws SQLException {
		String sql = "insert into membeR(member_id, money) values (?,?)";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setInt(2,member.getMoney());
			pstmt.executeUpdate();
			return member;
		} catch (SQLException e) {
			log.error("db error",e);
			throw e;
		} finally {
			close(con, pstmt, null);
		}
	}
	
	public Member findById(String memberId) throws SQLException {
		String sql = "select * from member where member_id = ?";
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMoney(rs.getInt("money"));
				return member;
			}else {
				throw new NoSuchElementException("member not foun memberId = " + memberId);
			}	
			
		} catch (SQLException e) {
			log.error("db error",e);
			throw e;
		
		} finally {
			close(con, pstmt, rs);
		}
	}
	
	public void update(String memberId, int money) throws SQLException {
		String sql = "update member set money=? where member_id=?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setString(2, memberId);
			
			int resultSize = pstmt.executeUpdate();
			log.info("resultSize = {}",resultSize);
			
		} catch (SQLException e) {
			log.error("db error",e);
			throw e;
		} finally {
			close(con, pstmt, rs);
		}
	}
	
	public void delete(String memberId) throws SQLException {
		String sql = "delete from member where member_id = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			log.error("db error",e);
			throw e;
		} finally {
			close(con, pstmt, rs);
		}
	}
	
	private void close(Connection con, Statement stmt, ResultSet rs) {
		JdbcUtils.closeResultSet(rs);
		JdbcUtils.closeStatement(stmt);
		//주위 : 트랜잭션 동기화를 사용하려면 datasourceutils을 사용해야 한다.
		DataSourceUtils.releaseConnection(con, dataSource);
		//JdbcUtils.closeConnection(con);
	}
	
	private Connection getConnection() throws SQLException{
		//주위 : 트랜잭션 동기화를 사용하려면 datasourceutils을 사용해야 한다.
		Connection con = DataSourceUtils.getConnection(dataSource);
		return con;
	}
}
