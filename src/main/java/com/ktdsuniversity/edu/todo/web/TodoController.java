package com.ktdsuniversity.edu.todo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ktdsuniversity.edu.member.vo.MemberVO;
import com.ktdsuniversity.edu.todo.service.TodoService;
import com.ktdsuniversity.edu.todo.vo.DeleteTodoVO;
import com.ktdsuniversity.edu.todo.vo.TodoListVO;
import com.ktdsuniversity.edu.todo.vo.WriteTodoVO;

import jakarta.validation.Valid;

@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/todo/list")
	public String viewTodoList(Model model,@SessionAttribute(value = "_LOGIN_USER", required = false) MemberVO loginMemberVO) {
		
		TodoListVO todoListVO = this.todoService.selectAllTodo(loginMemberVO);
		
		model.addAttribute("todoListVO", todoListVO);
		
		return "todo/todolist";
	}
	
	@GetMapping("todo/write")
	public String viewTodoWritePage() {
		return "todo/todowrite";
	}
	
	@PostMapping("/todo/write")
	public String doInsertOneTodo(@Valid WriteTodoVO writeTodoVO, BindingResult bindingResult, Model model, @SessionAttribute(value = "_LOGIN_USER", required = false) MemberVO loginMemberVO) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("writeTodoVO", writeTodoVO);
			return "todo/todowrite";
		}
		
		if(loginMemberVO == null) {
			return "redirect:/member/login";
		}
		
		writeTodoVO.setEmail(loginMemberVO.getEmail());
		
		this.todoService.insertNewTodo(writeTodoVO);
		return "redirect:/todo/list";
	}
	
	@GetMapping("todo/modify/{id}")
	public String doModifyOneTodoStatus(@PathVariable int id) {
		this.todoService.updateOneTodoStatus(id);
		return "redirect:/todo/list";
	}
	
	@GetMapping("/todo/delete/{id}")
	public String doDeleteOneTodo(@PathVariable int id, @SessionAttribute("_LOGIN_USER") MemberVO memberVO) {
		
		DeleteTodoVO deleteTodoVO = new DeleteTodoVO();
		deleteTodoVO.setId(id);
		deleteTodoVO.setEmail(memberVO.getEmail());
		
		boolean isDeleted = this.todoService.deleteOneTodo(deleteTodoVO);
		
		if(isDeleted) {
			return "redirect:/todo/list";
		}
		
		return "redirect:/todo/list";
	}
}
