package com.ktdsuniversity.edu.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.ktdsuniversity.edu.member.service.MemberService;
import com.ktdsuniversity.edu.member.vo.RegistMemberVO;

import jakarta.validation.Valid;

public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/regist")
	public String viewRegistMemberPage() {
		return "member/registmember";
	}
	
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
}
