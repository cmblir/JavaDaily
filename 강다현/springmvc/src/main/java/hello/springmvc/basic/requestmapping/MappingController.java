package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(MappingController.class);
    /**
     * 기본 요청
     * 스프링은 둘다 허용 /hello-basic , /hello-basic/
     * HTTP 메서드 모두 허용 GET, HEAD, POST, PUT , PATCH , DELETE
     * 스프링 부트 3.0 부터는 /hello-basic , /hello-basic/ 는 서로 다른 URL 요청을 사용해야 한다.
     * -> 실행해본 결과 스프링 부트 3.0 부터는 404 상태코드를 보낸다.
     */

    /**
     * method 특정 HTTP 메서드 요청만 허용
     * GET, HEAD, POST, PUT, PATCH, DELETE
     * 스프링 MVC는 HTTP 405 상태코드(Method Not Allowed)를 반환
     */
    @RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
    public String helloBasic(){
        log.info("helloBasic");
        return "ok"; //RestController 이기 때문에 반환값으로 뷰를 찾는게 아니라 HTTP 바디 메세지에 문자를 박는다.
    }
    /**
     * 편리한 축약 애노테이션 (코드보기)
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mapping-get-v2");
        return "ok";
    }
    /**
     * PathVariable(경로 변수) 사용
     * RequestMapping은 URL 경로를 템플릿화 할 수 있다. @PathVariable을 사용하면 매칭
     * 되는 부분을 편리하게 조회할 수 있다.
     * 변수명이 같다면 생략 가능
     * @PathVariable("userId") String data -> @PathVariable String userId
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId){
        log.info(userId);
        return "ok";
    }
    /**
     * PathVariable 사용 다중
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId){
        log.info("mappingPath userId = {}, orderId = {}", userId, orderId);
        return "ok";
    }
    /**
     * 파라미터로 추가 매핑
     * 특정 파라미터 정보가 있거나 없는 조건 추가 가능
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * params = {"mode=debug","data=good"}
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }
    /**
     * 특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }
    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     *
     *
     * consumes 는 요청의 content 타입을 application/json으로 해야 된다.
     */
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }


}
