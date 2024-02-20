package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach //하나의 테스트가 끝나면 다음을 실행한다. 여기서는 다음 테스트에 영향을 주지 않도록 각 테스트 저장소를 clearStore를 호출해서 초기화 하였다.
    void afterEach(){
        memberRepository.clearStore();
    }
    @Test
    void save(){
        //given
        Member member = new Member("hello", 20);
        //when
        Member savedMember = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        Assertions.assertThat(findMember).isEqualTo(savedMember);
    }


    //  member 객체 2개 생성한뒤 repository에 저장 그리고 테스트 ( 개수가 2개가 맞는지, 객체 2개를 contain 하고 있는지 )
    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> list = memberRepository.findAll();
        //then
        Assertions.assertThat(list.size()).isEqualTo(2);
        Assertions.assertThat(list).contains(member1, member2);

    }

}
