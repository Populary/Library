package com.baosight.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/content")
public class UserController {
	

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String Welcome(Model model) {
		return "content/welcome";
	}
//	
//	@RequestMapping(value = "/lending", method = RequestMethod.GET)
//	public String Welcome2(Model model) {
//		return "content/lending";
//	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		return "content/index";
	}

}
