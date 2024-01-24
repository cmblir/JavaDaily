package hello.springmvc.basic.requestmapping;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());


    @RequestMapping({"/hello-basic","/hello-go"})
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }
    @GetMapping("/hello-get-v2")
    public String getBasic(){
        log.info("helloBasic");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId){
        log.info("mappingPath userId={}" , userId);
        return "ok";
    }


    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId,@PathVariable Long orderId){
        log.info("mappingPath userId={}, orderId={}" , userId,orderId);
        return "ok";
    }

    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam(){
        return "ok";
    }

    @GetMapping(value = "/mapping-header",headers = "mode=debug")
    public String mappingHeader(){
        log.info("mapping-header");
        return "ok";
    }

    @PostMapping(value = "/mapping-consume",consumes = "application/json")
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "ok";
    }

    @PostMapping(value = "/mapping-produce",produces = "text/html")
    public String mappingAccept(){
        log.info("mappingAccept");
        return "ok";
    }
}
