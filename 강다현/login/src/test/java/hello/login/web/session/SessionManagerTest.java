package hello.login.web.session;

import hello.login.domain.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SessionManagerTest {
    SessionManager sessionManager = new SessionManager();

    @Test
    void SessionTest(){
        //세션 생성 (HttpServletRequest, response 객체를 인터페이스이기 때문에 이곳에서 직접 사용할 수 없어서,테스트에서 비슷한 역할을 해주는 가짜를 사용)
        MockHttpServletResponse response = new MockHttpServletResponse();
        // 세션 생성하고 쿠키 만들고 웹 브라우저에게 요청을 보냄
        Member member = new Member();
        sessionManager.createSession(member, response);

        // 요청에 응답 쿠키 저장 ( 여기서부터 웹 브라우저의 응답이라고 보면 된다. )
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies());


        // 세션 조회 (서버에서 확인하기 잘 저장되었는지)
        Object result = sessionManager.getSession(request);
        assertThat(result).isEqualTo(member);


        //세션 만료
        sessionManager.expire(request);
        Object expired = sessionManager.getSession(request);
        assertThat(expired).isNull();
    }


}
