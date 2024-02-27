package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MappingController {

	@RequestMapping("/hello-basic")
	public String helloBasic() {
		log.info("helloBasic");
		return "ok";
	}
	
	@RequestMapping(value = "/mapping-get-v1", method=RequestMethod.GET)
	public String mappingGetV1() {
		log.info("mappingGetV1");
		return "ok";
	}
	
	@GetMapping(value = "/mapping-get-v2")
	public String mappingGetV2() {
		log.info("mappingGetV2");
		return "ok";
	}
	
	@GetMapping(value = "/mapping/{userId}")
	public String mappingPath(@PathVariable("userId") String data) {
		log.info("mappingPath userId = {}",data);
		return "ok";
	}
	
	@GetMapping(value = "/mapping/users/{userId}/orders/{orderId}")
	public String mappingPath(@PathVariable String userId, @PathVariable String orderId) {
		log.info("mappingPath userId = {}, orderId = {}",userId, orderId);
		return "ok";
	}
	
	@GetMapping(value = "/mapping-param", params="mode=debug")
	public String mappingParam() {
		log.info("mapping Param");
		return "ok";
	}
	
	@GetMapping(value = "/mapping-header", params="mode=debug")
	public String mappingHeader() {
		log.info("mapping Header");
		return "ok";
	}
	
	/**
	 * Content-Type 헤더 기반 추가 매핑 Media Type
	 * consumes="application/json"
	 * consumes="!application/json"
	 * consumes="application/*"
	 * consumes="*\/*"
	 * MediaType.APPLICATION_JSON_VALUE
	 */
	@PostMapping(value = "/mapping-consume", consumes = "application/json")
	public String mappingConsumes() {
	 log.info("mappingConsumes");
	 return "ok";
	}
	
	/**
	 * Accept 헤더 기반 Media Type
	 * produces = "text/html"
	 * produces = "!text/html"
	 * produces = "text/*"
	 * produces = "*\/*"
	 */
	@PostMapping(value = "/mapping-produce", produces = "text/html")
	public String mappingProduces() {
	 log.info("mappingProduces");
	 return "ok";
	}
	
	
}
