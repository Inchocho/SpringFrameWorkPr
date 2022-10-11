package com.edu.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.member.model.MemberDto;
import com.edu.member.service.MemberService;

// 어노테이션 드리븐
@Controller
public class MemberController {

	private static final Logger logger 
		= LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	//사용자와 상호작용하는 화면 (GET방식) 
	//스프링에서 HttpSession session 세션객체를 만들어놔서 사용할 수 있음, Model은 req를 대체함
	@RequestMapping(value="/auth/login.do", method = RequestMethod.GET)
	public String login(HttpSession session, Model model) {
	
		//logger.info, logger.trace, logger.debug, ~~~ 아래는 info사용한 예시
		logger.info("Welcome MemberController login!");
		
		return "auth/LoginForm";
	}
	
	@RequestMapping(value="/auth/loginCtr.do", method = RequestMethod.POST)
	public String loginCtr(String email, String password, String name
			, HttpSession session, Model model) {	
		logger.info("Welcome MemberController loginCtr! " + email + 
				", " + password + ", " + name);
		
		MemberDto memberDto = memberService.memberExist(email, password, name);
		
		if(memberDto != null) {
			session.setAttribute("member", memberDto);
			
			return "redirect:/member/list.do";
		}
		
		return "/auth/LoginFail";
	}	
	
	@RequestMapping(value = "/member/list.do", method = RequestMethod.GET)
	public String memberList(Model model) {
		logger.info("Welcome MemberController memberList!");
		
		List<MemberDto> memberList = memberService.memberSelectList();
		
		model.addAttribute("memberList", memberList);
		
		return "member/MemberListView";
	}
	
}
