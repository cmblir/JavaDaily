package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns ="/reqeust-header")
public class RequestHeaderServlet extends HttpServlet {

    //service 메소드 중에 protected 접근 지정자로 된 것과 public 접근 지정자로 되어 있는 것이 있는데 protected 접근 지정자로 되어 있는 것으로 해야 한다.


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        printStartLine(req);
        printHeaders(req);
        printHeaderUtils(req);
        printEtc(req);

        res.getWriter().write("ok");
    }

    private void printStartLine(HttpServletRequest request) {
        System.out.println("--- REQUEST-LINE - start ---");
        System.out.println("request.getMethod() = " + request.getMethod()); //GET
        System.out.println("request.getProtocol() = " + request.getProtocol()); //HTTP/1.1
        System.out.println("request.getScheme() = " + request.getScheme()); //http
        // http://localhost:8080/request-header
        System.out.println("request.getRequestURL() = " + request.getRequestURL());// http://localhost:8080/request-header (전체 출력)
        System.out.println("request.getRequestURI() = " + request.getRequestURI());// /request-header (뒤에 부분만 출력)
        System.out.println("request.getQueryString() = " + request.getQueryString()); // username=hello
        System.out.println("request.isSecure() = " + request.isSecure()); //https 사용유무
        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println();

    }

    //전체 조회
    private void printHeaders(HttpServletRequest request) {
        System.out.println("--- Headers - start ---");
        /*
         Enumeration<String> headerNames = request.getHeaderNames();
         while (headerNames.hasMoreElements()) {
         String headerName = headerNames.nextElement();
         System.out.println(headerName + ": " + request.getHeader(headerName));
         }
        */
        request.getHeaderNames().asIterator().forEachRemaining(headerName -> System.out.println(headerName + ": " + request.getHeader(headerName)));
        System.out.println("--- Headers - end ---");
        System.out.println();

    }

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("--- Header 편의 조회 start ---");
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " + request.getServerName()); //Host 헤더
        System.out.println("request.getServerPort() = " + request.getServerPort()); //Host 헤더
        System.out.println();
        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator().forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();
        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();
        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " +
                request.getContentType());
        System.out.println("request.getContentLength() = " +
                request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " +
                request.getCharacterEncoding());
        System.out.println("--- Header 편의 조회 end ---");
        System.out.println();

    }

    //기타 정보
    private void printEtc(HttpServletRequest request) {
        System.out.println("--- 기타 조회 start ---");
        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " +
                request.getRemoteHost()); //
        System.out.println("request.getRemoteAddr() = " +
                request.getRemoteAddr()); //
        System.out.println("request.getRemotePort() = " +
                request.getRemotePort()); //
        System.out.println();
        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " + request.getLocalName()); //
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr()); //
        System.out.println("request.getLocalPort() = " + request.getLocalPort()); //
        System.out.println("--- 기타 조회 end ---");
        System.out.println();

    }




}
