package com.ktdsuniversity.edu.todo.dao;

import java.util.List;

import com.ktdsuniversity.edu.member.vo.MemberVO;
import com.ktdsuniversity.edu.todo.vo.DeleteTodoVO;
import com.ktdsuniversity.edu.todo.vo.TodoVO;
import com.ktdsuniversity.edu.todo.vo.WriteTodoVO;

public interface TodoDao {

	public List<TodoVO> selectAllTodo(MemberVO memberVO);
	
	public TodoVO selectOneTodo(int id);
	
	public int insertNewTodo(WriteTodoVO writeTodoVO);
	
	public int deleteOneTodo(DeleteTodoVO deleteTodoVO);
	
	public int updateOneTodoStatus(TodoVO todoVO);;
}
