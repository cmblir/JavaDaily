package spring.core.member.repository;

import spring.core.member.entity.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
