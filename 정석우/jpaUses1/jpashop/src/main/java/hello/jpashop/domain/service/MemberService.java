package hello.jpashop.domain.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.jpashop.domain.member.Member;
import hello.jpashop.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	
	/*
	 * 회원 가입 
	 */
	@Transactional
	public Long join(Member member) {
		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();
	}
	
	/*
	 * 회원 전체 조회
	 */
	public List<Member> findMembers(){
		return this.memberRepository.findAll();
	}
	
	/*
	 * 단건 회원 조회
	 */
	public Member findOne(Long memberId) {
		return this.memberRepository.findOne(memberId);
	}
	
	private void validateDuplicateMember(Member member) {
		List<Member> findMembers = this.memberRepository.findByName(member.getName());
		
		if(!findMembers.isEmpty()) {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		}
	}
}
