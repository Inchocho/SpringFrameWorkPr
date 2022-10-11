package com.edu.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.member.dao.MemberDao;
import com.edu.member.model.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	public MemberDao memberDao;
	
	@Override
	public List<MemberDto> memberSelectList() {
		// TODO Auto-generated method stub
		
		return memberDao.memberSelectList();
	}

	@Override
	public MemberDto memberExist(String email, String password, String name) {
		// TODO Auto-generated method stub
		return memberDao.memberExist(email, password, name);
	}

}
