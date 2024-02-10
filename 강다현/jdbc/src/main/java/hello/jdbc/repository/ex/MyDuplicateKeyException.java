package hello.jdbc.repository.ex;


/**
 * 기존에 사용했던 MyDbException을 상속 받아서 의미있는 계층을 형성한다.
 * 이렇게 하면 데이터베이스 관련 예외라는 계층을 만들 수 있다.
 * 이 예외는 데이터 중복의 경우에만 던져야 한다.
 * 직접 만든 예외이기 때문에 JDBC나 JPA 같은 특정 기술에 종속적이지 않다.
 * 따라서 이 예외를 사용하더라도 서비스 계층의 순수성을 유지할 수 있다. (향후 JDBC에서 다른 기술로 바꾸어도
 * 이예외는 그대로 유지할 수 있다. )
 */
public class MyDuplicateKeyException extends MyDbException {
    public MyDuplicateKeyException() {
    }
    public MyDuplicateKeyException(String message) {
        super(message);
    }
    public MyDuplicateKeyException(String message, Throwable cause) {
        super(message, cause);
    }
    public MyDuplicateKeyException(Throwable cause) {
        super(cause);
    }
}
