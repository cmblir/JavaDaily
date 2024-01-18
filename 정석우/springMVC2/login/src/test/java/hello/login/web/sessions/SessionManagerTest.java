package hello.login.web.sessions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.*;

import hello.login.domain.member.Member;
import hello.login.web.session.SessionManager;

import jakarta.servlet.http.HttpServletResponse;

public class SessionManagerTest {
	
	SessionManager sessionManager = new SessionManager();

	
	@Test
	void sessionTest() {
		MockHttpServletResponse response = new MockHttpServletResponse();
		//세션 생성
		Member member = new Member();
		sessionManager.createSession(member, response);
		
		//요청에 응답 쿠키 저장
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setCookies(response.getCookies());
		
		//세션 조회
		Object result = sessionManager.getSession(request);
		Assertions.assertThat(result).isEqualTo(member);
		
		//세션 만료
		sessionManager.expire(request);
		Object expired = sessionManager.getSession(request);
		Assertions.assertThat(expired).isNull();
	}
}
