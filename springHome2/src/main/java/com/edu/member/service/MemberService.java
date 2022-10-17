package com.edu.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.member.model.MemberDto;

public interface MemberService {

	public List<MemberDto> memberSelectList(int start, int end);

	public MemberDto memberExist(String email, String password);
	
	public void memberInsertOne(MemberDto memberDto, MultipartHttpServletRequest mulRequest) throws Exception;

	public MemberDto memberSelectOne(int no);

	public int memberUpdateOne(MemberDto memberDto);

	public void memberDeleteOne(int no);

	public int memberSelectTotalCount();
	
}
