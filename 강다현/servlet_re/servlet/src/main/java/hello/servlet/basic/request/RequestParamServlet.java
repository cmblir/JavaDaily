package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 데이터를 클라이언트에서 서버로 전송
 * username=hello
 * age=20
 *
 * 메세지 바디 없이, URL의 쿼리 파라미터를 사용해서 데이터를 전달
 * 예 - 검색, 필터, 페이징 등에서 많이 사용하는 방식
 * 쿼리 파라미터는 URL에 다음과 같이 ?를 시작으로 보낼 수 있다. 추가 파라미터는 &로 구분하면 된다.
 * 서버에서는 HttpServletRequest가 제공하는 다음 메서드를 통해 쿼리 파라미터를 편리하게 조회할 수 있다.
 * 쿼리 파라미터 조회 메서드 - request.getParameter("") 단일 파라미터 조회
 * getParameterNames() 파라미터 이름들을 모두 조회
 * getParameterMap() 파라미터를 Map으로 조회
 * getParamgeterValues("username") 복수 파라미터 조회
 *
 * 1. 파라미터 전송 기능
 *  http://localhost:8080/request-param?username=hello&age=20
 * 2. 동일한 파라미터 전송 가능
 *  http://localhost:8080/request-param?username=hello&username=kim&age=20
 *
 *  username=hello&username=kim과 같이 파라미터 이름은 하나인데, 값이 중복이면 어떻게 될까?
 *  request.getParameter()는 하나의 파라미터 이름에 대해서 단 하나의 값만 있을때 사용해야 한다.
 *  지금처럼 value 값이 두개 이상일 경우에는 request.getParameterValues()를 사용해야 한다.
 *  이렇게 중복일때 request.getParameter()를 사용하면 request.getPAeameterValues()의 첫번째 값을 반환한다.
 *
 *  application/x-www-form-urlencoded 형식은 앞서 GET 에서 살펴본 쿼리 파라미터 형식과 같다. 따라서
 *  쿼리 파라미터 조회 메서드를 그대로 사용하면 된다. 클라이언트(웹 브라우저) 입장에서는 두 방식에 차이가 있지만 서버 입장에서는
 *  둘의 형식이 동일하므로, request.getParameter()로 편리하게 구분없이 조회할 수 있다.
 *  정리하면 request.getParameter()는 GET URL 쿼리 파라미터 형식도 지원하고, POST HTML Form 형식도 둘다 지원한다.
 *  게 폼으로 데이터를 전송하는 형식을 application/x-www-form-urlencoded 라 한다.
 */



@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] - start ( getParameterNames 사용 )");

        request.getParameterNames()
                .asIterator()
                .forEachRemaining(parameterName-> System.out.println(parameterName+" = "+request.getParameter(parameterName)));

        System.out.println("[전체 파라미터 조회]");
        String username = request.getParameter("username");
        System.out.println("request.getParameter(username) = " + username);

        String age = request.getParameter("age");
        System.out.println("request.getParameter(age) = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        System.out.println("request.getParameterValues(username)");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("name = " + name);
        }

        response.getWriter().write("ok");




    }
}
