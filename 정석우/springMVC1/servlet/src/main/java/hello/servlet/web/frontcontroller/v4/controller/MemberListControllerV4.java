package hello.servlet.web.frontcontroller.v4.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v1.ControllerV1;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

public class MemberListControllerV4 implements ControllerV4{
	
	private MemberRepository memberRepository = MemberRepository.getInstance();
	

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		List<Member> members = memberRepository.findAll();
		
		model.put("members", members);
		return "members";
	}

}
