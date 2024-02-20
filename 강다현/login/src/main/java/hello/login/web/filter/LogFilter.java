package hello.login.web.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LogFilter implements Filter {
    //filter 는 서블릿이 제공해주는 기능이다.
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("log filter init");
    }

    //요청이 들어올때마다 doFilter가 먼저 호출된다.
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("log filter doFilter");

        HttpServletRequest httpRequest = (HttpServletRequest) request; //다운 캐스팅
        String requestURI = httpRequest.getRequestURI();

        String uuid = UUID.randomUUID().toString(); //request, response 짝 알 수 있음, 요청이 많이 들어올 시 구분하기 위함.

        try{
            log.info("REQUEST [{}][{}]", uuid, requestURI);
            //아래 과정을 수행하지 않을 경우, 다음 과정으로 넘어가지 않는다.
            chain.doFilter(request, response); //chain 해서 다음 필터 호출 ( 다음 필터가 없다면 서블릿 호출 )
        }catch(Exception e) {
            throw e;
        }finally {
            log.info("RESPONSE [{}][{}]",uuid, requestURI);
        }

    }

    @Override
    public void destroy() {
        log.info("log filter destroy");
    }
}
