package hello.hellospring.repository;

import com.fasterxml.jackson.databind.deser.std.MapEntryDeserializer;
import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;


/*
개발한 기능을 실행해서 테스트 할 때 자바의 main 메서드를 통해서 실행하거나, 웹 애플리케이셔늬
컨트롤러를 통해서 해당 기능을 실행한다. 이러한 방법은 준비하고 실행하는데 오래 걸리고, 반복 실행하기
어렵고 여러 테스트를 한번에 실행하기 어렵다는 단점이 있다. 자바는 JUnit 이라는 프레임워크로
테스트를 실행해서 이러한 문제를 해결한다.
 */

//테스트 클래스를 먼저 작성하고, 코드를 작성하는 것 ( 검증 틀을 개발전에 미리 작성하는 것 ) -> 테스트 주도 개발 TTD이다.


class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //테스트 한번 실행하고 나서 데이터 초기화
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("dahyeon");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        // 1. print해서 확인
        System.out.println("result = "+(result==member));
        // 2. 하나하나 찍어볼 수 없으니까 Assertions의 assertEquals 사용 ( 기대값과 실제값 비교 )
        Assertions.assertEquals(member,result);


        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //이름 같은지 확인
        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);

    }
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }
    //모든 테스트들은 순서와 상관없이 메서드별로 따로 동작하도록 설계해야 한다.
    //왜냐하면 메서드 작성한대로 테스트가 실행되는 것이 아니기 때문이다.
    //따라서, 한번 메서드안에서 테스트가 실행되고 나면, 데이터 클리어를 해줘야 한다.
}
