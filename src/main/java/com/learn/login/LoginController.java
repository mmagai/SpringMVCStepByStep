package com.learn.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	LoginService loginservice;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLoginPage() {

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginPage(@RequestParam String name, @RequestParam String password,
			ModelMap model) {

		if(!loginservice.validateUser(name, password)) {
			
			model.addAttribute("errorMessage", "InValid User Credentials");
			return "login";
			
		}
		model.addAttribute("name", name);
		model.addAttribute("password", password);
		
		return "welcome";
	}
}
