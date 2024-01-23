package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name  = " + name);

        log.trace("trace log={} ,{}", name, name);
        log.debug("trace log={} ,{}", name, name);
        log.info(" info log = {} ", name);
        log.warn("trace log={} ,{}", name, name);
        log.error("trace log={} ,{}", name, name);

        return "ok";
    }
}
