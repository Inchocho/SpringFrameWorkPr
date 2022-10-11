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
	public String loginCtr(String email, String password
			, HttpSession session, Model model) {	
		logger.info("Welcome MemberController loginCtr! " + email + 
				", " + password);
		
		MemberDto memberDto = memberService.memberExist(email, password);
		
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
	
	//멤버추가(멤버폼 화면)
	@RequestMapping(value="/member/add.do", method = RequestMethod.GET)
	public String add(Model model) {
		logger.debug("Welcome MemberController memberAdd!");
		
		return "member/MemberForm";
	}	
	
	//멤버추가 (실제로 멤버추가되는 로직) ~~Ctr -> 작업
	@RequestMapping(value="/member/addCtr.do", method = RequestMethod.POST)
	public String memberAdd(MemberDto memberDto, Model model) {	
		logger.info("Welcome MemberController addCtr! " + memberDto);
		
		memberService.memberInsertOne(memberDto);
		
		return "redirect:/member/list.do";
	}			
	
	//상세보기 (업데이트폼으로 값을 들고 페이지를 보여줌)
	@RequestMapping(value="/member/update.do", method = RequestMethod.GET)
	public String update(int no, Model model) {
		logger.debug("Welcome MemberController memberUpdate!" + no);
		
		MemberDto memberDto = memberService.memberSelectOne(no);
		
		model.addAttribute("memberDto", memberDto);
		
		return "member/MemberUpdateForm";
	}		
	
	@RequestMapping(value="/member/updateCtr.do", method = RequestMethod.POST)
	public String memberUpdate(MemberDto memberDto, Model model) {
		logger.info("Welcome MemberController memberUpdate! " + memberDto);
		
		memberService.memberUpdateOne(memberDto);
		
		return "redirect:/member/list.do";
	}
	
	@RequestMapping(value="/member/deleteCtr.do", method = RequestMethod.GET)
	public String memberDelete(int no, Model model) {
		logger.info("Welcome MemberController memberDeleteCtr! " + no);
		
		memberService.memberDeleteOne(no);
		
		return "redirect:/member/list.do";
	}
}
