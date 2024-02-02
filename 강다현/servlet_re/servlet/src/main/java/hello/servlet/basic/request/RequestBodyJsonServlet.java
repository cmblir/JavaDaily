package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * API 방식  (REST, HTTP API)
 * 메세지 바디에 내가 원하는 메세지를 직접 실어서 정송
 * JSON 형식으로 데이터 전달
 */

/**
 * http://localhost:8080/request-body-json
 * <p>
 * JSON 형식 전송
 * content-type: application/json
 * message body: {"username": "hello", "age": 20}
 *
 */

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper =new ObjectMapper(); // JSON 결과를 파싱해서 사용할 수 있는 자바 객체로 변환하려면
    // Jackson, Gson 같은 JSON 변환 라이브러리를 추가해서 사용해야 한다.
    // 스프링 부트로 spring MVC를 선택하면 기본으로 Jackson 라이브러리 (ObjectMapper)를 함께 제공한다.


    @Override

    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);

        HelloData helloData = new HelloData();
        helloData = objectMapper.readValue(messageBody, HelloData.class);
        System.out.println("helloData.getUsername() = " + helloData.getUsername());
        System.out.println("helloData.getAge() = " + helloData.getAge());

        response.getWriter().write("ok");

    }
}
