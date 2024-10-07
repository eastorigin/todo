package com.ktdsuniversity.edu.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ktdsuniversity.edu.common.beans.Sha;
import com.ktdsuniversity.edu.member.dao.MemberDao;
import com.ktdsuniversity.edu.member.service.MemberService;
import com.ktdsuniversity.edu.member.vo.RegistMemberVO;

public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private Sha sha;

	@Override
	public boolean insertNewMember(RegistMemberVO registMemberVO) {
		int emailCount = memberDao.selectEmail(registMemberVO.getEmail());
		if(emailCount > 0) {
			throw new IllegalArgumentException("중복된 이메일입니다");
		}
		
		int idCount = memberDao.selectId(registMemberVO.getId());
		if(idCount > 0) {
			throw new IllegalArgumentException("중복된 아이디입니다");
		}
		
		String salt = sha.generateSalt();
		
		String password = registMemberVO.getPassword();
		password = sha.getEncrypt(password, salt);
		
		registMemberVO.setPassword(password);
		registMemberVO.setSalt(salt);
		
		int insertCount = memberDao.insertNewMember(registMemberVO);
		return insertCount > 0;
	}
	
	@Override
	public boolean checkAvailableId(String id) {
		return this.memberDao.selectId(id) == 0;
	}
	
	@Override
	public boolean checkAvailableEmail(String email) {
		return this.memberDao.selectEmail(email) == 0;
	}
}
