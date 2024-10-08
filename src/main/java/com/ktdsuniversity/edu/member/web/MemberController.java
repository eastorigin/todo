package com.ktdsuniversity.edu.member.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktdsuniversity.edu.member.service.MemberService;
import com.ktdsuniversity.edu.member.vo.LoginMemberVO;
import com.ktdsuniversity.edu.member.vo.MemberVO;
import com.ktdsuniversity.edu.member.vo.RegistMemberVO;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/regist")
	public String viewRegistMemberPage() {
		return "member/registmember";
	}
	
	@PostMapping("/member/regist")
	public String doRegistMember(@Valid RegistMemberVO registMemberVO, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("registMemberVO", registMemberVO);
			return "member/registmember";
		}
		
		boolean isSuccess = memberService.insertNewMember(registMemberVO);
		
		if(isSuccess) {
			return "redirect:/member/login";
		}
		
		model.addAttribute("registMemberVO", registMemberVO);
		return "member/registmember";
	}
	
	@ResponseBody
	@GetMapping("/member/regist/available/email")
	public Map<String, Object> doCheckAvailableEmail(@RequestParam String email) {
		
		boolean isAvailableEmail = this.memberService.checkAvailableEmail(email);
		
		Map<String, Object>response = new HashMap<String, Object>();
		response.put("email", email);
		response.put("available", isAvailableEmail);
		return response;
	}
	
	@ResponseBody
	@GetMapping("/member/regist/available/id")
	public Map<String, Object> doCheckAvailableId(@RequestParam String id) {
		
		boolean isAvailableId = this.memberService.checkAvailableId(id);
		
		Map<String, Object>response = new HashMap<String, Object>();
		response.put("id", id);
		response.put("available", isAvailableId);
		return response;
	}
	
	@GetMapping("/member/login")
	public String viewLoginPage() {
		return "member/loginmember";
	}
	
	public String doLogin(@Valid LoginMemberVO loginMemberVO, BindingResult bindingResult, HttpSession httpSession, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("loginMemberVO", loginMemberVO);
			return "member/loginmember";
		}
		
		try {
			MemberVO memberVO = this.memberService.readMember(loginMemberVO);
			
			httpSession.setAttribute("_LOGIN_USER", memberVO);
		}catch (IllegalArgumentException iae) {
			model.addAttribute("loginMemberVO", loginMemberVO);
			model.addAttribute("message", iae.getMessage());
			return "member/loginmember";
		}
		
		return "redirect:/todo/list";
	}
}
