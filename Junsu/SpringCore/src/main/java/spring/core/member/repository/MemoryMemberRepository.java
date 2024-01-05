package spring.core.member.repository;

import org.springframework.stereotype.Component;
import spring.core.member.entity.Member;

import java.util.*;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
