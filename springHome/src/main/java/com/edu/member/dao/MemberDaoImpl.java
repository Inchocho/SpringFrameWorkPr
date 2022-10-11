package com.edu.member.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.member.model.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<MemberDto> memberSelectList() {
		
		return sqlSession.selectList("com.edu.member.memberSelectList");
	}

	@Override
	public MemberDto memberExist(String email, String password, String name) {
		
		//이메일과 패스워드 값을 넘기기 위해서(?)
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("email", email);
		paramMap.put("pwd", password);
		paramMap.put("name", name);
 
		return sqlSession.selectOne("com.edu.member.memberExist", paramMap);
	}

	
}
