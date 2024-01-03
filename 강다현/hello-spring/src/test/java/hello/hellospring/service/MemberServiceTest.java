package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
//단위 테스트 - 단위 단위로 나눠서 테스트를 진행하는 것이 좋은 테스트일 확률이 높다.
//컨테이너 까지 올려서 테스트를 해야할 경우는 좋은 테스트가 아닐 확률이 높다.
class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;
    //동작하기전
    //dependency injection ( 의존성 주입 )
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }
    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    //테스트는 정상 플로우도 중요하지만, 예외 플로우가 더 중요하다
    @Test
    public void 중북_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        //두번째 중복된 이름으로 join할때 예외 발생
       /* 1. try-catch 사용
       try{
            memberService.join(member2);
            fail();
        }catch(IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */
        //2. assertThrows 발생 ( 람다식 부분의 로직을 실행할 것인데, IllegalStateException 예외가 발생해야 한다는 의미이다. )
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다."); //메세지도 검증 가능 따로 반환값 받아오면 된다.
        //then
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}