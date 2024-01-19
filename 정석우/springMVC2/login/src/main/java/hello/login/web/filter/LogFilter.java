package hello.login.web.filter;

import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException{
		log.info("log filter init");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("log filter doFilter");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String requestURI = httpRequest.getRequestURI();
		
		String uuid = UUID.randomUUID().toString();
		
		try {
			log.info("Request [{}][{}]", uuid, requestURI);
			chain.doFilter(request, response);	//다음 필터 호출 , 필터 없으면 서블릿 호출
		}catch(Exception e) {
			throw e;
		}finally {
			log.info("Response [{}][{}]", uuid, requestURI);
		}
	}
	
	@Override
	public void destroy() {
		log.info("log filter destroy");
	}

}
