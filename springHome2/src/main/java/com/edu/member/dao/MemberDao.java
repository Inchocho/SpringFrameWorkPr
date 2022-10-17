package com.edu.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.member.model.MemberDto;

public interface MemberDao {

	public List<MemberDto> memberSelectList(int start, int end);
	public MemberDto memberExist(String email, String password);
	public int memberInsertOne(MemberDto memberDto, MultipartHttpServletRequest mulRequest);
	public MemberDto memberSelectOne(int no);
	public int memberUpdateOne(MemberDto memberDto);

	public void memberDeleteOne(int no);
	public int memberSelectTotalCount();
	public void insertFile(Map<String, Object> map);

}
