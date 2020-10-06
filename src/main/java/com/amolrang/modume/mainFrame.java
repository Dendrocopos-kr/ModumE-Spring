package com.amolrang.modume;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class mainFrame {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String mainViewFrame(Model model) {
		model.addAttribute("viewPort", "main/main");
		model.addAttribute("board", "discord/discord");
		return "viewer/default";
	}
}
