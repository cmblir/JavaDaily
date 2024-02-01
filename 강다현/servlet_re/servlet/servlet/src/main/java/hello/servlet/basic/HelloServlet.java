package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//서블릿 등록하기 ( 실제로 동작하는 서블릿 코드를 등록
@WebServlet(name = "helloServlet", urlPatterns = "/hello") //서블릿 애노테이션 (name = 서블릿 이름, urlPatterns = URL 매핑)
public class HelloServlet extends HttpServlet {
    //Http 요청을 통해 매핑된 URL이 호출되면 서블릿 컨테이너는 다음 service 메서드를 실행한다.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HeeloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //응답 만들기
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);
    }
}
