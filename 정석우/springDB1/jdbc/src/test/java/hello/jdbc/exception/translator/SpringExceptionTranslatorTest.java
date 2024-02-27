package hello.jdbc.exception.translator;

import static hello.jdbc.connection.ConnectionConst.PASSWORD;
import static hello.jdbc.connection.ConnectionConst.URL;
import static hello.jdbc.connection.ConnectionConst.USERNAME;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpringExceptionTranslatorTest {
	
	DataSource dataSource;
	
	@BeforeEach
	void init() {
		dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
	}
	
	@Test
	void sqlExceptionErrorCode() {
		String sql = "select bad grammer";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
		} catch (SQLException e) {
			Assertions.assertThat(e.getErrorCode()).isEqualTo(42122);
			int errorCode = e.getErrorCode();
			log.info("errorCode = {}", errorCode);
			log.info("error",e);
		} finally {
			JdbcUtils.closeStatement(pstmt);
			JdbcUtils.closeConnection(con);
		}
	}
	
	@Test
	void exceptionTranslator() {
		String sql = "select bad grammer";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
		}catch(SQLException e) {
			Assertions.assertThat(e.getErrorCode()).isEqualTo(42122);
			
			SQLErrorCodeSQLExceptionTranslator exTranslator = new SQLErrorCodeSQLExceptionTranslator(dataSource);
			DataAccessException resultEx = exTranslator.translate("select", sql, e);
			log.info("resultEx", resultEx);
			
			Assertions.assertThat(resultEx.getClass()).isEqualTo(BadSqlGrammarException.class);
		}
	}
}
