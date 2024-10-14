package com.ktdsuniversity.edu.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktdsuniversity.edu.member.vo.MemberVO;
import com.ktdsuniversity.edu.todo.dao.TodoDao;
import com.ktdsuniversity.edu.todo.service.TodoService;
import com.ktdsuniversity.edu.todo.vo.DeleteTodoVO;
import com.ktdsuniversity.edu.todo.vo.TodoListVO;
import com.ktdsuniversity.edu.todo.vo.TodoVO;
import com.ktdsuniversity.edu.todo.vo.WriteTodoVO;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoDao todoDao;
	
	@Override
	public TodoListVO selectAllTodo(MemberVO memberVO) {
		List<TodoVO> TodoList = this.todoDao.selectAllTodo(memberVO);
		
		TodoListVO todoListVO = new TodoListVO();
		todoListVO.setTodoList(TodoList);
		
		return todoListVO;
	}
	
	@Override
	public TodoVO selectOneTodo(int id) {
		TodoVO todoVO = todoDao.selectOneTodo(id);
		return todoVO;
	}
	
	@Transactional
	@Override
	public boolean insertNewTodo(WriteTodoVO writeTodoVO) {
		int insertCount = this.todoDao.insertNewTodo(writeTodoVO);
		return insertCount > 0;
	}
	
	@Transactional
	@Override
	public void updateOneTodoStatus(int id) {
		TodoVO todoVO = todoDao.selectOneTodo(id);
		if (todoVO != null) {
			todoVO.setStatus("DONE");
			todoDao.updateOneTodoStatus(todoVO);
		}
	}
	
	@Transactional
	@Override
	public boolean deleteOneTodo(DeleteTodoVO deleteTodoVO) {
		int deleteCount = todoDao.deleteOneTodo(deleteTodoVO);
		return deleteCount > 0;
	}
}
