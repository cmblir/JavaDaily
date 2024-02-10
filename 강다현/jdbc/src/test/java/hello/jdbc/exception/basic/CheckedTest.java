package hello.jdbc.exception.basic;


import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.Provider;

@Slf4j
public class CheckedTest {
    @Test
    void checked_catch() {
        Service service = new Service();
        service.callCatch();
    }
    @Test
    void checked_throw() {
        Service service = new Service();
        Assertions.assertThatThrownBy(() -> service.callThrow()).isInstanceOf(MyCheckedException.class);
    }







    //Exception을 상속받은 예외는 체크예외가 된다.
    static class MyCheckedException extends Exception{
        public MyCheckedException(String message) {
            super(message);
        }

    }
    static class Service{
        Repository repository = new Repository();
        /**
         * Checked 예외는 예외를 잡아서 처리하거나, 던지거나 둘 중 하나를 필수로 선택해야 한다.
         * 예외를 잡아서 처리하는 코드
         */
        public void callCatch() {
            try {
                repository.call();
            } catch (MyCheckedException e) {
                //예외 처리 로직
                log.info("예외 처리,message={}", e.getMessage(), e);
            }
        }
        public void callThrow() throws MyCheckedException {
            repository.call();
        }

    }
    static class Repository {
        public void call() throws MyCheckedException{ //던지다는 것을 무조건 선언해주어야 한다. ( 그래야지 컴파일러가 확인한다. )
            throw new MyCheckedException("ex");
        }

    }
}
