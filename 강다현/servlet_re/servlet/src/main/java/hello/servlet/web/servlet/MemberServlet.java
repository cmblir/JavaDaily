package hello.servlet.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * MEmberServlet은 단순하게 회원 정보를 입력할 수 있는 HTML form을 만들어서 제공한다.
 * 자바 코드로 HTML을 제공해야 하므로 쉽지 않은 작업이다.
 * HTML form 데이터를 POST로 전송해도, 전달 받는 서블릿을 만들지 않았기 때문에 오류가 발생하는 것은 당연하다.
 */


@WebServlet(name="memberServlet", urlPatterns = "/servlet/members/new-form")
public class MemberServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" +
                " <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"/servlet/members/save\" method=\"post\">\n" +
                " username: <input type=\"text\" name=\"username\" />\n" +
                " age: <input type=\"text\" name=\"age\" />\n" +
                " <button type=\"submit\">전송</button>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>\n");


    }
}
