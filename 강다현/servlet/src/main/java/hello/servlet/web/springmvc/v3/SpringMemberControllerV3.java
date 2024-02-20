package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//실무에서는 주로 이 방식을 사용한다.
//기존 코드는 RequestMapping을 사용하고 GET과 POST를 구분하지 않았다.
//이 경우 GET, POST 방식으로 요청해도 같은 응답이 나오게 됨.

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    //@RequestMapping("/new-form")
    //@RequestMapping(value="/new-form", method= RequestMethod.GET)
    @GetMapping("/new-form")
    public String newForm(){
        //컨트롤러는 ModelAndView를 반환해도 되고, 문자를 반환해도 ok 문자 반환시 이를 ModeAndView이름으로 인식한다.
        return "new-form";
    }
    @GetMapping
    public String members(Model model){
        List<Member> members = memberRepository.findAll();
        model.addAttribute("member", members);
        return "members";

    }

    //@RequestMapping(value = "/save", method= RequestMethod.POST)
    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model
    ) {
        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }



}
