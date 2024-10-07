package com.ktdsuniversity.edu.member.dao;

import com.ktdsuniversity.edu.member.vo.RegistMemberVO;

public interface MemberDao {
	
	public String NAMESPACE = "com.ktdsuniversity.edu.member.dao.MemberDao";

	public int insertNewMember(RegistMemberVO registMemberVO);
	
	public int selectEmail(String email);
	
	public int selectId(String id);
}
