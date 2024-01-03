package spring.core.member.service;

import spring.core.member.entity.Member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
