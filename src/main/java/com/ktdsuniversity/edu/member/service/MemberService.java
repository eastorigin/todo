package com.ktdsuniversity.edu.member.service;

import com.ktdsuniversity.edu.member.vo.RegistMemberVO;

public interface MemberService {
	
	public boolean insertNewMember(RegistMemberVO registMemberVO);

	public boolean checkAvailableId(String id);
	
	public boolean checkAvailableEmail(String email);
	
	
}
