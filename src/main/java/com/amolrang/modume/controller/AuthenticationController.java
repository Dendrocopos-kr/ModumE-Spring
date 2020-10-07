package com.amolrang.modume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginViewFrame(Model model) {
		System.out.println("로그인 페이지 get 접근");
		model.addAttribute("title", "로그인페이지");
		return "view/index";
	}
	
	@RequestMapping(value = "/loginAction", method = RequestMethod.POST)
	public String loginAction(Model model) {
		System.out.println("로그인 페이지 post 접근");
		model.addAttribute("title", "로그인 중 ...");
		
		return "redirect:view/index";
	}
	
}
