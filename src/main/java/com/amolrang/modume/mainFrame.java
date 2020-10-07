package com.amolrang.modume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class mainFrame {
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainViewFrame(Model model) {
		//System.out.println("메인접근");
		model.addAttribute("title", "메인페이지");
		return "view/index";
	}
}
