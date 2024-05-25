package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    // 서블릿 크래스로 HTTP프로토콜을 사용하는 웹 애플리케이션의 기본 클래스
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            // HttpServletRequst를 사용하면 값을 받을 수 있으며 객체 안에 모든 데이터들이 들어감
        throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "="
                + request.getParameter(paramName)));
        /* request.getParameterNames()는 HTTP요청에서 모든 파라미터 이름을 가져옴
        asIterator()는 파라미터 이름들을 Iterator로 변환함
        forEachRemaining(paramName -> {...}은 모든 파라미터 이름에 대해 반복 작업을 수행함
        프린트 구문은 파라미터 이름과 그 값을 출력함
         */
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        System.out.println("request.getParameter(username) = " + username);

        String age = request.getParameter("age");
        System.out.println("request.getParameter(age) = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        System.out.println("request.getParameterValue(username)");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }

        response.getWriter().write("ok");
        // 서블릿이 클라이언트에게 응답을 보낼때 getWriter()와 같이 write(ok)를 사용해서 문자열을 응답한다.
    }
}
