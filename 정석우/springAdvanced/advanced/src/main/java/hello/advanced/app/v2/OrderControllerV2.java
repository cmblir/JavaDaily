package hello.advanced.app.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

	private final OrderServiceV2 orderService;
	private final HelloTraceV1 trace;
	
	@GetMapping("/v2/request")
	public String request(@RequestParam("itemId")String itemId) {
		
		TraceStatus status = null;
		try {
			status = trace.begin("orderController.request()");
			orderService.orderItem(status.getTraceId(),itemId);
			trace.end(status);
			return "ok";
		}catch(Exception e) {
			trace.exception(status, e);
			throw e;	//예외를 다시 던져주어야 한다.
		}
	}
}
