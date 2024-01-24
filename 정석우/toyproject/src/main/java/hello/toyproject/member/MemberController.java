package hello.toyproject.member;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberRepository memberRepository;
	
	@GetMapping("/add")
	public String addForm(@ModelAttribute("member") Member member) {
		return "members/addMemberForm";
	}
	
	@PostMapping("/add")
	public String save(@Valid @ModelAttribute Member member, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "members/addMemberForm";
		}
		
		memberRepository.addMember(member);
		
		return "redirect:/";
	}
	
	

}
