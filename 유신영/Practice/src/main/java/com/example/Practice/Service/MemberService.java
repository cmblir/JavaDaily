package com.example.Practice.Service;

import com.example.Practice.Member.Member;
import com.example.Practice.Member.MemberRepository;
import com.example.Practice.Member.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원가입
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 중복 회원 검사
        boolean result = memberRepository.findByName(member.getName()).isPresent();
        if (result) {
            throw new IllegalStateException("이미 존재하는 값입니다.");
        }
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
