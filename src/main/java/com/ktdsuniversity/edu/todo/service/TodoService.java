package com.ktdsuniversity.edu.todo.service;

import com.ktdsuniversity.edu.todo.vo.TodoListVO;
import com.ktdsuniversity.edu.todo.vo.TodoVO;
import com.ktdsuniversity.edu.todo.vo.WriteTodoVO;

public interface TodoService {

	public TodoListVO selectAllTodo();
	
	public TodoVO selectOneTodo(int id);
	
	public boolean insertNewTodo(WriteTodoVO writeTodoVO);
	
	public void updateOneTodoStatus(int id);
	
	public boolean deleteOneTodo(int id);
}
