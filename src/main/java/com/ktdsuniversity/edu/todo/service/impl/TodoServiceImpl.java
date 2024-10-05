package com.ktdsuniversity.edu.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.todo.dao.TodoDao;
import com.ktdsuniversity.edu.todo.service.TodoService;
import com.ktdsuniversity.edu.todo.vo.TodoListVO;
import com.ktdsuniversity.edu.todo.vo.TodoVO;
import com.ktdsuniversity.edu.todo.vo.WriteTodoVO;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoDao todoDao;
	
	@Override
	public TodoListVO selectAllTodo() {
		List<TodoVO> TodoList = this.todoDao.selectAllTodo();
		
		TodoListVO todoListVO = new TodoListVO();
		todoListVO.setTodoList(TodoList);
		
		return todoListVO;
	}
	
	@Override
	public TodoVO selectOneTodo(int id) {
		TodoVO todoVO = todoDao.selectOneTodo(id);
		return todoVO;
	}
	
	@Override
	public boolean insertNewTodo(WriteTodoVO writeTodoVO) {
		int insertCount = this.todoDao.insertNewTodo(writeTodoVO);
		return insertCount > 0;
	}
	
	@Override
	public void updateOneTodoStatus(int id) {
		TodoVO todoVO = todoDao.selectOneTodo(id);
		if (todoVO != null) {
			todoVO.setStatus("DONE");
			todoDao.updateOneTodoStatus(todoVO);
		}
	}
	
	@Override
	public boolean deleteOneTodo(int id) {
		int deleteCount = todoDao.deleteOneTodo(id);
		return deleteCount > 0;
	}
}
