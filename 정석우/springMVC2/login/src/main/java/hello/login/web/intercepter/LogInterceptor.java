package hello.login.web.intercepter;

import java.util.UUID;

import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogInterceptor implements HandlerInterceptor{
	
	private static final String lOG_ID = "logId";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURI = request.getRequestURI();
		String uuid = UUID.randomUUID().toString();
		
		request.setAttribute(lOG_ID, uuid);
		
		if(handler instanceof HandlerMethod) {
			HandlerMethod hm = (HandlerMethod) handler; // 호출할 컨트롤러 메서드의 모든 정보가 포함
		}
		
		log.info("Request [{}][{}][{}]", uuid, requestURI,handler);
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		log.info("postHandle [{}]",modelAndView);
	}

	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		String requestURI = request.getRequestURI();
		String uuid = (String)request.getAttribute(lOG_ID);
		
		log.info("Request [{}][{}][{}]", uuid, requestURI,handler);
		
		if(ex != null) {
			log.error("afterCompletion error!!", ex);
		}
	}


}
