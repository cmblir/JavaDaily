package hello.servlet.web.servletmvc.MvcMemberFormServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 서블릿을 컨트롤러로 사용하고, JSP를 뷰로 사용해서 MVC 패턴을 적용해보자.
 * Model은 HttpServletRequest 객체를 사용한다. request는 내부에 데이터 저장소를 가지고 있는데,
 * request.setAttribute(), request.getAttribute()를 사용하면 데이터를 보관하고 조회할 수 있다.
 */

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String viewPath = "/WEB-INF/views/new-form.jsp"; //      /WEB-INF 이 경로 안에 JSP가 있으면 외부에서 직접 JSP를 호출할 수 없다.
        // 여기 에서 기재하는 것은 항상 컨트롤러를 통해서 JSP를 호출하는 것이다.
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response); //다른 서블릿이나 JSP로 이동할 수 있는 기능이다. ( 서버 내부에서 다시 호출이 발생한다. )

    }
}
