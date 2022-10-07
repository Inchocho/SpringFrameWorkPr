package com.edu.member.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.member.model.MemberDto;
import com.edu.member.service.MemberService;

//어노테이션 드리븐 (annotation driven) 방식
@Controller
public class MemberController {

	private static final Logger logger 
		= LoggerFactory.getLogger(MemberController.class);
	
	//빈생성을 @Autowired로 한번에
	@Autowired
	private MemberService memberService;
	
	//서블릿 url패턴이 value부분에 들어오고 method를 통해 GET,POST방식이 결정된다
	@RequestMapping(value = "/member/list.do", method = RequestMethod.GET)
	public String memberList(Model model) {
		logger.info("Welcome");
		
		List<MemberDto> memberList = memberService.memberSelectList();
		
		model.addAttribute("memberList", memberList);
		
		return "member/MemberListView";
	}
	
}
