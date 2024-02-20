package hello.jdbc.exception.basic;


import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class UncheckedTest {
    @Test
    void checked_catch() {
        Service service = new Service();
        service.callCatch();
    }
    @Test
    void checked_throw() {
        Service service = new Service();
        Assertions.assertThatThrownBy(() -> service.callThrow()).isInstanceOf(MyUncheckedException.class);
    }







    //RunTimeException 을 상속받은 예외는 체크예외가 된다.
    static class MyUncheckedException extends RuntimeException{
        public MyUncheckedException(String message) {
            super(message);
        }

    }
    static class Service{
        Repository repository = new Repository();
        /**
         * UnChecked 예외는 예외를 잡거나, 던지지 않아도 된다.
         * 예외를 잡지 않으면 자동으로 밖으로 던진다.
         */
        public void callCatch() {
            try {
                repository.call();
            } catch (MyUncheckedException e) {
                //예외 처리 로직
                log.info("예외 처리,message={}", e.getMessage(), e);
            }
        }
        //예외를 잡지 않아도 된다. 자연스럽게 상위로 넘어간다.
        //체크 예외와 다르게 throws 예외 선언을 하지 않아도 된다.
        public void callThrow() {
            repository.call();
        }

    }
    static class Repository {
        public void call() { //던지다는 것을 무조건 선언해주어야 한다. ( 그래야지 컴파일러가 확인한다. )
            throw new MyUncheckedException("ex");
        }

    }
}
