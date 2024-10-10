package com.ktdsuniversity.edu.todo.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.member.vo.MemberVO;
import com.ktdsuniversity.edu.todo.dao.TodoDao;
import com.ktdsuniversity.edu.todo.vo.TodoVO;
import com.ktdsuniversity.edu.todo.vo.WriteTodoVO;

@Repository
public class TodoDaoImpl extends SqlSessionDaoSupport implements TodoDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		System.out.println("Autowiring sqlSessionTemplate: " + sqlSessionTemplate);
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public List<TodoVO> selectAllTodo(MemberVO memberVO) {
		return this.getSqlSession().selectList("com.ktdsuniversity.edu.todo.dao.TodoDao.selectAllTodo", memberVO);
	}
	
	@Override
	public int insertNewTodo(WriteTodoVO writeTodoVO) {
		return this.getSqlSession().insert("com.ktdsuniversity.edu.todo.dao.TodoDao.insertNewTodo", writeTodoVO);
	}
	
	@Override
	public int deleteOneTodo(int id) {
		return this.getSqlSession().delete("com.ktdsuniversity.edu.todo.dao.TodoDao.deleteOneTodo", id);
	}
	
	@Override
	public TodoVO selectOneTodo(int id) {
		return this.getSqlSession().selectOne("com.ktdsuniversity.edu.todo.dao.TodoDao.selectOneTodo", id);
	}
	
	@Override
	public int updateOneTodoStatus(TodoVO todoVO) {
		return this.getSqlSession().update("com.ktdsuniversity.edu.todo.dao.TodoDao.updateOneTodoStatus", todoVO);
	}
}
