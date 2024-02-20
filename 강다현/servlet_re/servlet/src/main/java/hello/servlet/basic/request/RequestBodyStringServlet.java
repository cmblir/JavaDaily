package hello.servlet.basic.request;

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
 * HTTP message body 에 데이터를 직접 담아서 요청
 * 데이터 형식은 주로 JSON 사용
 * POST,PUT,PATCH
 * HTTP 메세지 바디의 데이터를 InputStream을 사용해서 직접 읽을 수 있다.
 *
 */

@WebServlet(name="requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream(); //inputStream은 byte 코드를 반환한다. byte 코드를 우리가 읽을 수 있는 문자로 보려면
        //문자표(Charset)을 지정해주어야 한다.
        String messageBody =StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("messageBody = " + messageBody);
        response.getWriter().write("ok");

    }
}
