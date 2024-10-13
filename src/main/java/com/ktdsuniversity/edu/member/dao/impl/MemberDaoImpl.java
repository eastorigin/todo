package com.ktdsuniversity.edu.member.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.member.dao.MemberDao;
import com.ktdsuniversity.edu.member.vo.LoginMemberVO;
import com.ktdsuniversity.edu.member.vo.MemberVO;
import com.ktdsuniversity.edu.member.vo.RegistMemberVO;

@Repository
public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertNewMember(RegistMemberVO registMemberVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNewMember", registMemberVO);
	}
	
	@Override
	public int selectEmail(String email) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectEmail", email);
	}
	
	@Override
	public int selectId(String id) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectId", id);
	}
	
	@Override
	public String selectSalt(String email) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectSalt", email);
	}
	
	@Override
	public MemberVO selectOneMember(LoginMemberVO loginMemeberVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectOneMember", loginMemeberVO);
	}
	
	@Override
	public int deleteMe(String email) {
		return this.getSqlSession().delete(NAMESPACE + ".deleteMe", email);
	}
}
