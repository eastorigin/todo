package com.ktdsuniversity.edu.todo.service;

import com.ktdsuniversity.edu.member.vo.MemberVO;
import com.ktdsuniversity.edu.todo.vo.DeleteTodoVO;
import com.ktdsuniversity.edu.todo.vo.TodoListVO;
import com.ktdsuniversity.edu.todo.vo.TodoVO;
import com.ktdsuniversity.edu.todo.vo.WriteTodoVO;

public interface TodoService {

	public TodoListVO selectAllTodo(MemberVO memberVO);
	
	public TodoVO selectOneTodo(int id);
	
	public boolean insertNewTodo(WriteTodoVO writeTodoVO);
	
	public void updateOneTodoStatus(int id);
	
	public boolean deleteOneTodo(DeleteTodoVO deleteTodoVO);
}
