package com.amolrang.modume.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user",method = RequestMethod.GET)
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/join",method = RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("viewPort","user/join");
		model.addAttribute("board","discord/discord");
		return "viewer/default";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("viewPort","user/login");
		model.addAttribute("board","discord/discord");
		return "viewer/default";
	}
	
}
