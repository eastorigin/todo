package com.ktdsuniversity.edu.member.dao.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;

import com.ktdsuniversity.edu.member.dao.MemberDao;
import com.ktdsuniversity.edu.member.vo.RegistMemberVO;

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(MemberDaoImpl.class)
public class MemberDaoImplTest {

	@Autowired
	private MemberDao memberDao;
	
	@Test
	public void testInsertNewMember() {
		RegistMemberVO registMemberVO = new RegistMemberVO();
		registMemberVO.setEmail("test@test.com");
		registMemberVO.setId("동녘의근원");
		registMemberVO.setPassword("930921");
		registMemberVO.setConfirmPassword("930921");
		
		int insertCount = this.memberDao.insertNewMember(registMemberVO);
		assertTrue(insertCount == 1);
		System.out.println("insertCount 개수: " + insertCount);
	}
}
