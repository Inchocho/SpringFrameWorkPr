package com.edu.member.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;
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
	public List<MemberDto> memberSelectList(String searchOption, String keyword, int start, int end) {
		// TODO Auto-generated method stub
		return memberDao.memberSelectList(searchOption, keyword, start, end);
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
		
		Iterator<String> iterator = mulRequest.getFileNames();
		MultipartFile multipartFile = null;
		
		while(iterator.hasNext()) {
			multipartFile = mulRequest.getFile(iterator.next());
			
			if(multipartFile.isEmpty() == false) {
				log.debug("-------- file start --------");
				
				log.debug("name : {}", multipartFile.getName());
				log.debug("fileName : {}", multipartFile.getOriginalFilename());
				log.debug("size : {}", multipartFile.getSize());
				
				log.debug("-------- file end --------\n");
			}
		}	// while end
		
		//10.18파일 업로드에 들어가는 memberDto.getNo를 처리하기위해 생성후 조회하는 쿼리를  수행
		//int parentSeq = memberDao.getMemberNo();
		
		//mapper에서 generateKey를 통해 getNo를 얻어옴
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
	public Map<String, Object> memberSelectOne(int no) {
		// TODO Auto-generated method stub
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		MemberDto memberDto = memberDao.memberSelectOne(no);
		resultMap.put("memberDto", memberDto);
		
		List<Map<String,Object>> fileList = memberDao.fileSelectList(no);
		resultMap.put("fileList", fileList);
		
		return resultMap;
	}

	//스프링에서 제공하는기능 예외가 발생시 롤백을 처리한다(#1)
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int memberUpdateOne(MemberDto memberDto
			, MultipartHttpServletRequest multipartHttpServletRequest
			, int fileIdx) throws Exception {
		
		int resultNum = 0;
	
		try {
			resultNum = memberDao.memberUpdateOne(memberDto);
			System.out.println(resultNum);
			
			int parentSeq = memberDto.getNo();
			Map<String, Object> tempFileMap
				= memberDao.fileSelectStoredFileName(parentSeq);
			
			List<Map<String, Object>> list 
				= fileUtils.parseInsertFileInfo(parentSeq
						, multipartHttpServletRequest);
			
			// 일단 하나의 파일만 가능하도록 구현 (10.18 - 20:50)
			if(list.isEmpty() == false) {
				if(tempFileMap != null) {
					memberDao.fileDelete(parentSeq);
					
					//삭제만 처리하고 변경은 막기위해 예외처리 실행 (10.19 3시 - 일부러 트랜잭션 미수행시 롤백확인용)
					//throw new Exception();
					
					//기존의 파일이 존재하는데 새로운 파일로 변경되는 경우 (롤백확인하려면 여기 주석처리)
					fileUtils.parseUpdateFileInfo(tempFileMap);
				}
				
				for(Map<String, Object> map : list){
					memberDao.insertFile(map);
				}				
			}else if(fileIdx == -1) {	//10.19 5시 --> fileIdx의 값이 -1이면(즉 업로드한 파일이 삭제된경우 타는 로직)
				if(tempFileMap != null) {
					memberDao.fileDelete(parentSeq);
					fileUtils.parseUpdateFileInfo(tempFileMap);
				}
			}
		} catch (Exception e) {
			//스프링에서 제공하는기능 예외가 발생시 롤백을 처리한다(#1 짝꿍)
			TransactionAspectSupport.currentTransactionStatus()
				.setRollbackOnly();
		}
		
		return resultNum;
	}

	@Override
	public void memberDeleteOne(int no) {
		// TODO Auto-generated method stub
		memberDao.memberDeleteOne(no);
	}

	@Override
	public int memberSelectTotalCount(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		return memberDao.memberSelectTotalCount(searchOption, keyword);
	}


}
