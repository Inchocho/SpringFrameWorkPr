package com.edu.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.util.ParameterMap;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.member.model.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	//mapper의 namespace를 변수로 생성해서 사용하자
	String namespace = "com.edu.member.";
	
	@Override
	public List<MemberDto> memberSelectList(int start, int end) {
		
		//시작페이지와 끝페이지를 HashMap에 담아서 넘겨줌
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		return sqlSession.selectList(namespace + "memberSelectList", map);
	}

	@Override
	public MemberDto memberExist(String email, String password) {
		
		//이메일과 패스워드 값을 넘기기 위해서(값을 2개이상 전달시 HashMap 사용)
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("email", email);
		paramMap.put("pwd", password);
 
		return sqlSession.selectOne("com.edu.member.memberExist", paramMap);
	}

	@Override
	public int memberInsertOne(MemberDto memberDto, MultipartHttpServletRequest mulRequest) {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.edu.member.memberInsertOne", memberDto);
	}

	@Override
	public MemberDto memberSelectOne(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.edu.member.memberSelectOne", no);
	}

	@Override
	public int memberUpdateOne(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "memberUpdateOne", memberDto);
	}

	@Override
	public void memberDeleteOne(int no) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + "memberDeleteOne", no);
	}

	@Override
	public int memberSelectTotalCount() {
		// TODO Auto-generated method stub
		return (int)sqlSession.selectOne(
				namespace + "memberSelectTotalCount");
	}

	@Override
	public void insertFile(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		sqlSession.insert(namespace + "insertFile", map);
	}

	
}
