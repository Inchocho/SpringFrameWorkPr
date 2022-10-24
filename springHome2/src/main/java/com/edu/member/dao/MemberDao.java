package com.edu.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.member.model.MemberDto;

public interface MemberDao {

	public List<MemberDto> memberSelectList(String searchOption, String keyword, int start, int end);
	public MemberDto memberExist(String email, String password);
	public int memberInsertOne(MemberDto memberDto, MultipartHttpServletRequest mulRequest);
	public MemberDto memberSelectOne(int no);
	public int memberUpdateOne(MemberDto memberDto);

	public void memberDeleteOne(int no);
	public int memberSelectTotalCount(String searchOption, String keyword);
	public void insertFile(Map<String, Object> map);

	public List<Map<String,Object>> fileSelectList(int no);
	public Map<String, Object> fileSelectStoredFileName(int parentSeq);
	public int fileDelete(int parentSeq);

}
