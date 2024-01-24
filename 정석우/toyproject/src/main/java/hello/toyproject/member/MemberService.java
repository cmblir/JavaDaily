package hello.toyproject.member;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	public Member login(String loginId, String password) {
		return memberRepository.findByLoginId(loginId)
							   .filter(m -> m.getPassword().equals(password))
							   .orElse(null);
	}

}
