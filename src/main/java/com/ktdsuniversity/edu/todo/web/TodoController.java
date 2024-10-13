package com.ktdsuniversity.edu.todo.web;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ktdsuniversity.edu.common.beans.FileHandler;
import com.ktdsuniversity.edu.member.vo.MemberVO;
import com.ktdsuniversity.edu.todo.service.TodoService;
import com.ktdsuniversity.edu.todo.vo.DeleteTodoVO;
import com.ktdsuniversity.edu.todo.vo.TodoListVO;
import com.ktdsuniversity.edu.todo.vo.TodoVO;
import com.ktdsuniversity.edu.todo.vo.WriteTodoVO;

import jakarta.validation.Valid;

@Controller
public class TodoController {
	
	@Autowired
	private FileHandler fileHandler;

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
	
	@GetMapping("/todo/excel/download")
	public ResponseEntity<Resource> doDownloadExcel(@SessionAttribute(value = "_LOGIN_USER", required = false) MemberVO loginMemberVO) {
		
		if(loginMemberVO == null) {
			throw new RuntimeException("로그인이 필요합니다");
		}
		
		Workbook workbook = new SXSSFWorkbook(-1);
		Sheet sheet = workbook.createSheet("게시글 목록");
		Row row = sheet.createRow(0);
		
		Cell cell =row.createCell(0);
		cell.setCellValue("번호");
		
		cell =row.createCell(1);
		cell.setCellValue("상태");
		
		cell =row.createCell(2);
		cell.setCellValue("제목");
		
		cell =row.createCell(3);
		cell.setCellValue("기한");
		
		cell =row.createCell(4);
		cell.setCellValue("아이디(이메일)");
		
		TodoListVO todoListVO = this.todoService.selectAllTodo(loginMemberVO);
		List<TodoVO> todoList = todoListVO.getTodoList();
		
		int rowIndex = 1;
		for(TodoVO todoVO : todoList) {
			row = sheet.createRow(rowIndex++);
			
			cell = row.createCell(0);
			cell.setCellValue(todoVO.getId() + "");
			
			cell = row.createCell(1);
			cell.setCellValue(todoVO.getStatus());
			
			cell = row.createCell(2);
			cell.setCellValue(todoVO.getSubject());
			
			cell = row.createCell(3);
			cell.setCellValue(todoVO.getDeadline());
			
			cell = row.createCell(4);
			cell.setCellValue(todoVO.getMemberVO().getId() + "(" + todoVO.getMemberVO().getEmail() + ")");
		}
		
		String excelFileName = this.fileHandler.createXlsxFile(workbook);
		
		return this.fileHandler.downloadFile(excelFileName, "todo list.xlsx");
	}
}
