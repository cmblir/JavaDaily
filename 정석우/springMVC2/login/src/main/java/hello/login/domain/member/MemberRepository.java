package hello.login.domain.member;

import java.util.*;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberRepository {

	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;

	public Member save(Member member) {
		member.setId(++sequence);
		log.info("save : member = {}", member);
		store.put(member.getId(), member);
		return member;
	}

	public Member findById(Long id) {
		return store.get(id);
	}

	public Optional<Member> findByLoginId(String loginId) {
//		List<Member> all = findAll();
//		for(Member m : all) {
//			if(m.getLoginId().equals(loginId)) {
//				return Optional.of(m);
//			}
//		}
//		return Optional.empty();

		return findAll().stream()
				.filter(m -> m.getLoginId().equals(loginId))
				.findFirst();
	}

	public List<Member> findAll() {
		return new ArrayList<Member>(store.values());
	}
	
	public void clearStore() {
		store.clear();
	}
}
