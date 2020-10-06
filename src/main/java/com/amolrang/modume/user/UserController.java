package com.amolrang.modume.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amolrang.modume.user.model.UserDMI;

@Controller
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("viewPort", "user/join");
		model.addAttribute("board", "discord/discord");
		return "viewer/default";
	}
	
	@RequestMapping(value = "/ajaxIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String ajaxIdChk(@RequestBody UserDMI param) {
		int result = service.login(param);
		return String.valueOf(result);
	}
}
