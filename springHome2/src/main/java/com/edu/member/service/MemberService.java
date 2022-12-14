package com.edu.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.member.model.MemberDto;

public interface MemberService {

	public List<MemberDto> memberSelectList(String searchOption, String keyword, int start, int end);

	public MemberDto memberExist(String email, String password);
	
	public void memberInsertOne(MemberDto memberDto, MultipartHttpServletRequest mulRequest) throws Exception;

	public Map<String, Object> memberSelectOne(int no);

	public int memberUpdateOne(MemberDto memberDto
			, MultipartHttpServletRequest multipartHttpServletRequest
			, int fileIdx) throws Exception;

	public void memberDeleteOne(int no);

	public int memberSelectTotalCount(String searchOption, String keyword);

	
}
