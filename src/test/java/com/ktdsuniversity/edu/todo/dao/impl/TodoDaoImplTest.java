package com.ktdsuniversity.edu.todo.dao.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;

import com.ktdsuniversity.edu.todo.dao.TodoDao;
import com.ktdsuniversity.edu.todo.vo.WriteTodoVO;

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(TodoDaoImpl.class)
public class TodoDaoImplTest {

	@Autowired
	private TodoDao todoDao;
	
	@Test
	public void testInsertNewTodo() {
		WriteTodoVO writeTodoVO = new WriteTodoVO();
		writeTodoVO.setSubject("제목 테스트");
		writeTodoVO.setDeadline("2024-10-10");
		
		int insertCount = this.todoDao.insertNewTodo(writeTodoVO);
		assertTrue(insertCount == 1);
		System.out.println("insertCount 개수: " + insertCount);
	}
}
