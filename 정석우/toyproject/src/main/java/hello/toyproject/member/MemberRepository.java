package hello.toyproject.member;

import org.springframework.stereotype.Repository;


import java.util.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class MemberRepository {

	private static Map<Long, Member> store = new HashMap<>(); 
	private static Long sequence = 1L;
	
	public Member addMember(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		
		return member;
	}
	
	public Member findById(Long id) {
		return store.get(id);
	}
	
	public Optional<Member> findByLoginId(String loginId){
		return findAll().stream()
						.filter(m -> m.getLoginId().equals(loginId))
						.findFirst();
	}
	
	public List<Member> findAll() {
		return new ArrayList<Member>(store.values());
	}
	
}
