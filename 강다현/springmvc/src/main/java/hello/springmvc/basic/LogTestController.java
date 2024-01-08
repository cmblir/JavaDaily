package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//REST API의 REST 이다.

@RestController
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(LogTestController.class);

    @GetMapping("/log-test")
    public String logTest(){
        String name = "Spring";
        System.out.println("name = " + name);

        /*
        로그 레벨 설정을 변경해서 출력 결과를 보자.
        LEVEL: TRACE > DEBUG > INFO > WARN > ERROR
        개발 서버는 debug 출력
        운영 서버는 info 출력
         */
        //자바는 출력 전 문자 + 연산을 수행 ( 메모리 사용 ) trace는 출력 하지도 않는데, 메모리 까지 사용하는 것은 낭비
        // {} 같은 경우는 파라미터만을 넘김. 따라서 trace를 출력하지 않기 때문에 수행하지 않음
        log.trace("trace my log ="+name);
        log.trace("trace log = {}",name);
        log.debug("debug log = {}",name);
        //여기까지는 로그가 뜨지 않음

        log.info(" info  log = {}", name);
        log.warn(" warn  log = {}", name);
        log.error(" error log = {}", name);
        return "ok";

    }
}
