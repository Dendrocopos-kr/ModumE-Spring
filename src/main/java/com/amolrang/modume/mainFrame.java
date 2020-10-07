package com.amolrang.modume;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class mainFrame {
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainViewFrame(Model model) {
		//System.out.println("메인접근");
		model.addAttribute("title", "메인페이지");
		return "view/index";
	}
}
