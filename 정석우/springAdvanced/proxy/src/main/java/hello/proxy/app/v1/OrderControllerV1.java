package hello.proxy.app.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface OrderControllerV1 {

	@GetMapping("/v1/request")
	String request(@RequestParam("itemId") String itemId);
	
	@GetMapping("/v1/no-log")
	String noLog();
}
