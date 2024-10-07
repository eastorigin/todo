package com.ktdsuniversity.edu.member.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.ktdsuniversity.edu.member.dao.MemberDao;
import com.ktdsuniversity.edu.member.vo.RegistMemberVO;

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
}
