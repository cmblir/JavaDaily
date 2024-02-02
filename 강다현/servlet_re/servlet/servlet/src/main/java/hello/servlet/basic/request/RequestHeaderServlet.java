package hello.servlet.basic.request;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "requestHeaderServlet", urlPatterns ="/reqeust-header")
public class RequestHeaderServlet extends HttpServlet {

}
