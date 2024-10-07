package com.ktdsuniversity.edu.member.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegistMemberVO {

	@NotBlank(message = "아이디를 입력해주세요")
	private String id;
	
	@NotBlank(message = "이메일을 입력해주세요")
	@Email(message = "올바른 이메일 형식을 입력해주세요")
	private String email;
	
	@NotBlank(message = "비밀번호를 입력해주세요")
	@Size(min = 4, message = "최소 4자리 이상 입력해주세요")
	private String password;
	
	@NotBlank(message = "비밀번호 확인을 입력해주세요")
	private String confirmPassword;
	
	private String salt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	
}
