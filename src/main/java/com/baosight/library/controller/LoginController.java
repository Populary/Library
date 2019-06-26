package com.baosight.library.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.baosight.library.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/loginaction", method = RequestMethod.POST)
	public String loginaction(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model,HttpServletRequest httpServletRequest) {
		//HttpSession session = httpServletRequest.getSession();
		String dbpassword = userService.login(username);
		if (password.equals(dbpassword)) {
			//session.setAttribute("baosightlogin", "你好");
			httpServletRequest.getSession().setAttribute("baosightlogin", true);
			model.addAttribute("username", username);
			model.addAttribute("sign", "签到");
			return "content/index";
		} else {
			model.addAttribute("loginfail", true);
			return "login";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/layout", method = RequestMethod.GET)
	public String layout(HttpServletRequest httpServletRequest) {
		httpServletRequest.getSession().setAttribute("baosightlogin", false);
		return "login";
	}

}
