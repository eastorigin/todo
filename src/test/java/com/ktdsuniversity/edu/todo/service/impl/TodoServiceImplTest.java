package com.ktdsuniversity.edu.todo.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import com.ktdsuniversity.edu.todo.dao.TodoDao;
import com.ktdsuniversity.edu.todo.dao.impl.TodoDaoImpl;
import com.ktdsuniversity.edu.todo.service.TodoService;
import com.ktdsuniversity.edu.todo.vo.WriteTodoVO;

@Import({TodoDaoImpl.class, TodoServiceImpl.class})
@SpringBootTest
public class TodoServiceImplTest {

	@Autowired
	TodoService todoService;
	
	@MockBean
	TodoDao todoDao;
	
	@Test
	public void testInsertNewTodo() {
		WriteTodoVO writeTodoVO = new WriteTodoVO();
		BDDMockito.given(todoDao.insertNewTodo(writeTodoVO)).willReturn(1);
		assertEquals(true, todoService.insertNewTodo(writeTodoVO));
	}
}
