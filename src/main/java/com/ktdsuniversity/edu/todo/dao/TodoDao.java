package com.ktdsuniversity.edu.todo.dao;

import java.util.List;

import com.ktdsuniversity.edu.todo.vo.TodoVO;
import com.ktdsuniversity.edu.todo.vo.WriteTodoVO;

public interface TodoDao {

	public List<TodoVO> selectAllTodo();
	
	public TodoVO selectOneTodo(int id);
	
	public int insertNewTodo(WriteTodoVO writeTodoVO);
	
	public int deleteOneTodo(int id);
	
	public int updateOneTodoStatus(TodoVO todoVO);;
}
