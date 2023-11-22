package com.example.demo.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	// http://localhost:7080/user/sign-in-view
	@GetMapping("/sign-in-view")
	public String signInView(Model model) {
		model.addAttribute("viewName", "user/signIn");
		return "template/easycook";
	}
	// http://localhost:7080/user/sign-up-view
	@GetMapping("/sign-up-view")
	public String signUpView(Model model) {
		model.addAttribute("viewName", "user/signUp");
		return "template/easycook";
	}
	
	@GetMapping("/user/profile-modify")
	public String profileModify(Model model) {
		model.addAttribute("viewName", "user/profileModify");
		return "template/easycook";
	}

}
