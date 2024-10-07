package com.ktdsuniversity.edu.member.service.impl;

import com.ktdsuniversity.edu.member.service.MemberService;
import com.ktdsuniversity.edu.member.vo.RegistMemberVO;

public class MemberServiceImpl implements MemberService{

	@Override
	public boolean insertNewMember(RegistMemberVO registMemberVO) {
		return false;
	}
	
	@Override
	public boolean checkAvailableId(String id) {
		return false;
	}
	
	@Override
	public boolean checkAvailableEmail(String email) {
		return false;
	}
}
