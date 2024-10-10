package com.ktdsuniversity.edu.todo.vo;

import jakarta.validation.constraints.NotBlank;

public class WriteTodoVO {

	@NotBlank(message = "제목을 입력해주세요")
	private String subject;
	
	@NotBlank(message = "기한을 입력해주세요")
	private String deadline;
	
	private String email;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
