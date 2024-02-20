package hello.jdbc.connection;


import lombok.extern.slf4j.Slf4j;

import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static hello.jdbc.connection.ConnectionConst.*;

/**
 *  JDBC를 사용해서 실제 데이터베이스에 연결하는 코드 작성
 *  데이터베이스에 연결하려면 JDBC가 제공하는 DriverManager.getConnection()을 사용하면 된다.
 *  이렇게 하면 라이브러리에 있는 데이터베이스 드라이버를 찾아서 해당 드라이버가 제동하는 커넥션을 반환해준다.
 *  여기서는 H2 데이터베이스 드라이버가 작동해서 실제 데이터베이스와 커넥션을 맺고, 그 결과를 반환해준다.
 */

@Slf4j
public class DBConnectionUtil {

    public static Connection getConnection() {
        try {
            //JDBC 표준 인터페이스가 제공하는 Connection이다.
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("get connection={}, class={}", connection, connection.getClass());
            return connection;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }
}
