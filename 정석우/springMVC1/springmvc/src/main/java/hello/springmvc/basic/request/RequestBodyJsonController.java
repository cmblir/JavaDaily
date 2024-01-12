package hello.springmvc.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RequestBodyJsonController {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@PostMapping("/request-body-json-v1")
	public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ServletInputStream is = request.getInputStream();
		String messageBody = StreamUtils.copyToString(is, StandardCharsets.UTF_8);
		
		log.info("messageBody = {}" , messageBody);
		HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
		log.info("username = {}, age = {}", helloData.getUsername(),helloData.getAge());
		response.getWriter().write("ok");
	}
	
	@ResponseBody
	@PostMapping("/request-body-json-v2")
	public String requestBodyJsonV2(@RequestBody String messageBody) throws IOException {
		log.info("messageBody = {}" , messageBody);
		HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
		log.info("username = {}, age = {}", helloData.getUsername(),helloData.getAge());
		return "ok";
	}
	
	@ResponseBody
	@PostMapping("/request-body-json-v3")
	public String requestBodyJsonV3(@RequestBody HelloData helloData) throws IOException {
		log.info("messageBody = {}" , helloData);
		log.info("username = {}, age = {}", helloData.getUsername(),helloData.getAge());
		return "ok";
	}
	
	@ResponseBody
	@PostMapping("/request-body-json-v4")
	public String requestBodyJsonV4(HttpEntity<HelloData> data) throws IOException {
		HelloData helloData = data.getBody();
		log.info("messageBody = {}" , helloData);
		log.info("username = {}, age = {}", helloData.getUsername(),helloData.getAge());
		return "ok";
	}
	
	@ResponseBody
	@PostMapping("/request-body-json-v5")
	public HelloData requestBodyJsonV5(@RequestBody HelloData helloData) throws IOException {
		log.info("messageBody = {}" , helloData);
		log.info("username = {}, age = {}", helloData.getUsername(),helloData.getAge());
		return helloData;
	}
}
