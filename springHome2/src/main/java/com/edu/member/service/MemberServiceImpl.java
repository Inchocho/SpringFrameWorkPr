package com.edu.member.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.member.dao.MemberDao;
import com.edu.member.model.MemberDto;
import com.edu.util.FileUtils;

@Service
public class MemberServiceImpl implements MemberService{
	
	private static final Logger log 
		= LoggerFactory.getLogger(MemberServiceImpl.class);	

	@Autowired
	public MemberDao memberDao;
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Override
	public List<MemberDto> memberSelectList(int start, int end) {
		// TODO Auto-generated method stub
		return memberDao.memberSelectList(start, end);
	}

	@Override
	public MemberDto memberExist(String email, String password) {
		// TODO Auto-generated method stub
		return memberDao.memberExist(email, password);
	}

	@Override
	public void memberInsertOne(MemberDto memberDto,
			MultipartHttpServletRequest mulRequest) throws Exception {
		// TODO Auto-generated method stub
		
		memberDao.memberInsertOne(memberDto, mulRequest);
		
		int parentSeq = memberDto.getNo();
		
		List<Map<String, Object>> list
			= fileUtils.parseInsertFileInfo(parentSeq
				, mulRequest);
		
		//다수의 동시 업로드를 처리하기 위해 list를 사용함 - 기존 단건 업로드시 Map형식으로 작성하면 끝
		for (int i = 0; i < list.size(); i++) {
			memberDao.insertFile(list.get(i));
		}

	}

	@Override
	public MemberDto memberSelectOne(int no) {
		// TODO Auto-generated method stub
		return memberDao.memberSelectOne(no);
	}

	@Override
	public int memberUpdateOne(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return memberDao.memberUpdateOne(memberDto);
	}

	@Override
	public void memberDeleteOne(int no) {
		// TODO Auto-generated method stub
		memberDao.memberDeleteOne(no);
	}

	@Override
	public int memberSelectTotalCount() {
		// TODO Auto-generated method stub
		return memberDao.memberSelectTotalCount();
	}

	

}
